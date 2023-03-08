package utils

import basicClasses.SpaceMarine
import collection.CollectionManager
import com.charleskorn.kaml.Yaml
import java.io.FileOutputStream
import java.io.FileReader
import java.io.OutputStreamWriter
import java.util.Properties

/**
 * Class that contains environment variables and handles files
 * Loading and saving collections is realized in Yaml
 * @property collectionFileName String containing file name
 */
class FileManager(p:Properties) {

    private val collectionFileName = p.getProperty("COLLECTION_FILENAME")
    fun getFilename() : String {
        return collectionFileName
    }

    /**
     * Reads data from the file provided in [collectionFileName] and adds objects to [collectionManager]
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

            println("Loaded ${collectionManager.getCollection().size} elements successfully")
        } catch (e: Exception) {
            println(e.message)
        }


    }

    fun save(collectionManager: CollectionManager) : Boolean{ //TODO: Duplicate
        return try {
            val file = FileOutputStream(collectionFileName)

            val output = OutputStreamWriter(file)
            for (element in collectionManager.getCollection()) {
                output.write(Yaml.default.encodeToString(SpaceMarine.serializer(), element))
                output.write("\n#ENDOFSPACEMARINE\n")
            }
            output.close()

            true
        } catch (e: Exception) {
            println(e.message.toString())

            false
        }
    }

}