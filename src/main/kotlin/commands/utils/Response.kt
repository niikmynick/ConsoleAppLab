package commands.utils

class Response(private val code: Int, private val message: List<String>) {

    fun getMessage() : String {
        var string = "Code: $code"
        for (line in message) {
            string += line + "\n"
        }
        return string
    }

}