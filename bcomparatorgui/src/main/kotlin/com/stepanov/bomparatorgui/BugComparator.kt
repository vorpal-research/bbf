package com.stepanov.bomparatorgui

import com.stepanov.bbf.executor.CommonCompiler
import com.stepanov.bbf.util.FilterDuplcatesCompilerErrors
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch
import java.util.*

class BugComparator(private val path1: String, private val path2: String, private val compiler: CommonCompiler) {

    fun compare(): Pair<LinkedList<DiffMatchPatch.Diff>?, Pair<Double, Double>> {
        val p1 = "/home/stepanov/Kotlin/backend-bugfinder/tmp/results/jvmCompilerErrors/test/wnorl.kt"
        val p2 = "/home/stepanov/Kotlin/backend-bugfinder/tmp/results/jvmCompilerErrors/test/whenInUnreachbleFun.kt"
        val text1 = compiler.getErrorMessage(path1)
        val text2 = compiler.getErrorMessage(path2)
        val patch = DiffMatchPatch()
        val res = patch.diffMain(text1, text2)
        return res to FilterDuplcatesCompilerErrors.getK(path1, path2, compiler)
    }

}