import java.util.ArrayList;
import java.util.Scanner;

public class MusicalShow extends Show {
    Person musicAuthor;
    String librettoText;

    public MusicalShow(String title, Stage stage, ArrayList<DaysOfWeek> daysOfWeek, Double prise, Director director,
                       ArrayList<Actor> actor, Person musicAuthor, String librettoText) {
        super(title, stage, daysOfWeek, prise, director, actor);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }



    protected static Person setMusicAuthor(Scanner scanner) {
        while (true) {
            System.out.println("Введите номер автора музыки из списка: ");
            Person.listMusicalAutors();
            int number = scanner.nextInt();
            scanner.nextLine();
            if (number >= 0 && number <= Person.sumMusicalAutors()) {
                return Person.getMusicalAutors(number);
            } else {
                System.out.println("В списке нет автора музыки с таким номером");
            }
        }
    }


    protected static String setLibrettoText(Scanner scanner) {
        while (true) {
            System.out.print("Введите текст либретто: ");
            String name = scanner.nextLine();
            if (name != null) {
                return name;
            } else {
                System.out.println("Текст либретто нужно ввести обязательно");
            }
        }
    }

    //    public MusicalShow(String title, Stage stage, DaysOfWeek daysOfWeek, Double prise,
    //                   Director director, Actor actor, String musicAuthor, String librettoText) {

}
