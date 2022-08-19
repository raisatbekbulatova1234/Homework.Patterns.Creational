import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0 && age < 120) {
            this.age = OptionalInt.of(age);
        } else {
            throw new IllegalArgumentException("Недопустимый возраст");
        }
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (name == null || surname == null || name.isEmpty() || surname.isEmpty()) {
            throw new IllegalStateException("Не хватает обязательных полей (Фамилия/Имя)");
        } else if (age.isPresent()) {
            return new Person(name, surname, age.getAsInt(), city);
        } else {
            return new Person(name, surname, city);
        }
    }
}
