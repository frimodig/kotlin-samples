class DifficultChoice {

    /**
     * For spurious marketing reasons we need to check which marketing category we should
     * use for a person
     *
     * @param person Person to market to
     * @return MarketingCategory to be used
     */
    fun findMarketingCategory(person: Person): MarketingCategory {
        return when (isMinor(person)) {
            true -> {
                when (person.gender) {
                    Person.Gender.MALE -> MarketingCategory.BOYS
                    Person.Gender.FEMALE -> MarketingCategory.GIRLS
                    else -> MarketingCategory.KIDS
                }
            }
            false -> {
                when (person.gender) {
                    Person.Gender.MALE -> MarketingCategory.MEN
                    Person.Gender.FEMALE -> MarketingCategory.WOMEN
                    else -> MarketingCategory.ADULTS
                }
            }
        }
    }

    private fun isMinor(person: Person): Boolean =
            person.age?.let { it < person.location.ageOfMajority ?: return@let false } ?: false
}

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
    GIRLS, BOYS, KIDS, WOMEN, MEN, ADULTS
}

enum class Location(val country: String, val ageOfMajority: Int?) {
    FI("Finland",18),
    US("United States of America", 21),
    UNKNOWN("unknown",null)
}