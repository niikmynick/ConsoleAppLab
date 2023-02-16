package commands.consoleCommands

class ScriptFromFile : Command() {
    override fun writeInfo() {
        println("Считывает и исполняет скрипт из указанного файла (скрипт содержат команды в таком же виде, в котором их вводит пользователь в интерактивном режиме)")
    }

    override fun execute(argument:String) {
        TODO("Not yet implemented")
    }
}