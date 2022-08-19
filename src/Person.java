import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private OptionalInt age = OptionalInt.empty();
    private String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.city = city;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return city != null && !city.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(city).setAge(0);
    }

    @Override
    public String toString() {
        return String.format("%s %s (Возраст: %s Город: %s)",
                name,
                surname,
                (age.isPresent() ? age.getAsInt() : "неизвестно"),
                (!city.isEmpty() ? city : "неизвестно"));
    }
}
