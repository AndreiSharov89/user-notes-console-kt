class Menu<T>(private val title: String, private val items: List<T>) {
    fun display(): T? {
        while (true){
            println("\n\t$title")
            items.forEachIndexed{index, item -> println("${index+1}. ${item.toString()}.")}
            println("0. Назад.")

            val choice = Utils.readInput(items.size)
            if (choice == 0) return null
            return items[choice - 1]
        }
    }
}