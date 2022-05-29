package com.stepanov.bbf

import com.intellij.psi.PsiFile
import com.stepanov.bbf.executor.CommonCompiler
import com.stepanov.bbf.executor.DiffBehaviorChecker
import com.stepanov.bbf.executor.DiffCompileChecker
import com.stepanov.bbf.executor.MultiCompilerCrashChecker
import com.stepanov.bbf.mutator.transformations.Transformation
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.manager.TransformationManager
import com.stepanov.reduktor.parser.PSICreator
import org.jetbrains.kotlin.psi.KtFile
import java.io.File

object Reducer {

    fun reduce(path: String, compiler: CommonCompiler, shouldSave: Boolean = false): List<PsiFile> {
        val f = File(path)
        val files = if (f.isDirectory) f.listFiles().toList() else listOf(f)
        val res = files.asSequence()
                .map { PSICreator("").getPSIForFile(it.absolutePath, false) }
                .map { Transformation.file = it; it }
                .map { reduceFile(it, MultiCompilerCrashChecker(compiler)) }
                .map {
                    if (shouldSave) {
                        saveFile(it)
                        it
                    } else it
                }
        return res.toList()
    }

    fun reduceDiffBehavior(pathToFile: String, compilers: List<CommonCompiler>, shouldSave: Boolean = false): String {
        val ktFile = PSICreator("").getPSIForFile(pathToFile, false)
        Transformation.file = ktFile
        val res = reduceFile(ktFile, DiffBehaviorChecker(compilers))
        if (shouldSave) saveFile(res)
        return res.text
    }

    fun reduceDiffCompile(pathToFile: String, compilers: List<CommonCompiler>, shouldSave: Boolean = false): String {
        val ktFile = PSICreator("").getPSIForFile(pathToFile, false)
        Transformation.file = ktFile
        val res = reduceFile(ktFile, DiffCompileChecker(compilers))
        if (shouldSave) saveFile(res)
        return res.text
    }

    private fun saveFile(f: PsiFile) {
        val pathToSave = StringBuilder(f.name)
        pathToSave.insert(pathToSave.indexOfLast { it == '/' }, "/minimized")
        File(pathToSave.toString().substringBeforeLast('/')).mkdirs()
        File("$pathToSave").run {
            writeText(f.text)
        }
    }

    private fun reduceFile(path: String, checker: CompilerTestChecker): KtFile {
        val psiFile = PSICreator("").getPSIForFile(path)
        return TransformationManager(listOf(psiFile)).doTransformationsForFile(psiFile, checker)
    }

    private fun reduceFile(file: KtFile, checker: CompilerTestChecker): KtFile {
        return TransformationManager(listOf(file)).doTransformationsForFile(file, checker)
    }


}