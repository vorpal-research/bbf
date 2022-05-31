package com.stepanov.reduktor.util

import java.io.File
import java.util.*

object ReduKtorProperties {

    private val file: File = File("bbf.conf")

    fun getPropValue(name: String): String? {
        val props = Properties()
        props.load(file.inputStream())
        return props.getProperty(name)
    }

    fun getStringGroup(groupName: String): Map<String, String> {
        val props = Properties()
        props.load(file.inputStream())
        return props.entries
                .map { it.key as String to it.value as String }
                .filter { it.first.startsWith(groupName) }
                .toMap()
                .mapKeys { k -> k.key.takeLastWhile { it != '.' } }
                .mapValues { it.value.drop(1).dropLast(1) }
    }

    fun getPropAsBoolean(name: String): Boolean? = getPropValue(name)?.toBoolean()
}