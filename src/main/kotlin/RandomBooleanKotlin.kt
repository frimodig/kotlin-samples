import java.util.Random

class RandomBooleanKotlin {
    private val random = Random()

    fun next(): Boolean? {
        return if (random.nextBoolean()) {
            random.nextBoolean()
        } else null
    }

    fun nextNotNull(): Boolean {
        return next() ?: nextNotNull()
    }
}