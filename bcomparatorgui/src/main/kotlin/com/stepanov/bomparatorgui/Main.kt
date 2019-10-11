package com.stepanov.bomparatorgui

import com.stepanov.bbf.executor.CommonCompiler
import com.stepanov.bbf.executor.TracesChecker
import com.stepanov.bbf.executor.compilers.JSCompiler
import com.stepanov.bbf.executor.compilers.JVMCompiler
import com.stepanov.bbf.mutator.transformations.Transformation
import com.stepanov.bbf.util.BBFProperties
import com.stepanov.reduktor.parser.PSICreator
import javafx.application.Application
import javafx.collections.FXCollections
import javafx.collections.ObservableArray
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader.load
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.paint.Color
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import javafx.stage.Stage
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch
import java.io.File
import java.net.URL
import java.util.*

class Main : Application(), Initializable {

    val layout = "main.fxml"

    @FXML
    lateinit var scrollPane1: ScrollPane

    @FXML
    lateinit var scrollPane2: ScrollPane

    @FXML
    lateinit var label1: Label

    @FXML
    lateinit var label2: Label

    @FXML
    lateinit var myButton: Button

    @FXML
    lateinit var area1: TextField

    @FXML
    lateinit var area2: TextField

    @FXML
    lateinit var box1: ComboBox<String>

    @FXML
    lateinit var box2: ComboBox<String>

    @FXML
    lateinit var rbut1: RadioButton

    @FXML
    lateinit var rbut2: RadioButton

    val group = ToggleGroup()
    val compilers = mutableListOf<CommonCompiler>()


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        val compilersConf = BBFProperties.getStringGroupWithoutQuotes("BACKENDS")
        compilersConf.filter { it.key.contains("JVM") }.forEach { compilers.add(JVMCompiler(it.value)) }
        compilersConf.filter { it.key.contains("JS") }.forEach { compilers.add(JSCompiler(it.value)) }
        val listOfCompilers = FXCollections.observableArrayList(compilers.map { it.compilerInfo })
        box1.items = listOfCompilers
        box2.items = listOfCompilers
        box1.value = listOfCompilers.first()
        box2.value = listOfCompilers.last()
        rbut1.toggleGroup = group
        rbut2.toggleGroup = group
        group.selectToggle(rbut1)
    }

    override fun start(primaryStage: Stage?) {
        val scene = Scene(load<Parent?>(javaClass.classLoader.getResource(layout)))
        primaryStage?.scene = scene
        primaryStage?.show()
        primaryStage?.setOnCloseRequest { System.exit(0) }
    }


    fun buttonClicked() {
        val comp1 = compilers.find { it.compilerInfo == box1.value } ?: return
        val comp2 = compilers.find { it.compilerInfo == box2.value } ?: return
        when (group.selectedToggle) {
            rbut1 -> compareBugs(comp1)
            rbut2 -> compareDiffBehavior(comp1, comp2)
        }
    }

    fun compareBugs(compiler: CommonCompiler) {
        val k = BugComparator.compare(area1.text, area2.text, compiler)
        val result = k.first ?: return
        val textsForTextFlow1 = result
                .filter { it.operation != DiffMatchPatch.Operation.INSERT && it.text.trim() != "\n" }
                .map { it ->
                    Text(it.text).also { it1 ->
                        if (it.operation == DiffMatchPatch.Operation.DELETE) it1.fill = Color.BLUE;
                    }
                }
        val textsForTextFlow2 = result
                .filter { it.operation != DiffMatchPatch.Operation.DELETE }
                .map { it ->
                    Text(it.text).also { it1 -> if (it.operation == DiffMatchPatch.Operation.INSERT) it1.fill = Color.BLUE; it1.wrappingWidthProperty() }
                }
        val p = TextFlow()
        p.children.addAll(textsForTextFlow1)
        scrollPane1.content = p
        val p2 = TextFlow()
        p2.children.addAll(textsForTextFlow2)
        scrollPane2.content = p2
        //textFlow2.children.addAll(textsForTextFlow2)
        label1.text = "K = ${k.second.first.toString().take(5)}"
        label2.text = "Kstack = ${k.second.second.toString().take(5)}"
    }

    fun compareDiffBehavior(comp1: CommonCompiler, comp2: CommonCompiler) {
        val k = BugComparator.compareDiffBehavior(area1.text, comp1, comp2)
        println("K= $k")
        val textsForTextFlow1: List<Text>
        val textsForTextFlow2: List<Text>
        if (k.second != null) {
            val result = k.second!!
            textsForTextFlow1 = result
                    .filter { it.operation != DiffMatchPatch.Operation.INSERT && it.text.trim() != "\n" }
                    .map { it ->
                        Text(it.text).also { it1 ->
                            if (it.operation == DiffMatchPatch.Operation.DELETE) it1.fill = Color.BLUE;
                        }
                    }
            textsForTextFlow2 = result
                    .filter { it.operation != DiffMatchPatch.Operation.DELETE }
                    .map { it ->
                        Text(it.text).also { it1 -> if (it.operation == DiffMatchPatch.Operation.INSERT) it1.fill = Color.BLUE; it1.wrappingWidthProperty() }
                    }
        } else {
            val result = k.first
            if (result.split("SECERROR:\n").size == 2) {
                textsForTextFlow1 = listOf(Text(result.split("SECERROR:\n").first())).map { it.also { it.fill = Color.RED } }
                textsForTextFlow2 = listOf(Text(result.split("SECERROR:\n").last())).map { it.also { it.fill = Color.BLUE } }
            } else {
                textsForTextFlow1 = listOf(Text(result.split("SECOUTPUT:\n").first())).map { it.also { it.fill = Color.BLUE } }
                textsForTextFlow2 = listOf(Text(result.split("SECOUTPUT:\n").last())).map { it.also { it.fill = Color.RED } }
            }
        }
        val p = TextFlow()
        p.children.addAll(textsForTextFlow1)
        scrollPane1.content = p
        val p2 = TextFlow()
        p2.children.addAll(textsForTextFlow2)
        scrollPane2.content = p2
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }
}


