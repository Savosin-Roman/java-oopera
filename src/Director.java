import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Director extends Person {
    String education;
    private static ArrayList<Director> directors = new ArrayList<>();

    public static void addInicialDirectors() {
        directors.add(new Director("Иван", "Иванов", Gender.МУЖ, "ВГИК"));
        directors.add(new Director("Василий", "Петров", Gender.МУЖ, "Учага"));
        directors.add(new Director("Иванна", "Трамп", Gender.ЖЕН, "ГИТИЗ"));
    }
    public static Director getDirector(int number) {
        return directors.get(number);
    }

    public Director(String name, String surname, Gender gender, String education) {
        super(name, surname, gender);
        this.education = education;
    }

    public static void addDirector(Scanner scanner) {
        Director director = new Director(Person.setName(scanner), Person.setSurname(scanner), Person.setGender(scanner),
                setEducation(scanner));
        if (directors.contains(director)) {
            System.out.println("Такой режиссёр уже есть");
        } else {
            directors.add(director);
            System.out.println("Новый режиссёр добавлен, теперь у нас режиссёров: " + directors.size());
        }
    }

    public static void mainMenu(Scanner scanner) {
        while (true) {
            menu();
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case (1):
                    listDirectors();
                    break;
                case (2):
                    addDirector(scanner);
                    break;
                case (3):
                    removeDirector(scanner);
                    break;
                case (0):
                    return;
            }
        }
    }

    public static void removeDirector(Scanner scanner) {
        listDirectors();
        System.out.println("Введите порядковый номер режиссёра, которого хотите уволить");
        int remove = scanner.nextInt();
        System.out.println("==============================");
        System.out.println("Режиссёр:");
        System.out.println(directors.get(remove - 1).toString());
        directors.remove(remove - 1);
        System.out.println("Уволен, теперь у нас режиссёров: " + directors.size());
    }

    public static int sumDirector() {
        return directors.size();
    }

    public static Director setDirector(int numDirector) {
        return directors.get(numDirector - 1);
    }

    public static void listDirectors() {
        if (directors.isEmpty()) {
            System.out.println("Сейчас нет режиссёров");
        } else {
            int i = 0;
            for (Director dir : directors) {
                i = i + 1;
                System.out.println(i + ". " + dir.toString());
            }
        }
        System.out.println("==============================");
    }

    private static String setEducation(Scanner scanner) {
        while (true) {
            System.out.print("Введите образование: ");
            String education = scanner.nextLine();
            if (education != null) {
                return education;
            } else {
                System.out.println("Должно быть образование");
            }
        }
    }

    private static void menu() {
        System.out.println("1. Список режиссёров");
        System.out.println("2. Добавить режиссёра");
        System.out.println("3. Удалить режиссёра");
        System.out.println("0. Выйти в главное меню");
    }


    @Override
    public boolean equals(Object director) {
        if (this == director) return true;
        if (director == null || getClass() != director.getClass()) return false;
        Director otherDirector = (Director) director;
        return Objects.equals(name, otherDirector.name) &&
                Objects.equals(surname, otherDirector.surname) &&
                Objects.equals(gender, otherDirector.gender) &&
                Objects.equals(education, otherDirector.education);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender, education);
    }

    @Override
    public String toString() {
        return  "Фамилия: " + surname  +
                "\n   Имя: " + name +
                "\n   Пол: " + gender +
                "\n   Образование: " + education;
    }
}
