package utils

import java.io.IOException
import java.io.OutputStream


class OutputManager() {
    private var outputStream: OutputStream = System.out
    private var outputMode = OutputMode.ACTIVE

    private enum class OutputMode {
        SILENT, ACTIVE,
    }

    constructor(outputStream: OutputStream) : this() {
        this.outputStream = outputStream
    }

    /**
     * writes a string + \n to the output stream
     * @param string
     */
    fun println(string: String) {
        try {
            if (outputMode == OutputMode.ACTIVE) {
                outputStream.write(string.toByteArray())
                outputStream.write("\n".toByteArray())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /**
     * writes a string to the output stream without checking silent mode
     * @param string
     */
    fun surePrint(string: String) {
        try {
            outputStream.write(string.toByteArray())
            outputStream.write("\n".toByteArray())
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /**
     * writes a string to the output stream
     * @param string
     */
    fun print(string: String) {
        try {
            if (outputMode == OutputMode.ACTIVE) {
                outputStream.write(string.toByteArray())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /**
     * turns output off
     */
    fun silentMode() {
        outputMode = OutputMode.SILENT
    }

    /**
     * turns output on
     */
    fun enableOutput() {
        outputMode = OutputMode.ACTIVE
    }
}