package com.stepanov.bbf.mutator.transformations

import com.stepanov.bbf.executor.MutationChecker
import java.util.*

class RemoveRandomLines: Transformation()  {

    override fun transform() {
        val text = file.text.lines().toMutableList()
        for (i in 0..Random().nextInt(removeConst)) {
            val numLine = Random().nextInt(text.size)
            val old = text[numLine]
            text[numLine] = ""
            if (!MutationChecker.checkTextCompiling(getText(text))) {
                text[numLine] = old
            }
        }
        file = psiFactory.createFile(getText(text))
    }

    private fun getText(text: MutableList<String>) = text.joinToString(separator = "\n")

    private val removeConst = file.text.lines().size * 2
}