import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Actor extends Person {
    int hight; // рост в см.
    private static ArrayList<Actor> actors = new ArrayList<>();

    public static void addInicialActors() {
        actors.add(new Actor("Иван", "Иванов", Gender.МУЖ, 180));
        actors.add(new Actor("Василий", "Петров", Gender.МУЖ, 160));
    }

    public Actor(String name, String surname, Gender gender, int hight) {
        super(name, surname, gender);
        this.hight = hight;
    }

    public static void addActor(Scanner scanner) {
        Actor actor = new Actor(Person.setName(scanner), Person.setSurname(scanner), Person.setGender(scanner),
                setHight(scanner));
        if (actors.contains(actor)) {
            System.out.println("Такой актёр уже есть");
        } else {
            actors.add(actor);
            System.out.println("Новый актёр добавлен, теперь у нас актёров: " + actors.size());
        }
    }

    public static void mainMenu(Scanner scanner) {
        while (true) {
            menu();
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case (1):
                    listActors();
                    break;
                case (2):
                    addActor(scanner);
                    break;
                case (3):
                    removeActor(scanner);
                    break;
                case (0):
                    return;
            }
        }
    }

    public static void removeActor(Scanner scanner) {
        listActors();
        System.out.print("Введите порядковый номер актёра, которого хотите уволить: ");
        int remove = scanner.nextInt();
        scanner.nextLine();
        System.out.println("==============================");
        System.out.println("Актёр:");
        System.out.println(actors.get(remove - 1).toString());
        actors.remove(remove - 1);
        System.out.println("Уволен, теперь у нас актёров: " + actors.size());
    }

    public static Actor getActor(int numberActor) {
        return actors.get(numberActor);
    }

    public static Actor setActor(int numActor) {
        return actors.get(numActor - 1);
    }

    public static int sumActors() {
        return actors.size();
    }

    public static void listActors() {
        if (actors.isEmpty()) {
            System.out.println("Сейчас нет актёров");
        } else {
            int i = 0;
            for (Actor dir : actors) {
                i = i + 1;
                System.out.println(i + ". " + dir.toString());
            }
        }
    }

    private static void menu() {
        System.out.println("========================================");
        System.out.println("1. Список актёров");
        System.out.println("2. Добавить актёра");
        System.out.println("3. Удалить актёра");
        System.out.println("0. Выйти в главное меню");
        System.out.print("Введите номер пункта меню: ");
    }

    private static int setHight(Scanner scanner) {
        while (true) {
            System.out.println("Введите рост:");
            int hight = scanner.nextInt();
            scanner.nextLine();
            if (hight > 0) {
                return hight;
            } else {
                System.out.println("Рост должен быть больше 0");
            }
        }
    }

    @Override
    public boolean equals(Object actor) {
        if (this == actor) return true;
        if (actor == null || getClass() != actor.getClass()) return false;
        Actor otherActor = (Actor) actor;
        return Objects.equals(name, otherActor.name) &&
                Objects.equals(surname, otherActor.surname) &&
                Objects.equals(gender, otherActor.gender) &&
                Objects.equals(hight, otherActor.hight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender, hight);
    }

    @Override
    public String toString() {
        return "Фамилия: " + surname +
                "\n   Имя: " + name +
                "\n   Пол: " + gender +
                "\n   Рост: " + hight + " см.\n";
    }
}
