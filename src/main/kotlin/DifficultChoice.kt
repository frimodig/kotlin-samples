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
// p.s do not do it like this even though you can
fun Person.isMinor(): Boolean = this.age?.let { it < this.location.ageOfMajority ?: return@let false } ?: false