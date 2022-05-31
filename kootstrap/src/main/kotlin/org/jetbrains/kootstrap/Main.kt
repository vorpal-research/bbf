package org.jetbrains.kootstrap

import com.intellij.openapi.extensions.ExtensionPoint
import com.intellij.psi.impl.source.tree.TreeCopyHandler
import org.jetbrains.kootstrap.util.Opt
import org.jetbrains.kootstrap.util.targetRoots
import org.jetbrains.kotlin.descriptors.VariableDescriptor
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.KtVariableDeclaration
import org.jetbrains.kotlin.resolve.BindingContext

/**
 * Created by akhin on 7/5/16.
 */

fun variableType(variable: KtVariableDeclaration, ctx: BindingContext) =
        (ctx[BindingContext.DECLARATION_TO_DESCRIPTOR, variable] as VariableDescriptor).returnType

fun main() {
    val projectDir = ""
    val newArgs = arrayOf("-t", projectDir)
    val cmd = Opt.parse(newArgs)
    val cfg = FooBarCompiler.setupMyCfg(cmd)
    val env = FooBarCompiler.setupMyEnv(cfg)

    if (!env.project.extensionArea.hasExtensionPoint(TreeCopyHandler.EP_NAME.name)) {
        env.project.extensionArea.registerExtensionPoint(
                TreeCopyHandler.EP_NAME.name,
                TreeCopyHandler::class.java.canonicalName,
                ExtensionPoint.Kind.INTERFACE,
        )
    }
    val ktFiles = env.getSourceFiles().map {
        val f = KtPsiFactory(it).createFile(it.virtualFile.path, it.text)
        f.originalFile = it
        f
    }
    val targetFiles = ktFiles.filter { f ->
        cmd.targetRoots.any { root ->
            f.originalFile.virtualFile.path.startsWith(root)
        }
    }
    val ctx = FooBarCompiler.analyzeBunchOfSources(env, ktFiles, cfg)
}
