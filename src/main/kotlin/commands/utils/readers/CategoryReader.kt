package commands.utils.readers

import basicClasses.AstartesCategory
import utils.InputManager

/**
 * Category reader
 *
 * Class containing readers for [AstartesCategory]
 *
 * @constructor Create Category reader
 */
class CategoryReader : EnumReader() {
    companion object {

        /**
         * Prints all values from [AstartesCategory] and reads entered value
         * @return [AstartesCategory] from entered value
         */
        fun read(inputManager: InputManager): AstartesCategory {
            println("Enter Astartes category from the list: ")
            //val scanner = Scanner(System.`in`)

            for (category in AstartesCategory.values()) {
                println(category)
            }
            var category:String = inputManager.nextLine().trim().uppercase()

            while ((category == "") or !enumContains<AstartesCategory>(category)) {
                println("The entered category that doesn't exist. Try again: ")
                category = inputManager.nextLine().trim().uppercase()
            }

            return AstartesCategory.valueOf(category)
        }

    }
}
