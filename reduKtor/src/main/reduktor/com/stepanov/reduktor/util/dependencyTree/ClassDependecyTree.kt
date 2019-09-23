package com.stepanov.reduktor.util.dependencyTree

import com.stepanov.reduktor.util.getAllPSIChildrenOfType
import com.stepanov.reduktor.util.getAllParentsWithoutNode
import com.stepanov.reduktor.util.getClassWithName
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtTypeReference
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType

class ClassDependencyTree : DependencyTree<KtClass>() {

    override fun constructTree(projectFiles: List<KtFile>) {
        val classes = mutableListOf<KtClass>()
        for (f in projectFiles) {
            f.getAllPSIChildrenOfType<KtClass>().forEach { classes.add(it) }
        }
        for (c in classes) {
            val classFile = c.getParentOfType<KtFile>(true) ?: continue
            if (c.superTypeListEntries.isEmpty()) {
                getOrAddNode(c)
                continue
            }
            c.superTypeListEntries.forEach {
                //Try to find in imports
                var name = it.getAllPSIChildrenOfType<KtTypeReference>().first().text
                val inImport = classFile.importDirectives.find { import -> import.importedFqName?.shortName()?.asString() == name }
                if (inImport != null) {
                    name = inImport.importPath?.pathStr
                } else {
                    if (!classFile.packageFqName.isRoot) {
                        if (name.contains('.'))
                            name = name.substring(name.lastIndexOf('.') + 1)
                        var fullName = classFile.packageFqName.asString() + "."
                        c.node.getAllParentsWithoutNode()
                                .filter { it.psi is KtClass }
                                .map { it.psi as KtClass }
                                .asReversed()
                                .forEach {
                                    if (it.name == name)
                                        return@forEach
                                    fullName += it.name + "."
                                }
                        fullName += name
                        name = fullName
                    }
                }
                while (true) {
                    val foundClass = getClassWithName(projectFiles, name)
                    if (foundClass == null) {
                        //Try to find class on prev level
                        val split = name.split('.')
                        if (split.contains("") || split.size < 2)
                            break
                        else {
                            name = split.subList(0, split.size - 2).joinToString(".", postfix = ".") + split.last()
                            if (name.first() == '.') name = name.drop(1)
                        }
                    } else {
                        addParentToClassNode(c, foundClass)
                        addChildToClassNode(foundClass, c)
                        break
                    }
                }
            }
        }
    }
}
