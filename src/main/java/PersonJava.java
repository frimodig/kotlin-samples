import java.util.Objects;

public class PersonJava {

    private String name;
    private Integer age;
    private Person.Gender gender;
    private Location location;

    public PersonJava(String name, Integer age, Person.Gender gender, Location location) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be null or empty");
        }
        this.name = name;
        setAge(age);
        setGender(gender);
        setLocation(location);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person.Gender getGender() {
        return gender;
    }

    public Location getLocation() {
        return location;
    }

    ///// Private setters to put default values

    private void setGender(Person.Gender gender) {
        this.gender = Objects.requireNonNullElse(gender, Person.Gender.NOT_SPECIFIED);
    }

    private void setLocation(Location location) {
        this.location = Objects.requireNonNullElse(location, Location.UNKNOWN);
    }

    ///// Data class needs sensible toString(), equals() & hashcode()

    @Override
    public String toString() {
        return "PersonJava{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonJava that = (PersonJava) o;
        return name.equals(that.name) &&
                Objects.equals(age, that.age) &&
                gender == that.gender &&
                location == that.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, location);
    }
}