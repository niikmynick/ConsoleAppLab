package utils.readers

import basicClasses.AstartesCategory

class CategoryReader : EnumReader() {
    companion object {
        fun read(): AstartesCategory {
            println("Enter Astartes category from the list: ")
            for (category in AstartesCategory.values()) {
                println(category)
            }
            var category:String = readln().trim().uppercase()

            while ((category == "") or !enumContains<AstartesCategory>(category)) {
                println("Seems like you entered category that doesn't exist. Try again: ")
                category = readln().trim().uppercase()
            }

            return AstartesCategory.valueOf(category)
        }
    }
}
