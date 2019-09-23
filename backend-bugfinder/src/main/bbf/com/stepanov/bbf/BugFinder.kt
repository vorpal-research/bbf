package com.stepanov.bbf

import com.intellij.psi.PsiFile
import com.stepanov.bbf.executor.*
import com.stepanov.reduktor.parser.PSICreator
import com.stepanov.bbf.mutator.transformations.Transformation
import org.apache.log4j.Logger
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory
import com.stepanov.bbf.executor.compilers.JSCompiler
import com.stepanov.bbf.executor.compilers.JVMCompiler
import com.stepanov.bbf.manager.BugManager
import com.stepanov.bbf.manager.BugType
import com.stepanov.bbf.mutator.Mutator
import com.stepanov.bbf.tracer.Tracer
import com.stepanov.bbf.util.BBFProperties
import com.stepanov.bbf.util.checkCompilingForAllBackends
import java.io.File
import com.stepanov.bbf.util.getRandomVariableName
import java.util.*

class BugFinder(private val path: String) : Runnable {

    override fun run() {
        findBugsInFile()
    }

    fun findBugsInFile() {
        try {
            ++counter
            log.debug("Name = $path")
            val text = File(path).readText()
//            val forInit = PSICreator("").getPSIForFile(path, false)
//            Transformation.file = forInit
//            MutationChecker.factory = KtPsiFactory(forInit.project)
//            MutationChecker.checkTextCompiling(forInit.text)
//            System.exit(0)
            //if (text.contains("assert")) return
            //if (text.contains("IGNORE_BACKEND") || text.contains("TARGET_BACKEND") || text.contains("package")) return

            val psiCreator = PSICreator("")
            val psiFile =
                    try {
                        psiCreator.getPSIForFile(path)
                    } catch (e: Throwable) {
                        return
                    }
            //Init compilers
            val compilersConf = BBFProperties.getStringGroupWithoutQuotes("BACKENDS")
            compilersConf.filter { it.key.contains("JVM") }.forEach { compilers.add(JVMCompiler(it.value))}
            compilersConf.filter { it.key.contains("JS") }.forEach { compilers.add(JSCompiler(it.value))}

            //Init lateinit vars
            Transformation.file = psiFile
            MutationChecker.factory = KtPsiFactory(psiFile.project)
            MutationChecker.compilers = compilers

            //Check for compiling
            if (!compilers.checkCompilingForAllBackends(psiFile)) {
                log.debug("Could not compile $path")
                return
            }
            log.debug("Start to mutate")

            Mutator(psiFile, psiCreator.ctx, compilers).startMutate()
            if (!compilers.checkCompilingForAllBackends(psiFile)) {
                log.debug("Could not compile after mutation $path")
                log.debug(psiFile.text)
            }
            log.debug("Mutated = ${psiFile.text}")

            //Save mutated file
            if (CompilerArgs.shouldSaveMutatedFiles) {
                val pathToSave = "${CompilerArgs.baseDir}/${Random().getRandomVariableName(10)}.kt"
                File(pathToSave).writeText(psiFile.text)
            }

            //Now begin to trace mutated file
            val mutatedFile = PSICreator("").getPSIForText(psiFile.text)
            val tracer = Tracer(mutatedFile, psiCreator.ctx)
            val traced = tracer.trace()
            log.debug("Traced = ${traced}")
            if (!compilers.checkCompilingForAllBackends(traced)) {
                log.debug("Could not compile after tracing $path")
                log.debug(traced.text)
            }

            val res = TracesChecker(compilers).checkTest(traced.text)
            if (res) {
                val pathToSaveRes = CompilerArgs.resultsDir + "diffBehavior/${Random().getRandomVariableName(7)}.kt"
                File(pathToSaveRes).writeText(traced.text)
                BugManager.saveBug("", "", traced.text, BugType.DIFFBEHAVIOR)
            }
            return
        } catch (e: Error) {
            println("ERROR: $e")
            System.exit(0)
        }
    }

    val bugs = mutableMapOf<String, KtFile>()
    private val compilers: MutableList<CommonCompiler> = mutableListOf()
    var counter = 0
    private val log = Logger.getLogger("bugFinderLogger")
}