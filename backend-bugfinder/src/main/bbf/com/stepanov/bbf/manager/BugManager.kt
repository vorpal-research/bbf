package com.stepanov.bbf.manager

enum class BugType {
    BACKEND,
    FRONTEND,
    DIFFBEHAVIOR,
    UNKNOWN
}

data class Bug(val compilerVersion: String, val msg: String, val crashingCode: String, val type: BugType) {

    fun compareTo(other: Bug): Int =
            if (compilerVersion == other.compilerVersion)
                type.compareTo(other.type)
            else compilerVersion.compareTo(other.compilerVersion)

}


object BugManager {

    val bugs = mutableListOf<Bug>()

    fun saveBug(compilerVersion: String, msg: String, crashingCode: String, type: BugType = BugType.UNKNOWN, shouldDump: Boolean = false) {
        val bug =
                if (type == BugType.UNKNOWN)
                    Bug(compilerVersion, msg, crashingCode, parseTypeOfBugByMsg(msg))
                else
                    Bug(compilerVersion, msg, crashingCode, type)
        bugs.add(bug)

        if (shouldDump) {
            //Report bugs
            if (ReportProperties.getPropAsBoolean("TEXT_REPORTER") == true) {
                TextReporter.dump(bugs)
            }
            if (ReportProperties.getPropAsBoolean("FILE_REPORTER") == true) {
                FileReporter.dump(listOf(bug))
            }
        }
    }

    private fun parseTypeOfBugByMsg(msg: String): BugType =
            if (msg.contains("Exception while analyzing expression"))
                BugType.FRONTEND
            else
                BugType.BACKEND


}

