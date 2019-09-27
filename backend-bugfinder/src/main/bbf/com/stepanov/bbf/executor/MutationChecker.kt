package com.stepanov.bbf.executor

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.stepanov.bbf.Reducer
import com.stepanov.bbf.executor.CompilerArgs.shouldFilterDuplicateCompilerBugs
import com.stepanov.bbf.manager.BugManager
import com.stepanov.bbf.util.FilterDuplcatesCompilerErrors.simpleHaveDuplicatesErrors
import com.stepanov.bbf.util.getAllParentsWithoutNode
import com.stepanov.bbf.util.getRandomVariableName
import com.stepanov.reduktor.util.getAllChildrenNodes
import org.apache.log4j.Logger
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory
import java.io.File
import java.util.*

object MutationChecker {
    fun checkCompiling(file: KtFile): Boolean = checkTextCompiling(file.text)

    fun checkTextCompiling(text: String): Boolean {
        //Checking syntax correction
        val tree = factory.createFile(text)
        if (tree.node.getAllChildrenNodes().any { it.psi is PsiErrorElement })
            return false
        val compilersToStatus = compilers.map { it to it.checkCompilingText(text) }
        log.debug(compilersToStatus.joinToString (separator = " ") { "${it.first.compilerInfo} ${it.second}"})
//        val jvmComp = JVMCompiler()
//        val jvmStatus = jvmComp.checkCompilingText(text)
//        log.debug("JVM DONE")
//        val jsComp = JSCompiler()
//        val jsStatus = jsComp.checkCompilingText(text)
//        log.debug("JS DONE")
//        val nativeComp = NativeCompiler()
//        val nativeStatus = nativeComp.checkCompilingText(text)
//        log.debug("NATIVE DONE")
//        log.debug("STATUS: JVM = $jvmStatus JS = $jsStatus NATIVE = $nativeStatus")

        if (CompilerArgs.shouldSaveCompilerBugs) {
            //Saving text to tmp.kt
            val tmpPath = CompilerArgs.pathToTmpFile
            File(tmpPath).writeText(text)

            //Checking for compiler bug and if bug, then save
            compilers.forEach { compiler ->
                if (compiler.isCompilerBug(tmpPath)) {
                    log.debug("Found ${compiler.compilerInfo} BUG:\n Text:\n ${File(tmpPath).readText()}")
                    saveCompilerBug(tmpPath, compiler)
                }
            }
//            if (jvmComp.isCompilerBug(tmpPath)) {
//                saveCompilerBug(tmpPath, CompilerType.JVM)
//                isCompilerBug = true
//            }
//            if (jsComp.isCompilerBug(tmpPath)) {
//                saveCompilerBug(tmpPath, CompilerType.JS)
//                isCompilerBug = true
//            }
//            if (nativeComp.isCompilerBug(tmpPath)) {
//                saveCompilerBug(tmpPath, CompilerType.NATIVE)
//                isCompilerBug = true
//            }

            //TODO Handle this situation
//            if (!isCompilerBug && (jvmStatus != jsStatus || jsStatus != nativeStatus || jvmStatus != nativeStatus)
//                    && shouldSaveCompileDiff) {
//                log.debug("Found difference in js, jvm and native")
//                log.debug("STATUS: JVM = $jvmStatus JS = $jsStatus NATIVE = $nativeStatus")
//                val jvmErrorMsg = jvmComp.getErrorMessageForText(text)
//                val jsErrorMsg = jsComp.getErrorMessageForText(text)
//                val nativeErrorMsg = nativeComp.getErrorMessageForText(text)
//                log.debug("JVM Error message = $jvmErrorMsg")
//                log.debug("JS Error message = $jsErrorMsg")
//                log.debug("Native Error message = $nativeErrorMsg")
//                log.debug("Code:\n $text")
//                log.debug("\n\n\n")
//                if (!FilterDiffCompileMessages.checkIfNormalBehavior(jvmErrorMsg, jsErrorMsg, nativeErrorMsg)) {
//                    val name = Random().getRandomVariableName(7)
//                    val newPath = "${CompilerArgs.resultsDir}/justOneCompile/$name.kt"
//                    BufferedWriter(FileWriter(File(newPath))).apply { write(text); close() }
//                }
//            }
        }

        val isAccepted = compilersToStatus.map { it.second }.toSet().size == 1 && compilersToStatus.first().second
        if (isAccepted)
            log.debug("Mutation accepted")
        else
            log.debug("Mutation didnt accepted")
        return isAccepted
    }

