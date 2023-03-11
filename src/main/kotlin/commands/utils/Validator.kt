package commands.utils

class Validator {
    companion object {
        fun verifyNoArgs (args: List<String>):Boolean {
            return args.size == 1
        }

        fun verifyOnlyArg (args: List<String>):Boolean {
            return args.size <= 2
        }

    }

}