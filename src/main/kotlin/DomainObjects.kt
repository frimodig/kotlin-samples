enum class MarketingCategory {
    GIRLS, BOYS, WOMEN, MEN, GENERAL
}

enum class Location(val country: String, val ageOfMajority: Int?) {
    FI("Finland", 18),
    US("United States of America", 21),
    UNKNOWN("unknown", null)
}

// https://kotlinlang.org/docs/reference/data-classes.html
data class Person(
        val name: String,
        var age: Int?,
        val gender: Gender = Gender.NOT_SPECIFIED,
        val location: Location = Location.UNKNOWN
) {
    init {
        // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html
        require(name.isNotEmpty())
    }

    enum class Gender {
        MALE, FEMALE, NONE, OTHER, NOT_SPECIFIED
    }
}