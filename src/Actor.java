import java.util.Objects;

public class Actor extends Person {
    protected int hight;

    public Actor(Gender gender, String name, String surname, int height) {
        super(gender, name, surname);
        this.hight = height;
    }

    @Override
    public boolean equals(Object actor) {
        if (this == actor) return true;
        if (actor == null || getClass() != actor.getClass()) return false;
        Actor otherActor = (Actor) actor;
        return Objects.equals(name, otherActor.name) &&
                Objects.equals(surname, otherActor.surname) &&
                Objects.equals(hight, otherActor.hight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender, hight);
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + hight + ")";
    }
}