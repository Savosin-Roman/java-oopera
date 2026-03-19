import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Opera extends MusicalShow {
    int choirSize;

    public Opera(String title, Stage stage, ArrayList<DaysOfWeek> daysOfWeek, Double prise, Director director,
                 ArrayList<Actor> actor, Person musicAuthor, String librettoText, int choirSize) {
        super(title, stage, daysOfWeek, prise, director, actor, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }

    private ArrayList<Actor> actorsInOpera = new ArrayList<>();

    protected static int setChoirSize(Scanner scanner) {
        while (true) {
            System.out.print("Введите размер хора: ");
            int choirSize = scanner.nextInt();
            scanner.nextLine();
            if (choirSize > 0) {
                return choirSize;
            } else {
                System.out.println("Хор должен состоять хотя-бы из одного человека");
            }
        }
    }

//    public void addActor(Scanner scanner) {
//        System.out.println("Список актёров нашего театра:");
//        Actor.listActors();
//        System.out.print("Для добавления актёра введите его номер: ");
//        int actorNumber = scanner.nextInt();
//        actorsInOpera.add(Actor.getActor(actorNumber));
//    }
//
//    public void showInformation() {
//        System.out.println("Опера");
//    }

    @Override
    public boolean equals(Object opera) {
        if (this == opera) return true;
        if (opera == null || getClass() != opera.getClass()) return false;
        Opera otherOpera = (Opera) opera;
        return Objects.equals(title, otherOpera.title) &&
                Objects.equals(stage, otherOpera.stage) &&
                Objects.equals(daysOfWeek, otherOpera.daysOfWeek) &&
                prise == otherOpera.prise &&
                Objects.equals(director, otherOpera.director) &&
                Objects.equals(actor, otherOpera.actor) &&
                Objects.equals(musicAuthor, otherOpera.musicAuthor) &&
                Objects.equals(librettoText, otherOpera.librettoText) &&
                choirSize == otherOpera.choirSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, stage, daysOfWeek, prise, director, actor, musicAuthor, librettoText, choirSize);
    }

    @Override
    public String toString() {
        return "Название: " + title +
                "\n   Сцена: " + stage +
                "\n   Дни показа: " + daysOfWeek +
                "\n   Стоимость: " + prise + " руб." +
                "\n   Режиссёр:\n   " + director +
                "\n   Актёры:\n   " + actor +
                "\n   Размер хора: " + choirSize;
    }
}