import java.util.Scanner

object Utils {
    private val scanner = Scanner(System.`in`)
    fun readInput(limit: Int): Int {
        while (true) {
            print("Введите номер: ")
            val input = scanner.nextLine()
            if (input.matches(Regex("\\d+"))) {
                val num = input.toInt()
                if (num in 0..limit) return num
            }
            println("Некорректный ввод, попробуйте снова.")
        }
    }

    fun <T> createItem(prompt: String, onCreate: (String) -> T?): T? {
        print("Введите $prompt: ")
        val name = scanner.nextLine().trim()
        return if (name.isNotEmpty()) onCreate(name) else {
            println("$prompt не может быть пустым.")
            null
        }
    }
}