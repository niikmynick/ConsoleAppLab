package commands

import basicClasses.SpaceMarine
import collection.CollectionManager
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import utils.InputManager
import utils.OutputManager
import java.sql.Timestamp

class CommandReceiverTest {
    private val collectionManager = CollectionManager()
    private val outputManager = OutputManager()
    private val commandInvoker = CommandInvoker(outputManager)
    private val inputManager = InputManager(outputManager)
    private val commandReceiver = CommandReceiver(commandInvoker, collectionManager, outputManager, inputManager)

    @Test
    @DisplayName("Add and remove to collection")
    fun `Add and remove to collection` () {
        val sm = mockk<SpaceMarine>()
        every { sm.getId() } returns Timestamp(System.currentTimeMillis()).time
        every { sm.compareTo(other = sm) } returns 1
        every { sm.getName() } returns "Name"
        collectionManager.add(sm)
        commandReceiver.removeByID(sm.getId().toString())
        verify(atMost = 1) { sm.getName() }
    }

}