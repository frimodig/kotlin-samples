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
            if (person.getGender() == PersonJava.Gender.MALE) {
                return MarketingCategory.BOYS;
            }
            if (person.getGender() == PersonJava.Gender.FEMALE) {
                return MarketingCategory.GIRLS;
            }
        }
        if (person.getGender() == PersonJava.Gender.MALE) {
            return MarketingCategory.MEN;
        }
        if (person.getGender() == PersonJava.Gender.FEMALE) {
            return MarketingCategory.WOMEN;
        }
        return MarketingCategory.GENERAL;
    }

    private Boolean isMinor(PersonJava person) {
        return person.getAge() != null && person.getLocation().getAgeOfMajority() != null &&
                person.getAge() < person.getLocation().getAgeOfMajority();
    }
}
