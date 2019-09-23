package com.stepanov.reduktor.util

import java.util.*

object PeepholeRegexes {

    //Regex and replacing
    val regexes = mutableMapOf(
            Pair(Regex("""\^="""), "="),
            Pair(Regex("""\|="""), "="),
            Pair(Regex("""\s*\+=\s*1"""), "++"),
            Pair(Regex("""\s*-=\s*1"""), "--"),
            Pair(Regex("""\+="""), "="),
            Pair(Regex("""-="""), "="),
            Pair(Regex("""\*="""), "="),
            Pair(Regex("""/="""), "="),
            Pair(Regex("""%="""), "="),
            Pair(Regex("""\^="""), "="),
            Pair(Regex("""while"""), "if")
    )

    val del_regexes = mutableMapOf(
            Pair(Regex("""\s*=\s*[0-9]+"""), " = 0"),
            Pair(Regex("""\s*=\s*[0-9]+"""), " = 1"),
            Pair(Regex("""\d+"""), "0"),
            Pair(Regex("""\d+"""), "1")
            //Change types on int?
            //Call expression to zero
    )

    val reg_toReg = mapOf(
            Pair(Regex("""\w+(\s*\+\s*\w+)+"""), Regex("""\w+""")),
            Pair(Regex("""\w+(\s*-\s*\w+)+"""), Regex("""\w+""")),
            Pair(Regex("""\w+(\s*\*\s*\w+)+"""), Regex("""\w+""")),
            Pair(Regex("""\w+(\s*/\s*\w+)+"""), Regex("""\w+""")),
            Pair(Regex("""\".+\"?(\s*\+\s*\"+\w+\"+)+"""), Regex("""\"[^\"]+\"""")),
            Pair(Regex("""\".+\"?(\s*\-\s*\"+\w+\"+)+"""), Regex("""\"[^\"]+\"""")),
            Pair(Regex("""\".+\"?(\s*\*\s*\"+\w+\"+)+"""), Regex("""\"[^\"]+\"""")),
            Pair(Regex("""\".+\"?(\s*/\s*\"+\w+\"+)+"""), Regex("""\"[^\"]+\""""))
    )


}