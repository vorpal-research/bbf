package com.stepanov.reduktor.executor.error

data class Error(val errorMessage: String) {

    var type: ErrorType
    var line = -1
    var position = -1

    init {
        if (errorMessage.contains(ErrorConstants.codegenError)) {
            type = ErrorType.CODEGEN
            val errorLinePosition = errorMessage.indexOf("File being compiled at position:")
            if (errorLinePosition != -1) {
                val tmp = errorMessage.substring(errorLinePosition)
                val errorSubstr = tmp.substring(0, tmp.indexOfFirst { it == '\n' })
                parseLocation(errorSubstr)
                if (pathToFile.isEmpty())
                    pathToFile = errorSubstr.substring(errorSubstr.indexOf("in ") + 3)
            }
        } else if (errorMessage.contains(ErrorConstants.analysisError)) {
            type = ErrorType.ANALYSIS
            val errorLinePosition = errorMessage.indexOf(ErrorConstants.analysisError)
            if (errorLinePosition != -1) {
                val tmp = errorMessage.substring(errorLinePosition)
                val errorSubstr = tmp.substring(0, tmp.indexOfFirst { it == '\n' })
                parseLocation(errorSubstr)
                if (pathToFile.isEmpty())
                    pathToFile = errorSubstr.substring(errorSubstr.indexOf("in ") + 3, errorSubstr.length - 1)
            }
        } else if (errorMessage.contains(ErrorConstants.illegalStateException)) {
            type = ErrorType.ILLEGAL_STATE
            parseLocation(errorMessage)
        } else if (errorMessage.contains(ErrorConstants.runtimeException)) {
            type = ErrorType.UNKNOWN
            val lastAt = errorMessage.split("\n").dropLast(1).last()
            line = Integer.parseInt(lastAt.substringAfter("(").substringBefore(")").substringAfter(":"))
        } else {
            type = ErrorType.UNKNOWN
            parseLocation(errorMessage)
        }
    }

    private fun parseLocation(errorSubstr: String) {
        val location = Regex("""\(\d+,\d+\)""").find(errorSubstr)?.value ?: ""
        if (location.isNotEmpty()) {
            line = Integer.parseInt(location.substring(1, location.indexOf(',')))
            position = Integer.parseInt(location.substring(location.indexOf(',') + 1, location.indexOf(')')))
        }
    }

    override fun toString(): String {
        val str = StringBuilder()
        str.append("Type = $type\n")
        str.append("File = $pathToFile\n")
        str.append("Position = ($line,$position)\n")
        return str.toString()
    }

    companion object {
        var pathToFile = ""

        fun initPath(pathToFile: String) {
            Companion.pathToFile = pathToFile
        }
    }

}

enum class ErrorType {
    CODEGEN, ANALYSIS, ILLEGAL_STATE, EXCEPTION, UNKNOWN
}