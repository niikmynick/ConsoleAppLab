package utils.readers

import basicClasses.AstartesCategory
import basicClasses.SpaceMarine

class CategoryReader : EnumReader() {
    companion object {
        fun read(): AstartesCategory {
            println("Enter Astartes category from the list: ")
            for (category in AstartesCategory.values()) {
                println(category)
            }
            var category:String = readln().trim().uppercase()

            while ((category == "") or !enumContains<AstartesCategory>(category)) {
                println("The entered category that doesn't exist. Try again: ")
                category = readln().trim().uppercase()
            }

            return AstartesCategory.valueOf(category)
        }
        fun update(element: SpaceMarine) {
            println("Enter Astartes category from the list (press enter to save existing parameter): ")
            for (category in AstartesCategory.values()) {
                println(category)
            }
            var category:String = readln().trim().uppercase()
            while (category.isNotEmpty() and !enumContains<AstartesCategory>(category)) {
                println("The entered category that doesn't exist. Try again: ")
                category = readln().trim().uppercase()
            }
            if (category.isNotEmpty()) {
                element.setCategory(AstartesCategory.valueOf(category))
            }

        }
    }
}
