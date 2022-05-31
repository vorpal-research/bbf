package com.stepanov.reduktor.executor.backends

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