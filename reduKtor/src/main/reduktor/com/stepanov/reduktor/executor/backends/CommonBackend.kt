package com.stepanov.reduktor.executor.backends

import com.stepanov.reduktor.executor.KotlincInvokeStatus

interface CommonBackend {
    fun tryToCompile(path: String): KotlincInvokeStatus
}