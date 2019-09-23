package com.stepanov.reduktor.executor.backends

import com.intellij.openapi.Disposable
import com.intellij.openapi.extensions.ExtensionPoint
import com.intellij.openapi.extensions.Extensions
import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import com.stepanov.reduktor.executor.KotlincInvokeStatus
import com.stepanov.reduktor.parser.PSICreator
import org.jetbrains.kootstrap.FooBarCompiler
import org.jetbrains.kootstrap.FooBarCompiler.setupMyCfg
import org.jetbrains.kootstrap.FooBarCompiler.setupMyEnv
import org.jetbrains.kootstrap.util.opt
import org.jetbrains.kotlin.analyzer.AnalysisResult
import org.jetbrains.kotlin.cli.jvm.compiler.CliBindingTrace
import org.jetbrains.kotlin.cli.jvm.compiler.EnvironmentConfigFiles
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
import org.jetbrains.kotlin.cli.jvm.compiler.TopDownAnalyzerFacadeForJVM
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.languageVersionSettings
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.load.kotlin.PackagePartProvider
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi2ir.Psi2IrConfiguration
import org.jetbrains.kotlin.psi2ir.Psi2IrTranslator
import org.jetbrains.kotlin.resolve.AnalyzingUtils
import org.jetbrains.kotlin.resolve.BindingTrace
import com.intellij.psi.impl.source.tree.TreeCopyHandler
import com.stepanov.reduktor.executor.CompilerArgs
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageLocation
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import org.jetbrains.kotlin.config.IncrementalCompilation
import org.jetbrains.kotlin.config.Services
import org.jetbrains.kotlin.ir.util.dump
import org.jetbrains.kotlin.ir.util.getPackageFragment
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class IR2JVMBackend {
//    override fun tryToCompile(path: String): KotlincInvokeStatus {
//        val new_args = arrayOf("-t", path)
//
//        val cmd = opt.parse(new_args)
//        val cfg = setupMyCfg(cmd)
//        val config = setupMyEnv(cfg)
//        val file = PSICreator("").getPSIForFile(path)
//
//        if (!Extensions.getRootArea().hasExtensionPoint(TreeCopyHandler.EP_NAME.name)) {
//            Extensions.getRootArea().registerExtensionPoint(
//                    TreeCopyHandler.EP_NAME.name,
//                    TreeCopyHandler::class.java.canonicalName,
//                    ExtensionPoint.Kind.INTERFACE
//            )
//        }
//        val ignoreErrors = false
//        val trans = Psi2IrTranslator(config.configuration.languageVersionSettings, Psi2IrConfiguration(ignoreErrors))
//        val module = generateIrModuleWithJvmResolve(listOf(file), config, trans)
//        println("MOD = ${module.name}")
//        println(module.files.size)
//        System.exit(0)
//        return KotlincInvokeStatus("", true, true, true)
//    }
//
//    private fun generateIrModuleWithJvmResolve(
//            ktFilesToAnalyze: List<KtFile>, environment: KotlinCoreEnvironment, psi2ir: Psi2IrTranslator
//    ): IrModuleFragment =
//            generateIrModule(analyze(ktFilesToAnalyze, environment), psi2ir, ktFilesToAnalyze, JvmGeneratorExtensions)
//
//    private fun generateIrModule(
//            analysisResult: AnalysisResult,
//            psi2ir: Psi2IrTranslator,
//            ktFilesToAnalyze: List<KtFile>,
//            generatorExtensions: GeneratorExtensions
//    ): IrModuleFragment {
//        if (!psi2ir.configuration.ignoreErrors) {
//            analysisResult.throwIfError()
//            AnalyzingUtils.throwExceptionOnErrors(analysisResult.bindingContext)
//        }
//        return psi2ir.generateModule(
//                analysisResult.moduleDescriptor, ktFilesToAnalyze, analysisResult.bindingContext, generatorExtensions
//        )
//    }
//
//    private fun analyze(files: Collection<KtFile>, environment: KotlinCoreEnvironment): AnalysisResult =
//            analyze(files, environment, environment.configuration)
//
//    private fun analyze(files: Collection<KtFile>, environment: KotlinCoreEnvironment, configuration: CompilerConfiguration): AnalysisResult =
//            analyze(environment.project, files, configuration, environment::createPackagePartProvider)
//
//    private fun analyze(
//            project: Project,
//            files: Collection<KtFile>,
//            configuration: CompilerConfiguration,
//            packagePartProviderFactory: (GlobalSearchScope) -> PackagePartProvider,
//            trace: BindingTrace = CliBindingTrace()
//    ): AnalysisResult {
//        return TopDownAnalyzerFacadeForJVM.analyzeFilesWithJavaIntegration(
//                project, files, trace, configuration, packagePartProviderFactory
//        )
//    }
}