package com.stepanov.bbf.mutator.transformations

import com.stepanov.bbf.executor.MutationChecker
import java.util.*

class ChangeRandomLines : Transformation() {

    override fun transform() {
        val text = file.text.lines().toMutableList()
        for (i in 0..Random().nextInt(shuffleConst)) {
            val numLine = Random().nextInt(text.size)
            val insLine = Random().nextInt(text.size)
            Collections.swap(text, numLine, insLine)
            if (!MutationChecker.checkTextCompiling(getText(text))) {
                Collections.swap(text, numLine, insLine)
            }
        }
        file = psiFactory.createFile(getText(text))
    }

    private fun getText(text: MutableList<String>) = text.joinToString(separator = "\n")

    private val shuffleConst = file.text.lines().size * 4
}