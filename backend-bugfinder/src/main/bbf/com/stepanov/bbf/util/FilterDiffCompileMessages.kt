package com.stepanov.bbf.util

object FilterDiffCompileMessages {

    fun checkIfNormalBehavior(jvmMsg: String, jsMsg: String, nativeMsg: String): Boolean {
        if (jvmMsg.contains("Unresolved") || jsMsg.contains("Unresolved") || nativeMsg.contains("Unresolved")
                || jvmMsg.contains("External", true)
                || jvmMsg.contains("Platform declaration clash", true)
                || jsMsg.contains("Type of the constant expression cannot be resolved")
                || jsMsg.contains("clashes with another declaration")
                || nativeMsg.contains("Could not find")
                || (jvmMsg.isEmpty() && jsMsg.isEmpty() && nativeMsg.isEmpty()))
            return true
        return false
    }
}