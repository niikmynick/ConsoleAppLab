package commands.utils

import basicClasses.SpaceMarine
import com.charleskorn.kaml.Yaml
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.util.TreeSet

class Saver {
    /**
     * Saves elements of collection into file with provided [filename]
     * @param filename Name of the file
     * @return true if elements were saved, false an exception occurred
     */
    fun save(filename: String, collection: TreeSet<SpaceMarine>) {
        try {
            val file = FileOutputStream(filename)

            val output = OutputStreamWriter(file)
            for (element in collection) {
                output.write(Yaml.default.encodeToString(SpaceMarine.serializer(), element))
                output.write("\n#ENDOFSPACEMARINE\n")
            }
            output.close()
        } catch (e: Exception) {
            println(e.message.toString())

        }
    }
}