package utils

import basicClasses.SpaceMarine
import com.charleskorn.kaml.Yaml
import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv
import java.io.FileReader

class FileManager {

    private val env = dotenv()
    private val collectionFileName = env["COLLECTION_FILENAME"]

    fun getEnv() : Dotenv {
        return env
    }
    fun getFilename() : String {
        return collectionFileName
    }

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