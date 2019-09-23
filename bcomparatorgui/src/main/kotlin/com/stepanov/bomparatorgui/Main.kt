package com.stepanov.bomparatorgui

import com.stepanov.bbf.executor.compilers.JVMCompiler
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader.load
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import javafx.stage.Stage
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch


class Main : Application() {

    val layout = "main.fxml"

    @FXML
    lateinit var scrollPane1: ScrollPane

    @FXML
    lateinit var scrollPane2: ScrollPane

    @FXML
    lateinit var label1: Label

    @FXML
    lateinit var myButton: Button

    @FXML
    lateinit var area1: TextField

    @FXML
    lateinit var area2: TextField


    override fun start(primaryStage: Stage?) {
        val scene = Scene(load<Parent?>(javaClass.classLoader.getResource(layout)))
        primaryStage?.scene = scene
        primaryStage?.show()
        primaryStage?.setOnCloseRequest { System.exit(0) }
    }


    fun buttonClicked(actionEvent: ActionEvent) {
        val k = BugComparator(area1.text, area2.text, JVMCompiler()).compare()
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
        label1.text = "K = ${k.second}"
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(Main::class.java)
        }
    }
}

