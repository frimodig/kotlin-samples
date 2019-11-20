import kotlin.math.sqrt

class Strings {

    // https://kotlinlang.org/docs/reference/basic-types.html#string-templates
    // https://kotlinlang.org/api/latest/jvm/stdlib/index.html
    fun template(value1: String, value2: Double): String {
        return "This String is created with formatter to include values $value1 and ${sqrt(value2)}."
    }

    // https://kotlinlang.org/docs/reference/basic-types.html#string-literals
    fun multilineWithSpecialCharacters(value: String): String {
        return """
                |   This String has multiple lines with tabs
                |   plus some potentially difficult characters
                |   such as $, \, and " .
                |   Yet we can still insert $value!
                """.trimMargin()
    }
}