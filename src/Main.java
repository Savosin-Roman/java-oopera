import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, Show> shows = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Поехали!");
        Director.addInicialDirectors();
        Actor.addInicialActors();
        Person.addInicialmusicalAutors();
        Person.addInicialСhoreographer();
        TheatreManager.addInicialShow();
        TheatreManager.addInicialBallet();
        TheatreManager.addInicialOpera();

        while (true) {
            mainMenu();
            int menuNumber = scanner.nextInt();
            scanner.nextLine();
            switch (menuNumber) {
                case (1):
                    info();
                    break;
                case (2):
                    Actor.mainMenu(scanner);
                    break;
                case (3):
                    Director.mainMenu(scanner);
                    break;
                case (4):
                    Person.musicalAutorsMenu(scanner);
                    break;
                case (5):
                    Person.choreographerMenu(scanner);
                    break;
                case (6):
                    TheatreManager.showsMenu(scanner);
                    break;
                case (7):
                    TheatreManager.balletMenu(scanner);
                    break;
                case (8):
                    TheatreManager.operasMenu(scanner);
                    break;
                case (0):
                    return;
            }
        }
    }

    private static void mainMenu() {
        System.out.println("1. Инфромация о театре");
        System.out.println("2. Актёры нашего театра");
        System.out.println("3. Режиссёры нашего театра");
        System.out.println("4. Авторы музыки");
        System.out.println("5. Хореографы");
        System.out.println("-------- Репертуар --------");
        System.out.println("6. Пьеса");
        System.out.println("7. Балет");
        System.out.println("8. Опера");
        System.out.println("0. Выход");
        System.out.print("Введите номер пункта меню: ");
    }

    private static void info() {
        System.out.println("========================================");
        System.out.println("В нашем театре 3 сцены - главная, большая и малая");
        System.out.println("Сейчас у нас актёров - " + Actor.sumActors() + " и режиссёров - "
                + Director.sumDirector());
        System.out.println("========================================");
    }

    private static void directorsMenu() {
        System.out.println("1. Список режиссёров");
        System.out.println("2. Добавить режиссёра");
        System.out.println("3. Удалить режиссёра");
        System.out.println("0. Выйти в главное меню");
    }
}