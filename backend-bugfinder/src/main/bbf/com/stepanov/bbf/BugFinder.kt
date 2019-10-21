package com.stepanov.bbf

import com.stepanov.bbf.executor.CommonCompiler
import com.stepanov.bbf.executor.CompilerArgs
import com.stepanov.bbf.executor.MutationChecker
import com.stepanov.bbf.executor.TracesChecker
import com.stepanov.bbf.executor.compilers.JSCompiler
import com.stepanov.bbf.executor.compilers.JVMCompiler
import com.stepanov.bbf.manager.BugManager
import com.stepanov.bbf.manager.BugType
import com.stepanov.bbf.mutator.Mutator
import com.stepanov.bbf.mutator.transformations.Transformation
import com.stepanov.bbf.tracer.Tracer
import com.stepanov.bbf.util.BBFProperties
import com.stepanov.bbf.util.checkCompilingForAllBackends
import com.stepanov.bbf.util.getRandomVariableName
import com.stepanov.reduktor.parser.PSICreator
import org.apache.log4j.Logger
import org.jetbrains.kotlin.psi.KtPsiFactory
import java.io.File
import java.util.*

class BugFinder(private val path: String) : Runnable {

    override fun run() {
        findBugsInFile()
    }

    fun findBugsInFile() {
        try {
            println("Let's go")
            ++counter
            log.debug("Name = $path")
            val psiCreator = PSICreator("")
            val psiFile =
                    try {
                        psiCreator.getPSIForFile(path)
                    } catch (e: Throwable) {
                        return
                    }

            //Init compilers
            val compilersConf = BBFProperties.getStringGroupWithoutQuotes("BACKENDS")
            compilersConf.filter { it.key.contains("JVM") }.forEach { compilers.add(JVMCompiler(it.value)) }
            compilersConf.filter { it.key.contains("JS") }.forEach { compilers.add(JSCompiler(it.value)) }

            val filterBackends = compilersConf.map { it.key }
            val ignoreBackendsFromFile =
                    psiFile.text.lineSequence()
                            .filter { it.startsWith("// IGNORE_BACKEND:") }
                            .map { it.substringAfter("// IGNORE_BACKEND:") }
                            .map { it.split(",") }
                            .flatten()
                            .map { it.trim() }
                            .toList()
            if (ignoreBackendsFromFile.any { filterBackends.contains(it) }) {
                log.debug("Skipped because one of the backends is ignoring")
                return
            }

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
            log.debug("Traced = ${traced.text}")
            if (!compilers.checkCompilingForAllBackends(traced)) {
                log.debug("Could not compile after tracing $path")
                log.debug(traced.text)
            }

            val res = TracesChecker(compilers).checkTest(traced.text)
            log.debug("Result = $res")
            //Save into tmp file and reduce
            if (res != null) {
                File(CompilerArgs.pathToTmpFile).writeText(traced.text)
                val reduced =
                        if (CompilerArgs.shouldReduceDiffBehavior)
                            Reducer.reduceDiffBehavior(CompilerArgs.pathToTmpFile, compilers)
                        else
                            traced.text
                BugManager.saveBug(res.joinToString(separator = ","), "", reduced, BugType.DIFFBEHAVIOR)
            }
            return
        } catch (e: Error) {
            println("ERROR: $e")
            log.debug("ERROR: $e")
            return
            //System.exit(0)
        }
    }

    private val compilers: MutableList<CommonCompiler> = mutableListOf()
    var counter = 0
    private val log = Logger.getLogger("bugFinderLogger")
}