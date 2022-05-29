package com.stepanov.reduktor.passes.slicer

import com.intellij.psi.PsiElement
import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.getAllChildrenNodes
import com.stepanov.reduktor.util.getAllPSIChildrenOfType
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.getChildOfType

//Very simple class slicer
class ClassSlicer(private val checker: CompilerTestChecker) : KtVisitorVoid() {

    //TODO: maybe construct class tree?
    fun computeSlice(id: List<PsiElement>, file: KtFile) {
        identifiers = id.toMutableSet()
        newFile = file

        //Search for global variables
        file.getAllPSIChildrenOfType<KtProperty>()
                .map { it.accept(this) }

        file.getAllPSIChildrenOfType<KtClass>()
                .filter { it.name != null }
                .forEach { classNames.add(it.name!!) }

        file.getAllPSIChildrenOfType<KtClass>()
                .filter { klass -> identifiers.any { it.text == klass.name } }
                .map { klass -> klass.node.getAllChildrenNodes().filter { it.elementType == KtTokens.IDENTIFIER } }
                .forEach { ids -> ids.forEach { identifiers.add(it.psi) } }

        file.getAllPSIChildrenOfType<KtClass>()
                .map { it.accept(this) }
    }


    override fun visitProperty(property: KtProperty) {
        if (property.isTopLevel && identifiers.any { it.text == property.nameIdentifier?.text }) {
            if (property.hasInitializer()) {
                property.initializer!!.getChildOfType<KtReferenceExpression>()?.originalElement?.let { identifiers.add(it) }
            } else if (property.typeReference != null) {
                identifiers.add(property.typeReference!!.originalElement)
            }
        }
    }

    override fun visitClass(klass: KtClass) {
        if (identifiers.any { it.text == klass.name })
            return
        checker.removeNodeIfPossible(newFile, klass.node)
    }

    private val classNames = mutableListOf<String>()
    private var identifiers = mutableSetOf<PsiElement>()
    private lateinit var newFile: KtFile
}