    private fun saveCompilerBug(path: String, compiler: CommonCompiler) {
        log.debug("Trying to save ${compiler.compilerInfo} compiler bug\n Text: ${File(path).readText()}")
        val dir = compiler.compilerInfo.filter { it != ' ' }
//        val dir = "jvmCompilerErrors"
//        val dir = when (compiler) {
//            CompilerType.NATIVE -> "nativeCompilerErrors"
//            CompilerType.JVM -> "jvmCompilerErrors"
//            CompilerType.JS -> "jsCompilerErrors"
//        }
//        val comp = when (compiler) {
//            CompilerType.NATIVE -> NativeCompiler()
//            CompilerType.JVM -> JVMCompiler()
//            CompilerType.JS -> JSCompiler()
//        }

        //Generating new name
        val num = Random().getRandomVariableName(5)
        val resDir = CompilerArgs.resultsDir
        val newPath =
                if (resDir.endsWith('/')) "${CompilerArgs.resultsDir}$dir/$num.kt"
                else "${CompilerArgs.resultsDir}/$dir/$num.kt"
        File(newPath.substringBeforeLast('/')).mkdirs()
        val tmpDir = newPath.substringBeforeLast('/')

        val reduced = Reducer.reduce(path, compiler).first()
        log.debug("Reduced = ${reduced.text}")
        File(path).writeText(reduced.text)
        if (!compiler.isCompilerBug(path)) {
            log.debug("It's not a bug more =(")
            return
        }

        val oldText = reduced.text

        log.debug("TRYING TO FIND DUPLICATE in $tmpDir")
        if (shouldFilterDuplicateCompilerBugs && simpleHaveDuplicatesErrors(path, tmpDir, compiler)) {
            log.debug("Found duplicates")
        } else {
            File(newPath).writeText(oldText)
            BugManager.saveBug(compiler.compilerInfo, compiler.getErrorMessage(newPath), oldText, shouldDump = true)
        }
    }

    fun replacePSINodeIfPossible(file: KtFile, node: PsiElement, replacement: PsiElement) =
            replaceNodeIfPossible(file, node.node, replacement.node)

    fun replaceNodeIfPossible(file: KtFile, node: ASTNode, replacement: ASTNode): Boolean {
        if (node.text.isEmpty() || node == replacement) return checkCompiling(file)
        for (p in node.getAllParentsWithoutNode()) {
            try {
                if (node.treeParent.elementType.index == DUMMY_HOLDER_INDEX) continue
                val oldText = file.text
                val replCopy = replacement.copyElement()
                p.replaceChild(node, replCopy)
                if (oldText == file.text)
                    continue
                if (!checkCompiling(file)) {
                    p.replaceChild(replCopy, node)
                    return false
                } else {
                    return true
                }
            } catch (e: AssertionError) {
            }
        }
        return false
    }

    fun addNodeIfPossible(file: KtFile, anchor: PsiElement, node: PsiElement, before: Boolean = false): Boolean {
        if (node.text.isEmpty() || node == anchor) return checkCompiling(file)
        try {
            val addedNode =
                    if (before) anchor.parent.addBefore(node, anchor)
                    else anchor.parent.addAfter(node, anchor)
            if (checkCompiling(file)) return true
            file.node.removeChild(addedNode.node)
            return false
        } catch (e: Throwable) {
            return false
        }
    }

    fun addNodeIfPossible(file: KtFile, anchor: ASTNode, node: ASTNode, before: Boolean = false): Boolean =
            addNodeIfPossible(file, anchor.psi, node.psi, before)

    lateinit var factory: KtPsiFactory
    lateinit var compilers: List<CommonCompiler>
    private const val DUMMY_HOLDER_INDEX: Short = 86
    private val log = Logger.getLogger("mutatorLogger")

}