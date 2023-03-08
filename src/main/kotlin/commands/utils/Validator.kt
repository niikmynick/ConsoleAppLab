package commands.utils

class Validator {
    companion object {
        fun verify (args: List<String>, limit: Int):Boolean {
            return if (args.size > limit) {
                println("Entered excess argument")
                false
            } else {
                true
            }
        }
    }

}