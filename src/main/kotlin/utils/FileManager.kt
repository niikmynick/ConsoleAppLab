package utils

import basicClasses.SpaceMarine
import collection.CollectionManager
import com.charleskorn.kaml.Yaml
import exceptions.NoEnvironmentVariableFound
import java.io.FileReader

/**
 * Class that contains environment variables and handles files
 * @property collectionFileName String containing file name
 */
class FileManager(private val outputManager: OutputManager) {

    private val collectionFileName = try {
        System.getenv("COLLECTION")
    } catch (e:Exception) {
        throw NoEnvironmentVariableFound()
    }
    /**
     * Reads data from the file provided in [collectionFileName] and adds objects to [collection]
     * @param collectionManager Current collection
     */
    fun load(collectionManager: CollectionManager) {
        try {
            if (collectionFileName == null) {
                throw NoEnvironmentVariableFound()
            }

            val file = FileReader(collectionFileName)
            val datalist = file.readText().split("#ENDOFSPACEMARINE")
            for (data in datalist) {
                data.trim()
                if (data.isNotBlank()) {
                    val spaceMarine = Yaml.default.decodeFromString(SpaceMarine.serializer(), data)
                    collectionManager.add(spaceMarine)
                }
            }
            file.close()

            outputManager.println("Loaded ${collectionManager.getCollection().size} elements successfully")
        } catch (e: Exception) {
            outputManager.println(e.message.toString())
        }


    }

}