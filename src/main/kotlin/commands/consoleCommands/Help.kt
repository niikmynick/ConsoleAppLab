package commands.consoleCommands

class Help : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args:Any) {
        val list = mapOf("help" to "Выводит справку по доступным командам",
            "info" to "Выводит информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)",
            "show" to "Выводит все элементы коллекции в строковом представлении",
            "add" to "Добавляет новый элемент в коллекцию",
            "update" to "Обновляет значение элемента коллекции по заданному id",
            "remove_by_id" to "Удаляет элемент из коллекции по его id",
            "clear" to "Очищает коллекцию",
            "save" to "Сохраняет коллекцию в файл",
            "execute_script" to "Считывает и исполняет скрипт из указанного файла (скрипт содержат команды в таком же виде, в котором их вводит пользователь в интерактивном режиме)",
            "exit" to "Завершает программу (без сохранения в файл)",
            "add_if_max" to "Добавляет новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции",
            "remove_greater" to "Удаляет из коллекции все элементы, превышающие заданный",
            "remove_lower" to "Удаляет из коллекции все элементы, меньшие, чем заданный",
            "average_of_health" to "Выводит среднее значение поля health для всех элементов коллекции",
            "group_counting_by_name" to "Группирует элементы коллекции по значению поля name, выводит количество элементов в каждой группе",
            "print_unique_melee_weapon" to "Выводит уникальные значения поля meleeWeapon всех элементов в коллекции")

        println("Help is available for the following commands:")
        for (key in list.keys) {
            println("- $key")
        }

        println("""
            For information on a command, type HELP <command name>
            To exit help menu type EXIT
            """)
        var query: List<String> = readln().trim().lowercase().split(" ")

        while (query[0] != "exit") {
            if ((query.size == 2) and (query[0] == "help")) {
                println(list[query[1]])
                query = readln().trim().lowercase().split(" ")

            } else if (query.size > 2) {
                println("Too much arguments. Try again: ")
                query = readln().trim().lowercase().split(" ")

            } else {
                println("""
            For information on a command, type HELP <command name>
            To exit help menu type EXIT
            """)
                query = readln().trim().lowercase().split(" ")
            }
        }
    }
}
