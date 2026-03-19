import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Ballet extends MusicalShow {
    Person choreographer;

    public Ballet(String title, Stage stage, ArrayList<DaysOfWeek> daysOfWeek, Double prise,
                  Director director, ArrayList<Actor> actor, Person musicAuthor, String librettoText, Person choreographer) {
        super(title, stage, daysOfWeek, prise, director, actor, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    protected static Person setChoreographer(Scanner scanner) {
        while (true) {
            System.out.println("Введите номер хореографа из списка: ");
            Person.listСhoreographer();
            int number = scanner.nextInt();
            scanner.nextLine();
            if (number >= 0 && number <= Person.sumChoreographer()) {
                return Person.getСhoreographer(number);
            } else {
                System.out.println("В списке нет автора музыки с таким номером");
            }
        }
    }

    @Override
    public boolean equals(Object ballet) {
        if (this == ballet) return true;
        if (ballet == null || getClass() != ballet.getClass()) return false;
        Ballet otherBallet = (Ballet) ballet;
        return Objects.equals(title, otherBallet.title) &&
                Objects.equals(stage, otherBallet.stage) &&
                Objects.equals(daysOfWeek, otherBallet.daysOfWeek) &&
                prise == otherBallet.prise &&
                Objects.equals(director, otherBallet.director) &&
                Objects.equals(actor, otherBallet.actor) &&
                Objects.equals(musicAuthor, otherBallet.musicAuthor) &&
                Objects.equals(librettoText, otherBallet.librettoText) &&
                Objects.equals(choreographer, otherBallet.choreographer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, stage, daysOfWeek, prise, director, actor, musicAuthor, librettoText, choreographer);
    }

    @Override
    public String toString() {
        return "Название: " + title +
                "\n   Сцена: " + stage +
                "\n   Дни показа: " + daysOfWeek +
                "\n   Стоимость: " + prise + " руб." +
                "\n   Режиссёр:\n   " + director +
                "\n   Актёры:\n   " + actor +
                "\n   Хореограф: " + choreographer;
    }
}
