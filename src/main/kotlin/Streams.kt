class Streams {

    private val list = listOf("Kotlin", "Java", "Clojure", null, "Scala")

    fun filterNull(): List<String> {
        return list.filterNotNull()
    }

    fun find(x: String): String? {
        return list.find { x == it }
    }

    // https://kotlinlang.org/docs/reference/sequences.html
    fun complicatedFind(): List<String> {
        return list
                .asSequence()
                .filterNotNull()
                .filter { it.contains(char = 'j', ignoreCase = true) }
                .map { it.reversed() }
                .filter { it.startsWith('a') }
                .toList()
    }
}