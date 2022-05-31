package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.allChildren

class SimplifyFunAndProp(private val file: KtFile, private val checker: CompilerTestChecker) {

    fun transform() {
        file.importList?.let {
            it.allChildren.toList().forEach { im ->
                if (im !is KtImportDirective)
                    return@forEach
                checker.removeNodeIfPossible(file, im.node)
            }
        }
        val funcs = file.getAllPSIChildrenOfType<KtNamedFunction>()
        val funcsToTransform = funcs
                .sortedByDescending { it.textLength }
                .filterNot { it.bodyExpression?.text?.contains("TODO()") ?: false }
                .filter { it.bodyExpression?.text?.isNotBlank() ?: false }
        for (f in funcsToTransform) {
            val copy = f.copy()
            if (!checker.removeNodeIfPossible(file, f.node)) {
                f.initBodyByTODO(psiFactory)
                f.checkAndReplaceBackIfError(checker, file, copy)
            }
        }
        val props = file.getAllPSIChildrenOfType<KtProperty>().toMutableList()
        //Kostyl for property in property
        val propsToRemove = mutableListOf<KtProperty>()
        props.forEach { property ->
            property.node.getAllChildrenNodes().find { it.psi is KtProperty }?.let {
                propsToRemove.add(it.psi as KtProperty)
            }
        }
        props.removeIf { propsToRemove.contains(it) || it.initializer == null }
        for (p in props) {
            val copy = p.copy()
            if (!checker.removeNodeIfPossible(file, p.node)) {
                p.initByTODO(psiFactory)
                p.checkAndReplaceBackIfError(checker, file, copy)
            }
        }
    }

    val psiFactory = KtPsiFactory(file.project)
}