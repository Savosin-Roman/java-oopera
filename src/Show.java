import java.util.ArrayList;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors;

    public Show(String title, Director director, int duration) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        listOfActors = new ArrayList<>();
    }

    public void getActors() {
        for (Actor a : listOfActors) {
            System.out.println(a.toString());
        }
        System.out.println("==============================");
    }

    public void setActor(Actor actor) {
        boolean dublActor = false;
        for (Actor a : listOfActors) {
            if (actor.equals(a)) {
                System.out.println("Такой актёр уже есть");
                dublActor = true;
                break;
            }
        }
        if (!dublActor) {
            listOfActors.add(actor);
        }
    }

    public void targetActor(Actor actor, String name) {
        Actor targetActor = null;
        for (Actor a : listOfActors) {
            if (name.equals(a.getName())) {
                targetActor = a;
            }
        }
        if (targetActor == null) {
            System.out.println("Такого актёра нет");
        } else {
            listOfActors.remove(targetActor);
            listOfActors.add(actor);
            System.out.println("Актёр заменён");
        }
    }
}
