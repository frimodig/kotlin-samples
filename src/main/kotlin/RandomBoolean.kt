import java.util.*

class RandomBoolean {
    private val random = Random()
    private val javaRandom = RandomBooleanJava()

    fun next(): Boolean? {
        return if (random.nextBoolean()) {
            random.nextBoolean()
        } else null
    }

    fun nextNotNull(): Boolean = next() ?: false

    //// Calling the Java class

    /**
     * javaRandom.next() actually returns a platform type Boolean!
     * https://kotlinlang.org/docs/reference/java-interop.html
     * Boolean! can be cast to either Boolean or Boolean? and you as the developer will have
     * to make the decision on how to treat it. I would recommend always treating all platform types
     * returned from java as nullable.
     *
     * Kotlin also supports nullability annotations and if those are used the compiler/editor will treat
     * the return value as a non platform type.
     */
    fun nextNotNullFromJava(): Boolean = javaRandom.next() ?: false

    fun nextNotNullFromJavaOptional(): Boolean {
        return javaRandom.optionalNext().orElse(false)
    }
}