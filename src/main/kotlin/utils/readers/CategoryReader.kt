package utils.readers

import basicClasses.AstartesCategory
import basicClasses.SpaceMarine
import java.util.*

/**
 * Class containing readers for [AstartesCategory]
 */
class CategoryReader : EnumReader() {
    companion object {
        /**
         * Prints all values from [AstartesCategory] and reads entered value
         * @param sc Is where a new line is gotten
         * @return [AstartesCategory] from entered value
         */
        fun read(sc: Scanner): AstartesCategory {
            println("Enter Astartes category from the list: ")
            for (category in AstartesCategory.values()) {
                println(category)
            }
            var category:String = sc.nextLine().trim().uppercase()

            while ((category == "") or !enumContains<AstartesCategory>(category)) {
                println("The entered category that doesn't exist. Try again: ")
                category = sc.nextLine().trim().uppercase()
            }

            return AstartesCategory.valueOf(category)
        }

        /**
         * Sets a new [AstartesCategory] for provided element
         * @param element [SpaceMarine] object that is modified
         * @param sc Is where a new line is gotten
         */
        fun update(element: SpaceMarine, sc:Scanner) {
            println("Enter Astartes category from the list (press enter to save existing parameter): ")
            for (category in AstartesCategory.values()) {
                println(category)
            }
            var category:String = sc.nextLine().trim().uppercase()
            while (category.isNotEmpty() and !enumContains<AstartesCategory>(category)) {
                println("The entered category that doesn't exist. Try again: ")
                category = sc.nextLine().trim().uppercase()
            }
            if (category.isNotEmpty()) {
                element.setCategory(AstartesCategory.valueOf(category))
            }

        }
    }
}
