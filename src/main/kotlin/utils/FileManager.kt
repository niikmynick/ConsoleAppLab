package utils

import basicClasses.SpaceMarine
import collection.CollectionManager
import com.charleskorn.kaml.Yaml
import java.io.FileReader

/**
 * Class that contains environment variables and handles files
 * @property collectionFileName String containing file name
 */
class FileManager(private val outputManager: OutputManager) {

    private val collectionFileName = System.getenv("COLLECTION")

    /**
     * Reads data from the file provided in [collectionFileName] and adds objects to [collection]
     * @param collectionManager Current collection
     */
    fun load(collectionManager: CollectionManager) {

        try {
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
            outputManager.println(e.toString())
        }


    }

}