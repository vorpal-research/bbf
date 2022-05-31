package com.stepanov.reduktor.parser

import com.intellij.lang.java.JavaLanguage
import com.intellij.mock.MockProject
import com.intellij.openapi.extensions.ExtensionPoint
import com.intellij.openapi.util.Disposer
import com.intellij.pom.PomModel
import com.intellij.pom.PomTransaction
import com.intellij.pom.core.impl.PomModelImpl
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.impl.source.tree.TreeCopyHandler
import org.jetbrains.kootstrap.FooBarCompiler.setupMyCfg
import org.jetbrains.kootstrap.util.Opt
import org.jetbrains.kootstrap.util.targetRoots
import org.jetbrains.kotlin.cli.jvm.compiler.EnvironmentConfigFiles
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.js.analyze.TopDownAnalyzerFacadeForJS
import org.jetbrains.kotlin.js.config.JSConfigurationKeys
import org.jetbrains.kotlin.js.config.JsConfig
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.CompilerEnvironment
import java.io.File


class PSICreator(var projectDir: String) {

    fun getPSI(): List<KtFile> {
        val newArgs = arrayOf("-t", projectDir)

        val cmd = Opt.parse(newArgs)
        cfg = setupMyCfg(cmd)
        env = setupMyEnv(cfg)

        if (!env.project.extensionArea.hasExtensionPoint(TreeCopyHandler.EP_NAME.name)) {
            env.project.extensionArea.registerExtensionPoint(
                    TreeCopyHandler.EP_NAME.name,
                    TreeCopyHandler::class.java.canonicalName,
                    ExtensionPoint.Kind.INTERFACE
            )
        }

        val ktFiles = env.getSourceFiles().map {
            val f = KtPsiFactory(it).createFile(it.virtualFile.path, it.text)
            f.originalFile = it
            f
        }

        targetFiles = ktFiles.filter { f ->
            cmd.targetRoots.any { root ->
                f.originalFile.virtualFile.path.contains(root)
            }
        }
        //ctx = FooBarCompiler.analyzeBunchOfSources(env, targetFiles, cfg)!!
        return targetFiles
    }

    fun setupMyEnv(cfg: CompilerConfiguration): KotlinCoreEnvironment {

        val disposable = Disposer.newDisposable()
        //Use for Windows
        //System.setProperty("idea.io.use.fallback", "true")
        val env = KotlinCoreEnvironment.createForProduction(
                disposable,
                cfg,
                EnvironmentConfigFiles.JVM_CONFIG_FILES
        )

        class MyPomModelImpl(env: KotlinCoreEnvironment) : PomModelImpl(env.project) {
            override fun runTransaction(pt: PomTransaction) = pt.run()
        }

        val pomModel = MyPomModelImpl(env)

        val project = env.project as MockProject
        project.registerService(
                PomModel::class.java,
                pomModel
        )
        return env
    }


    fun getJavaFiles(projectDir: String): List<PsiFile> {
        findAndCreateJavaFiles(projectDir)
        return javaFiles
    }

    private fun findAndCreateJavaFiles(projectDir: String) {
        val folder = File(projectDir)
        for (entry in checkNotNull(folder.listFiles()) { "$folder is not a folder" }) {
            if (entry.isDirectory) {
                findAndCreateJavaFiles(entry.absolutePath)
            } else if (entry.name.endsWith(".java")) {
                val javaFile = PsiFileFactory.getInstance(env.project).createFileFromText(JavaLanguage.INSTANCE, entry.readText())
                javaFiles.add(javaFile)
            }
        }
    }

    fun reinit(projectDir: String): List<KtFile> {
        this.projectDir = projectDir
        val newArgs = arrayOf("-t", projectDir)
        val cmd = Opt.parse(newArgs)

        env = setupMyEnv(cfg)
        if (!env.project.extensionArea.hasExtensionPoint(TreeCopyHandler.EP_NAME.name)) {
            env.project.extensionArea.registerExtensionPoint(
                    TreeCopyHandler.EP_NAME.name,
                    TreeCopyHandler::class.java.canonicalName,
                    ExtensionPoint.Kind.INTERFACE
            )
        }

        val ktFiles = env.getSourceFiles().map {
            val f = KtPsiFactory(it).createFile(it.virtualFile.path, it.text)
            f.originalFile = it
            f
        }

        targetFiles = ktFiles.filter { f ->
            cmd.targetRoots.any { root ->
                f.originalFile.virtualFile.path.startsWith(root)
            }
        }

        return targetFiles
    }

    fun getPSIForText(text: String): KtFile {
        //Save to tmp
        val path = "tmp/tmp.kt"
        File(path).writeText(text)
        return getPSIForFile(path)
    }


    fun getPSIForFile(path: String, generateCtx: Boolean = true): KtFile {
        val newArgs = arrayOf("-t", path)

        val cmd = Opt.parse(newArgs)
        cfg = setupMyCfg(cmd)
        env = setupMyEnv(cfg)

        if (!env.project.extensionArea.hasExtensionPoint(TreeCopyHandler.EP_NAME.name)) {
            env.project.extensionArea.registerExtensionPoint(
                    TreeCopyHandler.EP_NAME.name,
                    TreeCopyHandler::class.java.canonicalName,
                    ExtensionPoint.Kind.INTERFACE
            )
        }

        targetFiles = env.getSourceFiles().map {
            val f = KtPsiFactory(it).createFile(it.virtualFile.path, it.text)
            f.originalFile = it
            f
        }

//        println("KtFile = ${ktFiles.map { it.name }}")
//
//        targetFiles = ktFiles.filter { f ->
//            cmd.targetRoots.any { root ->
//                f.originalFile.virtualFile.path.startsWith(root)
//            }
//        }
        val file = targetFiles.first()
        val configuration = env.configuration.copy()

        configuration.put(JSConfigurationKeys.LIBRARIES, JsConfig.JS_STDLIB)
        //configuration.put(CommonConfigurationKeys.MODULE_NAME, "sample")

        if (generateCtx)
            ctx = TopDownAnalyzerFacadeForJS.analyzeFiles(listOf(file), JsConfig(env.project, configuration, CompilerEnvironment)).bindingContext

        return targetFiles.first()
    }

    var targetFiles: List<KtFile> = listOf()
    private var javaFiles = mutableListOf<PsiFile>()
    private lateinit var cfg: CompilerConfiguration
    private lateinit var env: KotlinCoreEnvironment
    lateinit var ctx: BindingContext
}