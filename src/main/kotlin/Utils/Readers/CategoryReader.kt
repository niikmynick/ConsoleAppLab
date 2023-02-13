package Utils.Readers

import BasicClasses.AstartesCategory

class CategoryReader : Reader() {
    companion object {
        fun read(): AstartesCategory {
            print("Enter Astartes category from the list ${AstartesCategory.values()}: ")
            var category = readln().trim()
            if (category.equals("") or !enumContains<AstartesCategory>(category)) {
                while (!enumContains<AstartesCategory>(category)) {
                    print("Seems like entered category doesn't exist. Try again: ")
                    category = readln().trim()
                }
            }
            return AstartesCategory.valueOf(category)
        }

    }

}
