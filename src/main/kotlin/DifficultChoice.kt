class DifficultChoice {

    // https://kotlinlang.org/docs/reference/control-flow.html#when-expression
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/to.html
    fun findMarketingCategory(person: Person): MarketingCategory {
        return when (person.isMinor() to person.gender) {
            true to Person.Gender.MALE -> MarketingCategory.BOYS
            true to Person.Gender.FEMALE -> MarketingCategory.GIRLS
            false to Person.Gender.MALE -> MarketingCategory.MEN
            false to Person.Gender.FEMALE -> MarketingCategory.WOMEN
            else -> MarketingCategory.GENERAL
        }
    }
}

// https://kotlinlang.org/docs/reference/extensions.html
fun Person.isMinor(): Boolean = this.age?.let { it < this.location.ageOfMajority ?: return@let false } ?: false

// https://kotlinlang.org/docs/reference/data-classes.html
data class Person (
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

enum class MarketingCategory {
    GIRLS, BOYS, WOMEN, MEN, GENERAL
}

enum class Location(val country: String, val ageOfMajority: Int?) {
    FI("Finland",18),
    US("United States of America", 21),
    UNKNOWN("unknown",null)
}