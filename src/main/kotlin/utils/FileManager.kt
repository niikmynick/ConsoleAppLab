package utils

import basicClasses.SpaceMarine
import com.charleskorn.kaml.Yaml
import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv
import java.io.FileReader

/**
 * File manager
 *
 * @constructor Create File manager
 */
class FileManager {

    private val env = dotenv()
    private val collectionFileName = env["COLLECTION_FILENAME"]

    /**
     * Get env
     *
     * @return
     */
    fun getEnv() : Dotenv {
        return env
    }

    /**
     * Get filename
     *
     * @return
     */
    fun getFilename() : String {
        return collectionFileName
    }

    /**
     * Load
     *
     * @param collection
     */
    fun load(collection: CollectionManager) {
        try {
            val file = FileReader(collectionFileName)
            val datalist = file.readText().split("\n#ENDOFSPACEMARINE\n")
            for (data in datalist) {
                if (data.isNotEmpty()) {
                    val spacemarine = Yaml.default.decodeFromString(SpaceMarine.serializer(), data)
                    collection.add(spacemarine)
                }
            }

            file.close()
            println("Loaded ${collection.size} elements successfully")
        } catch (e: Exception) {
            println(e.message)
        }
    }
}