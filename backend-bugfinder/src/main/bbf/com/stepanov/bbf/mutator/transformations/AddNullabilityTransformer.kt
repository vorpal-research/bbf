package com.stepanov.bbf.mutator.transformations

import org.jetbrains.kotlin.psi.KtTypeReference
import com.stepanov.bbf.executor.MutationChecker
import com.stepanov.bbf.util.getAllPSIChildrenOfType

class AddNullabilityTransformer: Transformation() {

    override fun transform() {
        file.getAllPSIChildrenOfType<KtTypeReference>()
                .asSequence()
                .filterNot { it.textContains('?') }
                .map { addNullability(it) }
                .toList()
    }

    fun addNullability(ref: KtTypeReference) {
        val newRef = psiFactory.createTypeIfPossible("(${ref.typeElement?.text})?") ?: return
        MutationChecker.replacePSINodeIfPossible(file, ref, newRef)
    }

}