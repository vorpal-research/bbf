package com.stepanov.reduktor.passes

import com.stepanov.reduktor.executor.CompilerTestChecker
import com.stepanov.reduktor.util.*
import com.stepanov.reduktor.util.dependencyTree.ClassDependencyTree
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType

class SimplifyInheritance(private val file: KtFile, private val checker: CompilerTestChecker) {

    fun transform(projectFiles: List<KtFile> = listOf(file)) {
        fileCopy = file
        val classes = mutableListOf<KtClass>()
        for (f in projectFiles) {
            f.getAllPSIChildrenOfType<KtClass>().forEach { classes.add(it) }
        }
        tree = ClassDependencyTree()
        tree.constructTree(projectFiles)
        //classNodes.forEach { println("NAME = ${it.klass.name} \n CH = ${it.getChildren().map { it.klass.name }} \n PAR = ${it.getParents().map { it.klass.name }}") }
        val classWithBug = file.getLine(checker.getErrorInfo().line)?.psi?.getParentOfType<KtClass>(true)
        if (classWithBug != null) {
            tryToSimplifyInheritance(tree.getOrAddNode(classWithBug).typeNode)
        } else {
            return
        }
    }

    private fun tryToSimplifyInheritance(klass: KtClass) {
        klass.superTypeListEntries.forEach {
            val isDelegate = it is KtDelegatedSuperTypeEntry
            val isCall = it is KtSuperTypeCallEntry
            if (!isDelegate && !isCall) {
                val del = KtPsiFactory(fileCopy.project).createClass("class A:${it.text} by TODO()")
                        .superTypeListEntries.first() as KtDelegatedSuperTypeEntry
                val copy = it.copy()
                it.replaceThis(del)
                if (!checker.checkTest(fileCopy.text))
                    del.replaceThis(copy)
            } else if (isCall) {
                val old = klass.getSuperTypeList()!!.copy()
                klass.removeSuperTypeListEntry(it)
                if (!checker.checkTest(fileCopy.text)) {
                    if (klass.getSuperTypeList() != null) {
                        klass.getSuperTypeList()!!.replaceThis(old)
                    }
                    else {
                        val entry = KtPsiFactory(file.project).createSuperTypeCallEntry(it.text)
                        klass.addSuperTypeListEntry(entry)
                    }
                }
            }
        }
        //Now make abstract properties open and init by todo
        klass.getProperties()
                .filter { it.modifierList?.hasModifier(KtTokens.ABSTRACT_KEYWORD) ?: false }
                .forEach {
                    val oldProp = it.copy() as KtProperty
                    val abstractMod = it.modifierList?.getModifier(KtTokens.ABSTRACT_KEYWORD)!!
                    val openMod = KtPsiFactory(fileCopy.project).createModifier(KtTokens.OPEN_KEYWORD)
                    val todoExp = KtPsiFactory(fileCopy.project).createExpression("TODO()")
                    abstractMod.replaceThis(openMod)
                    it.initializer = todoExp
                    if (!checker.checkTest(fileCopy.text))
                        it.replaceThis(oldProp)
                }
        //Try to init funcs and properties by todo
        klass.getProperties()
                .filter { it.modifierList?.hasModifier(KtTokens.OVERRIDE_KEYWORD) ?: false }
                .forEach {
                    val newInit = KtPsiFactory(fileCopy.project).createExpression("TODO()")
                    val oldProp = it.copy()
                    it.initializer = newInit
                    if (!checker.checkTest(fileCopy.text))
                        it.replaceThis(oldProp)
                }
        klass.getAllPSIChildrenOfType<KtNamedFunction>()
                .filter { it.modifierList?.hasModifier(KtTokens.OVERRIDE_KEYWORD) ?: false }
                .filter { it.hasBody() }
                .forEach {
                    val oldFun = it.copy() as KtNamedFunction
                    if (it.hasBlockBody()) {
                        val eq = KtPsiFactory(fileCopy.project).createEQ()
                        val space = KtPsiFactory(fileCopy.project).createWhiteSpace(" ")
                        val todo = KtPsiFactory(fileCopy.project).createExpression("TODO()")
                        it.node.removeChild(it.bodyExpression!!.node)
                        it.add(eq)
                        it.add(space)
                        it.add(todo)
                    } else {
                        val todo = KtPsiFactory(fileCopy.project).createExpression("TODO()")
                        it.bodyExpression!!.replaceThis(todo)
                    }
                    if (!checker.checkTest(fileCopy.text))
                        it.replaceThis(oldFun)
                }
        tree.getOrAddNode(klass).getParents()
                .filter { it.typeNode.name != klass.name }
                .forEach { tryToSimplifyInheritance(it.typeNode) }
    }


    lateinit var tree: ClassDependencyTree
    private lateinit var fileCopy: KtFile
}
