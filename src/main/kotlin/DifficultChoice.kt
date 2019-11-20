class DifficultChoice {

    /**
     * For spurious marketing reasons we need to check which marketing category we should
     * use for a person
     *
     * @param person Person to market to
     * @return MarketingCategory to be used
     */
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

data class Person (
        val name: String,
        var age: Int?,
        val gender: Gender = Gender.NOT_SPECIFIED,
        val location: Location = Location.UNKNOWN
) {
    init {
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