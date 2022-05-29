package com.stepanov.bbf.manager

interface Reporter {
    fun dump(bugs: List<Bug>)
}