public class Director extends Person {
    protected int numberOfShows;

    public Director(Gender gender, String name, String surname, int numberOfShows) {
        super(gender, name, surname);
        this.numberOfShows = numberOfShows;
    }

    public String toString() {
        return name + " " + surname;
    }
}
