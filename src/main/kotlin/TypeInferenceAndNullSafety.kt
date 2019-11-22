import kotlin.math.sqrt

fun main() {

    val map = mapOf("one" to 1, "two" to 2, "three" to 3) // Map<String, Int>

    val map2 = map + ("four" to 4.0) // Map<String, Any>

    val int = map["one"] // Int?

    val int2 = map2["two"] // Any?

    val sum = if (int != null && int2 is Int) {
        int + int2
    } else null

    val squared = sqrt(sum?.toDouble() ?: 1.0)
}