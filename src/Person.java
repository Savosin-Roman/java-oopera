public class Person {
    protected String name; // имя
    protected String surname; // фамилия
    protected Gender gender; // пол

    public Person(Gender gender, String name, String surname) {
        this.gender = gender;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
}