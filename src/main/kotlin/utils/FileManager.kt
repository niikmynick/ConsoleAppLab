package utils

import basicClasses.SpaceMarine
import com.charleskorn.kaml.Yaml
import java.io.FileReader
import java.util.Properties

/**
 * Class that contains environment variables and handles files
 * @property collectionFileName String containing file name
 */
class FileManager(p:Properties) {

    private val collectionFileName = p.getProperty("COLLECTION_FILENAME")
    fun getFilename() : String {
        return collectionFileName
    }

    /**
     * Reads data from the file provided in [collectionFileName] and adds objects to [collection]
     * @param collection Current collection
     */
    fun load(collection: CollectionManager) {

        try {
            val file = FileReader(collectionFileName)
            val datalist = file.readText().split("#ENDOFSPACEMARINE")
            for (data in datalist) {
                data.trim()
                if (data.isNotBlank()) {
                    val spaceMarine = Yaml.default.decodeFromString(SpaceMarine.serializer(), data)
                    collection.add(spaceMarine)
                }
            }

            file.close()
            println("Loaded ${collection.size} elements successfully")
        } catch (e: Exception) {
            println(e.message)
        }


    }

    fun save(collection: CollectionManager) : Boolean{
        TODO()
    }

}