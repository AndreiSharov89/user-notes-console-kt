class App {
    private val archives = mutableListOf<Archive>()
    fun start() {
        while (true) {
            println("\n\tГлавное меню:")
            println("1. Создать архив.")
            println("2. Просмотр архивов.")
            println("0. Выход.")


            when (Utils.readInput(2)) {
                1 -> Utils.createItem("Название архива") {
                    Archive(it).let { archives.add((it)) }
                }

                2 -> {
                    if (archives.isEmpty()) println("Архивы отстутствуют.")
                    else {
                        val archive = Menu(" Просмотр архивов.", archives).display()
                        if (archive != null) showArchiveMenu(archive)
                    }
                }

                0 -> return
            }
        }
    }

    private fun showArchiveMenu(archive: Archive) {
        while (true) {
            val choice = Menu(
                "\n\tАрхив: ${archive.name}",
                listOf("Создать заметку") + archive.notes.map { it.name }).display()
            if (choice == null) return
            if (choice is String && choice == "Создать заметку") createNote(archive)
            else showNote(archive.notes.first { it.name == choice })
        }
    }

    private fun createNote(archive: Archive) {
        Utils.createItem("название заметки") { title ->
            Utils.createItem("содержание заметки") { content ->
                Note(title, content)
            }
        }?.let { archive.notes.add(it) }
    }

    private fun showNote(note: Note) {
        println("\n\tЗаметка: ${note.name}\nТекст: ${note.text}\n")
        println("Нажмите Enter, чтобы вернуться.")
        readLine()
    }
}