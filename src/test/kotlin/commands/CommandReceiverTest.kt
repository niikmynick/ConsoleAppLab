package commands

import basicClasses.SpaceMarine
import collection.CollectionManager
import commands.utils.Creator
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import utils.InputManager
import utils.OutputManager

class CommandReceiverTest {
    val collectionManager = CollectionManager()
    val outputManager = OutputManager()
    val commandInvoker = CommandInvoker(outputManager)
    val inputManager = InputManager(outputManager)
    val commandReceiver = CommandReceiver(commandInvoker, collectionManager, outputManager, inputManager)
    val creator = Creator(outputManager, inputManager)

    @Test
    @DisplayName("Add Command")
    fun `Add Command`() {
        val sm = mockk<SpaceMarine>()
        commandReceiver.add()
    }
}