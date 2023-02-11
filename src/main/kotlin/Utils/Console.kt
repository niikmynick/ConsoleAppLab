package Utils

fun console() {
    println("Waiting for user command ...")
    do {
        println("$  ")
        val input = readln().split(" ")
        val command = input[0].trim().lowercase()

        var arg1: String = "000000"
        var arg2: String
        when (input.size) {
            2 -> arg1 = input[1].trim().lowercase()
            3 -> {arg1 = input[1].trim().lowercase()
                arg2 = input[2].trim().lowercase()
            }
        }

        when (command) {
            "help" -> help(arg1)
            "info" -> println("pass") //вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
            "show" -> println("pass") //вывести в стандартный поток вывода все элементы коллекции в строковом представлении
            "add" -> println("pass") //{element} добавить новый элемент в коллекцию
            "update id" -> println("pass") //{element} обновить значение элемента коллекции, id которого равен заданному
            "remove_by_id" -> println("pass")//{id} удалить элемент из коллекции по его id
            "clear" -> println("pass") //очистить коллекцию
            "save" -> println("pass") //сохранить коллекцию в файл
            "execute_script" -> println("pass") //{file_name} считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
            "exit" -> println("Termination of work ...")
            "add_if_max" -> println("pass") //{element} добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
            "remove_greater" -> println("pass") //{element} удалить из коллекции все элементы, превышающие заданный
            "remove_lower" -> println("pass") //{element} удалить из коллекции все элементы, меньшие, чем заданный
            "average_of_health" -> println("pass") //вывести среднее значение поля health для всех элементов коллекции
            "group_counting_by_name" -> println("pass") //сгруппировать элементы коллекции по значению поля name, вывести количество элементов в каждой группе
            "print_unique_melee_weapon" -> println("pass") //вывести уникальные значения поля meleeWeapon всех элементов в коллекции
            else -> println("Command $command doesn't exist")
        }
    } while (command != "exit")
}
