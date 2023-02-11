import BasicClasses.AstartesCategory

fun categoryReader(): AstartesCategory {
    print("Enter Astartes category from list ${AstartesCategory.values()}: ")
    var input: String
    var consist = false

    while (!consist) {
        input = readln()

        for (value in AstartesCategory.values()) {
            if (input.uppercase().equals(value)) {
                consist = true
                break
            }
        }
    }
    return enumValueOf<AstartesCategory>(input)
}

fun weaponReader() {

}