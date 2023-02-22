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
            val filereader = FileReader(collectionFileName)
            val datalist = filereader.readText().split("#ENDOFSPACEMARINE")
            for (data in datalist) {
                data.trim()
                if (data.isNotBlank()) {
                    val spacemarine = Yaml.default.decodeFromString(SpaceMarine.serializer(), data)
                    collection.add(spacemarine)
                }
            }

            filereader.close()
            println("Loaded ${collection.size} elements successfully")
        } catch (e: Exception) {
            println(e.message)
        }


    }

}