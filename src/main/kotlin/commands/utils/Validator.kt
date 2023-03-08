package commands.utils

class Validator {
    companion object {
        fun verify (args: List<String>):Boolean {
            return if (args.size > 1) {
                println("Entered excess argument")
                false
            } else {
                true
            }
        }
    }

}