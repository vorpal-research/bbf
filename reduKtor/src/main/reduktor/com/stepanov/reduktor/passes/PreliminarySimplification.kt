package com.stepanov.reduktor.passes

import com.intellij.psi.PsiFile
import com.stepanov.reduktor.executor.backends.CommonBackend
import com.stepanov.reduktor.util.TaskType
import com.stepanov.reduktor.util.getAllPSIChildrenOfType
import com.stepanov.reduktor.util.startTasksAndSaveNewFiles
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.isSubpackageOf
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.allChildren
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType
import org.jetbrains.kotlin.resolve.ImportPath
import java.util.*


class PreliminarySimplification(private val ktFile: KtFile, private val projPath: String, private val backend: CommonBackend) {
    fun computeSlice(files: List<PsiFile> = listOf()) {
        //Get all imports of file
        //Map from node to import level

        val importsMap = linkedMapOf<PsiFile, Int>()
        val fileImports = getAllImportsFromFile(ktFile).toHashSet()
        var level = 1
        for (f in files.map { it as KtFile }) {
            f.beforeAstChange()
            starsExplosion(f.importDirectives, files)
        }
        while (true) {
            val oldImportsSize = importsMap.size
            for (f in files) {
                val kotFile = f as KtFile
                if (f == ktFile)
                    continue
                kotFile.beforeAstChange()
                if (kotFile.importDirectives.any { fileImports.any { it1 -> it.text == it1.text } }
                        && !importsMap.containsKey(f)) {
                    importsMap[f] = level
                }
            }
            for (i in importsMap) {
                if (i.value == level)
                    getAllImportsFromFile(i.key as KtFile).forEach { fileImports.add(it) }
            }
            if (oldImportsSize == importsMap.size)
                break
            ++level
        }
        level -= 1
        //Start to transform all needed files
        val transformedFiles = mutableListOf<KtFile>()
        val filesToTransform = mutableListOf<KtFile>()
        for (i in importsMap.keys.reversed()) {
            if (importsMap[i] == level) {
                filesToTransform.add(i as KtFile)
            } else {
                //Start transformations
                startTasksAndSaveNewFiles(filesToTransform, projPath, TaskType.TRANSFORM, backend)
                filesToTransform.forEach { transformedFiles.add(it) }
                --level
                filesToTransform.clear()
                filesToTransform.add(i as KtFile)
            }
        }
        //Last level
        startTasksAndSaveNewFiles(filesToTransform, projPath, TaskType.TRANSFORM, backend)
        filesToTransform.forEach { transformedFiles.add(it) }
        filesToTransform.clear()

        //Transform files from current package
        val packageFqName = ktFile.packageFqNameByTree
        files
                .map { it as KtFile }
                .filter { !transformedFiles.contains(it) }
                .filter { it != ktFile }
                .forEach {
                    if (it.packageFqNameByTree.isSubpackageOf(packageFqName))
                        filesToTransform.add(it)
                }
        startTasksAndSaveNewFiles(filesToTransform, projPath, TaskType.TRANSFORM, backend)
    }



    private fun getImport(fqName: FqName): KtImportDirective =
            KtPsiFactory(ktFile.project).createImportDirective(ImportPath(fqName, false))

    //CAREFUL!! TERRIBLE SHIT CODE HERE!!
    fun starsExplosion(imports: List<KtImportDirective>, files: List<PsiFile>): List<KtImportDirective> {
        for (i in imports) {
            if (i.isAllUnder) {
                val fqName = i.importPath?.fqName ?: continue
                val newImports = HashSet<KtImportDirective>()
                for (f in files) {
                    if (f.firstChild !is KtPackageDirective)
                        break
                    val packageDirective = f.allChildren.first as KtPackageDirective
                    if (packageDirective.text.contains(fqName.asString())) {
                        getClasses(f as KtFile).mapTo(newImports) { getImport(it.fqName!!) }
                        getObjects(f).mapTo(newImports) { getImport(it.fqName!!) }
                        getFunctions(f)
                                .filter {
                                    it.getParentOfType<KtClass>(false) == null
                                            && it.getParentOfType<KtObjectDeclaration>(false) == null
                                }
                                .mapTo(newImports) { getImport(it.fqName!!) }
                    }
                }
                if (newImports.isNotEmpty()) {
                    for (im in newImports) {
                        //TODO Check it
                        i.node.treeParent.addChild(im.node, null)
                        i.node.treeParent.addChild(KtPsiFactory(ktFile.project).createWhiteSpace("\n").node, null)
                    }
                    ktFile.node.removeChild(i.node)
                }
            }
        }
        return imports
    }

    private fun getAllImportsFromFile(file: KtFile): List<KtImportDirective> {
        val newImports = HashSet<KtImportDirective>()
        getClasses(file).mapTo(newImports) { getImport(it.fqName!!) }
        getObjects(file).mapTo(newImports) { getImport(it.fqName!!) }
        getFunctions(file)
                .filter {
                    it.getParentOfType<KtClass>(false) == null
                            && it.getParentOfType<KtObjectDeclaration>(false) == null
                }
                .mapTo(newImports) { getImport(it.fqName!!) }
        return newImports.toList()
    }


    private fun getClasses(file: KtFile): List<KtClass> =
            file.getAllPSIChildrenOfType<KtClass>().filter { it.fqName != null }

    private fun getObjects(file: KtFile): List<KtObjectDeclaration> =
            file.getAllPSIChildrenOfType<KtObjectDeclaration>().filter { it.fqName != null }

    private fun getFunctions(file: KtFile): List<KtNamedFunction> =
            file.getAllPSIChildrenOfType<KtNamedFunction>().filter { it.fqName != null }

}


