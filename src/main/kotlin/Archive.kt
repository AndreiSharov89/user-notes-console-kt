class Archive(val name: String) {
    val notes = mutableListOf<Note>()
    override fun toString(): String {
        return name
    }
}