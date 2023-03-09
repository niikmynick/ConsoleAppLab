package utils

import java.io.IOException
import java.io.OutputStream


class OutputManager() {
    private var outputStream: OutputStream? = null
    private var messageNotifications = MessageNotifications.ON

    private enum class MessageNotifications {
        ON, OFF
    }

    constructor(outputStream: OutputStream?) : this() {
        this.outputStream = outputStream
    }

    /**
     * writes a string + \n to the output stream
     * @param string
     */
    fun println(string: String) {
        try {
            if (messageNotifications == MessageNotifications.ON) {
                outputStream?.write(string.toByteArray())
                outputStream?.write("\n".toByteArray())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /**
     * writes a string to the output stream without checking silent mode
     * @param string
     */
    fun printlnImportantMessage(string: String) {
        try {
            outputStream?.write(string.toByteArray())
            outputStream?.write("\n".toByteArray())
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
            if (messageNotifications == MessageNotifications.ON) {
                outputStream?.write(string.toByteArray())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /**
     * turns output off
     */
    fun silentMode() {
        messageNotifications = MessageNotifications.OFF
    }

    /**
     * turns output on
     */
    fun enableOutput() {
        messageNotifications = MessageNotifications.ON
    }
}