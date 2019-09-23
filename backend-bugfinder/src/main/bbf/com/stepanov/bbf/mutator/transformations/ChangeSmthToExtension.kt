package com.stepanov.bbf.mutator.transformations

import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.psiUtil.parents
import com.stepanov.bbf.executor.MutationChecker
import com.stepanov.bbf.util.getAllChildrenOfTheLevel
import com.stepanov.bbf.util.getAllPSIChildrenOfType
import com.stepanov.bbf.util.getRandomBoolean
import org.jetbrains.kotlin.psi.psiUtil.children

//Change extension to smth?
class ChangeSmthToExtension : Transformation() {

    override fun transform() {
        file.getAllPSIChildrenOfType<KtProperty>()
                .filter { it.parents.any { p -> p is KtClass } /*&& getRandomBoolean(2)*/ }
                .forEach {
                    val kl = it.parents.find { p -> p is KtClass } ?: return@forEach
                    val klass = kl as KtClass
                    val newProp = if (!it.isVar) {
                        psiFactory.createProperty("val ${klass.name}.${it.name} get() = ${it.initializer?.text}")
                    } else {
                        psiFactory.createProperty("var ${klass.name}.${it.name} get() = ${it.initializer?.text} \n set(value) = TODO()")
                    }
                    val children = it.node.getAllChildrenOfTheLevel(1)
                    children.forEach { file.node.removeChild(it) }
                    //file.node.removeChild(it.node)
                    klass.parent.node.addChild(newProp.node, null)
                    klass.parent.node.addChild(psiFactory.createWhiteSpace("\n").node, null)
                    if (!MutationChecker.checkCompiling(file)) {
                        children.forEach { it1 -> it.node.addChild(it1, null) }
                        file.node.removeChild(newProp.node)
                    } else {
                        file.node.removeChild(it.node)
                    }
                    //file.node.removeChild(it.node)
                    //klass.parent.node.addChild(newProp.node)
                    //klass.parent.node.addChild(psiFactory.createWhiteSpace("\n").node)
                    //if (!MutationChecker.checkCompiling(file))
                    //    file = oldFile
                }
        // Make functions as extensions
        file.getAllPSIChildrenOfType<KtNamedFunction>()
                .filter { it.parents.any { p -> p is KtClass } && getRandomBoolean(2) }
                .forEach {
                    val kl = it.parents.find { p -> p is KtClass } ?: return@forEach
                    val klass = kl as KtClass
                    val splitted = it.text.split("fun ")
                    val newText = "${splitted[0]} fun ${klass.name}.${splitted.subList(1, splitted.size).joinToString()}"
                    val newFun = psiFactory.createFunction(newText)
                    //val oldFile = file.copy() as KtFile
                    val children = it.node.getAllChildrenOfTheLevel(1)
                    children.forEach { file.node.removeChild(it) }
                    //file.node.removeChild(it.node)
                    klass.parent.node.addChild(newFun.node, null)
                    klass.parent.node.addChild(psiFactory.createWhiteSpace("\n").node, null)
                    if (!MutationChecker.checkCompiling(file)) {
                        children.forEach { it1 -> it.node.addChild(it1, null) }
                        file.node.removeChild(newFun.node)
                    } else {
                        file.node.removeChild(it.node)
                    }
                }
    }
}
