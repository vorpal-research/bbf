package com.stepanov.reduktor.util

import org.jetbrains.kotlin.psi.KtFile
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarInputStream
import java.util.jar.JarOutputStream

object RemoveSourcesFromJar {
    fun transform(targetFiles: List<KtFile>, pathToJar: String): JarFile {
        val jarStream = JarInputStream(FileInputStream(File(pathToJar)))
        val jarFile = JarFile(File(pathToJar))
        var entry: JarEntry? = jarStream.nextJarEntry
        val newPathToJar = pathToJar.dropLastWhile { it != '.' }.dropLast(1) + "-without-sources.jar"
        val newJarStream = JarOutputStream(FileOutputStream(File(newPathToJar)))

        while (entry != null) {
            val name = entry.name
            if (name.endsWith(".class")) {
                var pack = ""
                if (entry.name.contains('/')) {
                    pack = entry.name.take(entry.name.lastIndexOf('/')).replace('/', '.')
                } else {
                    pack = "<root>"
                }
                if (!targetFiles.any { it.packageFqName.asString() == pack }) {
                    addEntry(entry, jarFile, newJarStream)
                }
            } else {
                addEntry(entry, jarFile, newJarStream)
            }
            entry = jarStream.nextJarEntry
        }
        newJarStream.close()
        return JarFile(File(newPathToJar))
    }

    private fun addEntry(entry: JarEntry, jarFile: JarFile, newJarStream: JarOutputStream) {
        if (doneClasses.any { it.name == entry.name }) return
        val jarEntry = JarEntry(entry)
        jarEntry.compressedSize = -1
        newJarStream.putNextEntry(jarEntry)
        val inputStream = jarFile.getInputStream(entry)
        val byteArray = inputStream.readAllBytes()
        newJarStream.write(byteArray)
        newJarStream.closeEntry()
        doneClasses.add(entry)
        newJarStream.closeEntry()
    }

    private val doneClasses = mutableListOf<JarEntry>()
}