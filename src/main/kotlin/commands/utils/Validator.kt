package commands.utils

class Validator {
    companion object {
        fun verifyNoArgs (args: List<String>):Boolean {
            return if (args.size > 1) {
                println("Entered excess argument")
                false
            } else {
                true
            }
        }

        fun verifyOnlyArg (args: List<String>):Boolean {
            return if (args.size > 2) {
                println("Entered excess argument")
                false
            } else if (args.size == 1) {
                println("Argument is expected")
                false
            } else {
                true
            }
        }

        fun verifyArray (array: ArrayList<String>): Boolean {
            return try {
                (array[0].isNotEmpty()
                        && array[1].isNotEmpty()
                        && array[2].isNotEmpty()
                        && array[3].isNotEmpty()
                        && array[4].isNotEmpty()
                        && array[5].isNotEmpty()
                        && array[6].isNotEmpty())
            } catch (e:NumberFormatException) {
                false
            }
        }
    }

}