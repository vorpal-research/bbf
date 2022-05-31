package com.stepanov.bbf.mutator.transformations

import com.stepanov.bbf.executor.MutationChecker
import com.stepanov.bbf.util.getAllChildrenOfTheLevel
import com.stepanov.bbf.util.getAllPSIChildrenOfType
import com.stepanov.bbf.util.getRandomBoolean
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.psiUtil.parents

//Change extension to smth?
class ChangeSmthToExtension : Transformation() {

    override fun transform() {
        file.getAllPSIChildrenOfType<KtProperty>()
                .filter { it.parents.any { p -> p is KtClass } /*&& getRandomBoolean(2)*/ }
                .forEach { property ->
                    val kl = property.parents.find { p -> p is KtClass } ?: return@forEach
                    val klass = kl as KtClass
                    val newProp = if (!property.isVar) {
                        psiFactory.createProperty("val ${klass.name}.${property.name} get() = ${property.initializer?.text}")
                    } else {
                        psiFactory.createProperty("var ${klass.name}.${property.name} get() = ${property.initializer?.text} \n set(value) = TODO()")
                    }
                    val children = property.node.getAllChildrenOfTheLevel(1)
                    children.forEach { file.node.removeChild(it) }
                    //file.node.removeChild(property.node)
                    klass.parent.node.addChild(newProp.node, null)
                    klass.parent.node.addChild(psiFactory.createWhiteSpace("\n").node, null)
                    if (!MutationChecker.checkCompiling(file)) {
                        children.forEach { it1 -> property.node.addChild(it1, null) }
                        file.node.removeChild(newProp.node)
                    } else {
                        file.node.removeChild(property.node)
                    }
                    //file.node.removeChild(property.node)
                    //klass.parent.node.addChild(newProp.node)
                    //klass.parent.node.addChild(psiFactory.createWhiteSpace("\n").node)
                    //if (!MutationChecker.checkCompiling(file))
                    //    file = oldFile
                }
        // Make functions as extensions
        file.getAllPSIChildrenOfType<KtNamedFunction>()
                .filter { it.parents.any { p -> p is KtClass } && getRandomBoolean(2) }
                .forEach { function ->
                    val kl = function.parents.find { p -> p is KtClass } ?: return@forEach
                    val klass = kl as KtClass
                    val split = function.text.split("fun ")
                    val newText = "${split[0]} fun ${klass.name}.${split.subList(1, split.size).joinToString()}"
                    val newFun = psiFactory.createFunction(newText)
                    //val oldFile = file.copy() as KtFile
                    val children = function.node.getAllChildrenOfTheLevel(1)
                    children.forEach { file.node.removeChild(it) }
                    //file.node.removeChild(function.node)
                    klass.parent.node.addChild(newFun.node, null)
                    klass.parent.node.addChild(psiFactory.createWhiteSpace("\n").node, null)
                    if (!MutationChecker.checkCompiling(file)) {
                        children.forEach { it1 -> function.node.addChild(it1, null) }
                        file.node.removeChild(newFun.node)
                    } else {
                        file.node.removeChild(function.node)
                    }
                }
    }
}
