import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Person {
    String name; // имя
    String surname; // фамилия
    Gender gender; // пол

    private static ArrayList<Person> musicalAutors = new ArrayList<>();
    private static ArrayList<Person> choreographers = new ArrayList<>();

    public Person(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }
    public static void addInicialmusicalAutors() {
        musicalAutors.add(new Person("Корней", "Чайковский", Gender.МУЖ));
    }
    public static void addInicialСhoreographer() {
        choreographers.add(new Person("Иван", "Танеев", Gender.МУЖ));
    }

    public static Person getMusicalAutors(int number) {
        return musicalAutors.get(number);
    }

    public static Person getСhoreographer(int number) {
        return choreographers.get(number);
    }

    public static void musicalAutorsMenu(Scanner scanner) {
        while (true) {
            musicalAutorMenu();
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case (1):
                    listMusicalAutors();
                    break;
                case (2):
                    addMusicalAutors(scanner);
                    break;
                case (3):
                    removeMusicalAutors(scanner);
                    break;
                case (0):
                    return;
            }
        }
    }

    public static void choreographerMenu(Scanner scanner) {
        while (true) {
            choreografMenu();
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case (1):
                    listСhoreographer();
                    break;
                case (2):
                    addChoreographer(scanner);
                    break;
                case (3):
                    removeСhoreographer(scanner);
                    break;
                case (0):
                    return;
            }
        }
    }

    public static void addMusicalAutors(Scanner scanner) {
        Person person = new Person(Person.setName(scanner), Person.setSurname(scanner), Person.setGender(scanner));
        if (musicalAutors.contains(person)) {
            System.out.println("Такой автор музыки уже есть");
        } else {
            musicalAutors.add(person);
            System.out.println("Новый автор музыки добавлен, теперь у нас их: " + musicalAutors.size());
        }
    }

    public static void addChoreographer(Scanner scanner) {
        Person person = new Person(setName(scanner), setSurname(scanner), setGender(scanner));
        if (choreographers.contains(person)) {
            System.out.println("Такой хореограф уже есть");
        } else {
            choreographers.add(person);
            System.out.println("Новый хореограф добавлен, теперь у нас хореографов: " + choreographers.size());
        }
    }

    public static void removeMusicalAutors(Scanner scanner) {
        listMusicalAutors();
        System.out.print("Введите порядковый номер автора музыки, которого хотите уволить: ");
        int remove = scanner.nextInt();
        scanner.nextLine();
        System.out.println("==============================");
        System.out.println("Автор музыки:");
        System.out.println(musicalAutors.get(remove - 1).toString());
        musicalAutors.remove(remove - 1);
        System.out.println("Уволен, теперь у нас авторов музыки: " + musicalAutors.size());
    }

    public static void removeСhoreographer(Scanner scanner) {
        listСhoreographer();
        System.out.print("Введите порядковый номер хореографа, которого хотите уволить: ");
        int remove = scanner.nextInt();
        scanner.nextLine();
        System.out.println("==============================");
        System.out.println("Хореограф:");
        System.out.println(choreographers.get(remove - 1).toString());
        choreographers.remove(remove - 1);
        System.out.println("Уволен, теперь у нас хореографов: " + choreographers.size());
    }

    public static void listСhoreographer() {
        if (choreographers.isEmpty()) {
            System.out.println("Сейчас нет хореографов");
        } else {
            int i = 0;
            for (Person cor : choreographers) {
                i = i + 1;
                System.out.println(i + ". " + cor.toString());
            }
        }
    }

    public static void listMusicalAutors() {
        if (musicalAutors.isEmpty()) {
            System.out.println("Сейчас нет авторов музыки");
        } else {
            int i = 0;
            for (Person autors : musicalAutors) {
                i = i + 1;
                System.out.println(i + ". " + autors.toString());
            }
        }
    }

    public static int sumMusicalAutors() {
        return musicalAutors.size();
    }

    public static int sumChoreographer() {
        return choreographers.size();
    }
    private static void musicalAutorMenu() {
        System.out.println("========================================");
        System.out.println("1. Список авторов музыки");
        System.out.println("2. Добавить автора музыки");
        System.out.println("3. Удалить автора музыки");
        System.out.println("0. Выйти в главное меню");
        System.out.print("Введите номер пункта меню: ");
    }

    private static void choreografMenu() {
        System.out.println("========================================");
        System.out.println("1. Список хореографов");
        System.out.println("2. Добавить хореографа");
        System.out.println("3. Удалить хореографа");
        System.out.println("0. Выйти в главное меню");
        System.out.print("Введите номер пункта меню: ");
    }

    protected static String setName(Scanner scanner) {
        while (true) {
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            if (name != null) {
                return name;
            }
        }
    }

    protected static String setSurname(Scanner scanner) {
        while (true) {
            System.out.print("Введите фамилию: ");
            String surname = scanner.nextLine();
            if (surname != null) {
                return surname;
            }
        }
    }

    protected static Gender setGender(Scanner scanner) {
        while (true) {
            System.out.println("Выберете пол: 1. Мужской, 2. Женский");
            int gender = scanner.nextInt();
            scanner.nextLine();
            if (gender == 1) {
                return Gender.МУЖ;
            } else if (gender == 2) {
                return Gender.ЖЕН;
            } else {
                System.out.println("Такого варианта нет");
            }
        }
    }

    @Override
    public boolean equals(Object person) {
        if (this == person) return true;
        if (person == null || getClass() != person.getClass()) return false;
        Person otherPerson = (Person) person;
        return Objects.equals(name, otherPerson.name) &&
                Objects.equals(surname, otherPerson.surname) &&
                Objects.equals(gender, otherPerson.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender);
    }

    @Override
    public String toString() {
        return "Фамилия: " + surname +
                "\n   Имя: " + name +
                "\n   Пол: " + gender;
    }


}