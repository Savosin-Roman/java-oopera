import java.util.ArrayList;
import java.util.Scanner;

public class TheatreManager {
    private static ArrayList<Show> shows = new ArrayList<>();
    private static ArrayList<Opera> operas = new ArrayList<>();
    private static ArrayList<Ballet> ballets = new ArrayList<>();

    public static void addInicialShow() {
        shows.add(new Show("На дне",
                Stage.HIGHT,
                Show.addInicialSDays(),
                1000.0,
                Director.getDirector(0),
                Show.addInicialActors()));
    }

    public static void addInicialBallet() {
        ballets.add(new Ballet("Лебединое озеро",
                Stage.MAIN,
                Show.addInicialSDays(),
                2000.0,
                Director.getDirector(0),
                Show.addInicialActors(),
                Person.getMusicalAutors(0),
                "Либретто",
                Person.getСhoreographer(0)));
    }

    public static void addInicialOpera() {
        operas.add(new Opera("Война и мир",
                Stage.MAIN,
                Show.addInicialSDays(),
                3000.0,
                Director.getDirector(0),
                Show.addInicialActors(),
                Person.getMusicalAutors(0),
                "Либретто",
                12));
    }

    public static void showsMenu(Scanner scanner) {
        while (true) {
            showMenu();
            System.out.print("Выберите, что нужно сделать: ");
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case (1):
                    getShow();
                    break;
                case (2):
                    addShow(scanner);
                    break;
                case (3):
                    removeShow(scanner);
                    break;
                case (4):
                    changeActorShow(scanner);
                    break;
                case (0):
                    System.out.println("========================================");
                    return;
            }
        }
    }

    public static void operasMenu(Scanner scanner) {
        while (true) {
            operaMenu();
            System.out.print("Выберите, что нужно сделать: ");
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case (1):
                    getOpera();
                    break;
                case (2):
                    addOpera(scanner);
                    break;
                case (3):
                    removeOpera(scanner);
                    break;
                case (4):
                    changeActorOpera(scanner);
                    break;
                case (0):
                    System.out.println("========================================");
                    return;
            }
        }
    }

    public static void balletMenu(Scanner scanner) {
        while (true) {
            balletMenu();
            System.out.print("Выберите, что нужно сделать: ");
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case (1):
                    getBallet();
                    break;
                case (2):
                    addBallet(scanner);
                    break;
                case (3):
                    removeBallet(scanner);
                    break;
                case (4):
                    changeActorBallet(scanner);
                    break;
                case (0):
                    System.out.println("========================================");
                    return;
            }
        }
    }

    public static void addShow(Scanner scanner) {
        if (Director.sumDirector() > 0 && Actor.sumActors() > 0) {
            Show show = new Show(Show.setTitle(scanner), Show.setStage(scanner), Show.setDaysOfWeeks(scanner),
                    Show.setPrise(scanner), Show.setDirector(scanner), Show.setActors(scanner));
            if (shows.contains(show)) {
                System.out.println("Такая пьеса уже есть");
            } else {
                shows.add(show);
            }
            System.out.println("Пьеса " + show.title + " добавлена");
            System.out.println("========================================");
        } else {
            System.out.println("Сначала нужно добавить режиссёров и актёров в главном меню");
        }
    }

    public static void addOpera(Scanner scanner) {
        if (Director.sumDirector() > 0 && Actor.sumActors() > 0) {
            Opera opera = new Opera(Opera.setTitle(scanner),
                    Opera.setStage(scanner),
                    Opera.setDaysOfWeeks(scanner),
                    Opera.setPrise(scanner),
                    Opera.setDirector(scanner),
                    Opera.setActors(scanner),
                    Opera.setMusicAuthor(scanner),
                    Opera.setLibrettoText(scanner),
                    Opera.setChoirSize(scanner));
            if (operas.contains(opera)) {
                System.out.println("Такая опера уже есть");
            } else {
                operas.add(opera);
            }
            System.out.println("Опера " + opera.title + " добавлена");
            System.out.println("========================================");
        } else {
            System.out.println("Сначала нужно добавить режиссёров и актёров в главном меню");
        }
    }

    public static void addBallet(Scanner scanner) {
        if (Director.sumDirector() > 0 && Actor.sumActors() > 0) {
            Ballet ballet = new Ballet(Ballet.setTitle(scanner),
                    Ballet.setStage(scanner),
                    Ballet.setDaysOfWeeks(scanner),
                    Ballet.setPrise(scanner),
                    Ballet.setDirector(scanner),
                    Ballet.setActors(scanner),
                    Ballet.setMusicAuthor(scanner),
                    Ballet.setLibrettoText(scanner),
                    Ballet.setChoreographer(scanner));
            if (ballets.contains(ballet)) {
                System.out.println("Такой балет уже есть");
            } else {
                ballets.add(ballet);
            }
            System.out.println("Опера " + ballet.title + " добавлена");
            System.out.println("========================================");
        } else {
            System.out.println("Сначала нужно добавить режиссёров и актёров в главном меню");
        }
    }

    public static void removeShow(Scanner scanner) {
        for (int i = 0; i < shows.size(); i++) {
            Show show = shows.get(i);
            System.out.println((i + 1) + ". " + show.getTitle());
        }
        System.out.print("Введите номер пьесы которую хотите удалить: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println(shows.get(number - 1) + "\nУдалена");
        shows.remove(number - 1);
        System.out.println("========================================");
    }

    public static void removeOpera(Scanner scanner) {
        for (int i = 0; i < operas.size(); i++) {
            Opera opera = operas.get(i);
            System.out.println((i + 1) + ". " + opera.getTitle());
        }
        System.out.print("Введите номер оперы которую хотите удалить: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println(operas.get(number - 1) + "\nУдалена");
        operas.remove(number - 1);
        System.out.println("========================================");
    }

    public static void removeBallet(Scanner scanner) {
        for (int i = 0; i < ballets.size(); i++) {
            Ballet ballet = ballets.get(i);
            System.out.println((i + 1) + ". " + ballet.getTitle());
        }
        System.out.print("Введите номер балета который хотите удалить: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println(ballets.get(number - 1) + "\nУдалён");
        ballets.remove(number - 1);
        System.out.println("========================================");
    }

    public static void getShow() {
        if (shows.isEmpty()) {
            System.out.println("Сейчас нет пьес");
            System.out.println("========================================");
        } else {
            for (int i = 0; i < shows.size(); i++) {
                System.out.println("\n" + (i + 1) + ". " + shows.get(i).toString());
                System.out.println("========================================");
            }
        }
    }

    public static void getOpera() {
        if (operas.isEmpty()) {
            System.out.println("Сейчас нет оперы");
            System.out.println("========================================");
        } else {
            for (int i = 0; i < operas.size(); i++) {
                System.out.println("\n" + (i + 1) + ". " + operas.get(i).toString());
                System.out.println("========================================");
            }
        }
    }

    public static void getBallet() {
        if (ballets.isEmpty()) {
            System.out.println("Сейчас нет балета");
            System.out.println("========================================");
        } else {
            for (int i = 0; i < ballets.size(); i++) {
                System.out.println("\n" + (i + 1) + ". " + ballets.get(i).toString());
                System.out.println("========================================");
            }
        }
    }

    public static void changeActorShow(Scanner scanner) {
        int i = 0;
        for (Show show: shows) {
            i = i + 1;
            System.out.println(i + ". " + show.title);
        }
        System.out.println("Выберете номер пьесы в которой хотите заменить актёра");
        int numberRemoveShow = scanner.nextInt();
        scanner.nextLine();
        i = 0;
        for (Person person: shows.get(numberRemoveShow - 1).actor) {
            i = i + 1;
            System.out.println(i + ". " + person.toString());
        }
        System.out.println("Выберете номер актёра которого хотите убрать:");
        int numberRemoveActor = scanner.nextInt();
        scanner.nextLine();
        Actor.listActors();
        System.out.println("Выберете актёра, которого хотите добавить");
        int numberAddActor = scanner.nextInt();
        scanner.nextLine();
        shows.get(numberRemoveShow - 1).actor.remove(numberRemoveActor - 1);
        shows.get(numberRemoveShow - 1).actor.add(Actor.getActor(numberAddActor - 1));
        System.out.println("Актёр изменён");
        }

    public static void changeActorBallet(Scanner scanner) {
        int i = 0;
        for (Ballet ballet: ballets) {
            i = i + 1;
            System.out.println(i + ". " + ballet.title);
        }
        System.out.println("Выберете номер балета в котором хотите заменить актёра");
        int numberRemoveShow = scanner.nextInt();
        scanner.nextLine();
        i = 0;
        for (Person person: ballets.get(numberRemoveShow - 1).actor) {
            i = i + 1;
            System.out.println(i + ". " + person.toString());
        }
        System.out.println("Выберете номер актёра которого хотите убрать:");
        int numberRemoveActor = scanner.nextInt();
        scanner.nextLine();
        Actor.listActors();
        System.out.println("Выберете актёра, которого хотите добавить");
        int numberAddActor = scanner.nextInt();
        scanner.nextLine();
        ballets.get(numberRemoveShow - 1).actor.remove(numberRemoveActor - 1);
        ballets.get(numberRemoveShow - 1).actor.add(Actor.getActor(numberAddActor - 1));
        System.out.println("Актёр изменён");
    }

    public static void changeActorOpera(Scanner scanner) {
        int i = 0;
        for (Opera opera: operas) {
            i = i + 1;
            System.out.println(i + ". " + opera.title);
        }
        System.out.println("Выберете номер оперы в которой хотите заменить актёра");
        int numberRemoveShow = scanner.nextInt();
        scanner.nextLine();
        i = 0;
        for (Person person: operas.get(numberRemoveShow - 1).actor) {
            i = i + 1;
            System.out.println(i + ". " + person.toString());
        }
        System.out.println("Выберете номер актёра которого хотите убрать:");
        int numberRemoveActor = scanner.nextInt();
        scanner.nextLine();
        Actor.listActors();
        System.out.println("Выберете актёра, которого хотите добавить");
        int numberAddActor = scanner.nextInt();
        scanner.nextLine();
        operas.get(numberRemoveShow - 1).actor.remove(numberRemoveActor - 1);
        operas.get(numberRemoveShow - 1).actor.add(Actor.getActor(numberAddActor - 1));
        System.out.println("Актёр изменён");
    }

    private static void showMenu() {
        System.out.println("1. Посмотреть список пьес");
        System.out.println("2. Добавить пьесу");
        System.out.println("3. Удалить пьесу");
        System.out.println("4. Заменить актёра");
        System.out.println("0. Выйти");
    }

    private static void operaMenu() {
        System.out.println("1. Посмотреть список опер");
        System.out.println("2. Добавить оперу");
        System.out.println("3. Удалить оперу");
        System.out.println("4. Заменить актёра");
        System.out.println("0. Выйти");
    }

    private static void balletMenu() {
        System.out.println("1. Посмотреть список балета");
        System.out.println("2. Добавить балет");
        System.out.println("3. Удалить балет");
        System.out.println("4. Заменить актёра");
        System.out.println("0. Выйти");
    }
}
