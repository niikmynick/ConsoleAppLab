package utils

import exceptions.InvalidInputException
import exceptions.RecursiveCallException
import java.io.File
import java.io.FileReader
import java.io.InputStream
import java.util.*

class InputManager(private val outputManager: OutputManager) {
    private val scanners: Stack<Scanner> = Stack()
    private var inputStream = System.`in`
    private var scriptMode = false
    private var files:Stack<File> = Stack()

    constructor(inputStream: InputStream, outputManager: OutputManager) : this(outputManager) {
        this.inputStream = inputStream
    }
    init {
        scanners.push(Scanner(inputStream, "UTF-8"))
    }

    /**
     * reads one line
     * @return the line that was read
     */
    fun read(): String {
        if (scanners.peek().hasNextLine()) {
            return scanners.peek().nextLine()
        } else {
            if (scriptMode) {
                finishScriptReader()
                return ""
            } else {
                throw InvalidInputException()
            }
        }
    }

    fun startScriptReader(filepath: String) {
        val file = File(filepath)
        if (file in files) {
            throw RecursiveCallException()
        } else {
            outputManager.println("Start executing script from file ${file.name}")
            scanners.push(Scanner(FileReader(filepath)))
            files.push(file)
            scriptMode = true
            for (i in 0..2) {
                for (j in 0..2) {
                    outputManager.print(".")
                    Thread.sleep(500)
                }
                outputManager.println("")
            }

            outputManager.silentMode()
        }
    }

    private fun finishScriptReader() {
        scriptMode = false
        outputManager.enableOutput()
        if (scanners.size > 1) {
            scanners.pop().close()
        }
        outputManager.println("Script from file was executed")
    }
}