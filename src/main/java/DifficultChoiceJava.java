public class DifficultChoiceJava {

    /**
     * For spurious marketing reasons we need to check which marketing category we should
     * use for a person
     *
     * @param person Person to market to
     * @return MarketingCategory to be used
     */
    public MarketingCategory findMarketingCategory(PersonJava person) {
        if (isMinor(person)) {
            if (person.getGender() == Person.Gender.MALE) {
                return MarketingCategory.BOYS;
            }
            if (person.getGender() == Person.Gender.FEMALE) {
                return MarketingCategory.GIRLS;
            }
            return MarketingCategory.KIDS;
        }
        if (person.getGender() == Person.Gender.MALE) {
            return MarketingCategory.MEN;
        }
        if (person.getGender() == Person.Gender.FEMALE) {
            return MarketingCategory.WOMEN;
        }
        return MarketingCategory.ADULTS;
    }

    private Boolean isMinor(PersonJava person) {
        return person.getAge() != null && person.getLocation().getAgeOfMajority() != null &&
                person.getAge() < person.getLocation().getAgeOfMajority();
    }
}
