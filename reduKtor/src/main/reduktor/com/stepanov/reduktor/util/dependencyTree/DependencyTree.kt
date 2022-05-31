package com.stepanov.reduktor.util.dependencyTree

import org.jetbrains.kotlin.psi.KtFile

open class DependencyTree<T> {

    fun addParentToClassNode(typeNode: T, parent: T) {
        getOrAddNode(typeNode).addParent(getOrAddNode(parent))
    }

    fun addChildToClassNode(typeNode: T, child: T) {
        getOrAddNode(typeNode).addChild(getOrAddNode(child))
    }

    fun getOrAddNode(typeNode: T): TreeNode<T> {
        return if (contains(typeNode)) {
            nodes.find { it.typeNode == typeNode }!!
        } else {
            val node = TreeNode(typeNode)
            nodes.add(node)
            node
        }
    }

    open fun constructTree(projectFiles: List<KtFile>) {}

    fun contains(a: T): Boolean = nodes.any { it.typeNode == a }

    fun find(a: T): T? = nodes.find { it.typeNode == a }?.typeNode
    fun findNode(a: T): TreeNode<T>? = nodes.find { it.typeNode == a }

    val nodes = mutableListOf<TreeNode<T>>()
}

data class TreeNode<T>(var typeNode: T) {
    fun getChildren(): HashSet<TreeNode<T>> = children
    fun getParents(): HashSet<TreeNode<T>> = parents

    fun addChild(node: TreeNode<T>) = children.add(node)
    fun addParent(node: TreeNode<T>) = parents.add(node)

    private var children = HashSet<TreeNode<T>>()
    private var parents = HashSet<TreeNode<T>>()
}