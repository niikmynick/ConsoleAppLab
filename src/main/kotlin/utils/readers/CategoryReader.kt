package utils.readers

import basicClasses.AstartesCategory

class CategoryReader : EnumReader() {
    companion object {
        fun read(): AstartesCategory {
            println("Enter Astartes category from the list ${AstartesCategory.values()}: ")
            var category:String = readln().trim()

            while ((category == "") or !enumContains<AstartesCategory>(category)) {
                println("Seems like you entered category doesn't exist. Try again: ")
                category = readln().trim()
            }

            return AstartesCategory.valueOf(category)
        }
    }
}
