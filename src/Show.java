import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Show {

    String title; // название
    Stage stage; // сцена (большая малая главная)
    ArrayList<DaysOfWeek> daysOfWeek; // по каким дням проводится
    Double prise; // стоимость
    Director director; // режиссёр
    ArrayList<Actor> actor; // актёры

    public static ArrayList<DaysOfWeek> addInicialSDays() {
        ArrayList<DaysOfWeek> daysOfWeeks = new ArrayList<>();
        daysOfWeeks.add(DaysOfWeek.TUESDAY);
        daysOfWeeks.add(DaysOfWeek.SUNDAY);
        return daysOfWeeks;
    }

    public static ArrayList<Actor> addInicialActors() {
        ArrayList<Actor> actors = new ArrayList<>();
        actors.add(Actor.getActor(0));
        return actors;
    }

    public Show(String title, Stage stage, ArrayList<DaysOfWeek> daysOfWeek, Double prise, Director director, ArrayList<Actor> actor) {
        this.title = title;
        this.stage = stage;
        this.daysOfWeek = daysOfWeek;
        this.prise = prise;
        this.director = director;
        this.actor = actor;
    }

    public String getTitle() {
        return title;
    }

    //
    protected static String setTitle(Scanner scanner) {
        while (true) {
            System.out.print("Введите название: ");
            String name = scanner.nextLine();
            if (name != null) {
                return name;
            } else {
                System.out.println("Имя нужно ввести обязательно");
            }
        }
    }

    protected static Stage setStage(Scanner scanner) {
        while (true) {
            System.out.println("На какой сцене будет проходить спектакль:");
            System.out.println("1. Главная сцена   2. Большая сцена   3. Малая сцена");
            int stage = scanner.nextInt();
            if (stage == 1) {
                return Stage.MAIN;
            } else if (stage == 2) {
                return Stage.HIGHT;
            } else if (stage == 3) {
                return Stage.SMALL;
            } else {
                System.out.println("Нет такого варианта");
            }
        }
    }

    protected static ArrayList<DaysOfWeek> setDaysOfWeeks(Scanner scanner) {
        ArrayList<DaysOfWeek> daysOfWeeks = new ArrayList<>();
        System.out.println("По каким дням будет проходить спектакль:");
        while (true) {
            System.out.println("1. Понедельник 2. Вторник 3. Среда 4. Четверг 5. Пятница 6. Суббота 7. Воскресенье");
            int day = scanner.nextInt();
            if (day == 1) {
                if (daysOfWeeks.contains(DaysOfWeek.MONDAY)) {
                    System.out.println("Такой день уже есть");
                } else {
                    daysOfWeeks.add(DaysOfWeek.MONDAY);
                }
            } else if (day == 2) {
                if (daysOfWeeks.contains(DaysOfWeek.TUESDAY)) {
                    System.out.println("Такой день уже есть");
                } else {
                    daysOfWeeks.add(DaysOfWeek.TUESDAY);
                }
            } else if (day == 3) {
                if (daysOfWeeks.contains(DaysOfWeek.WEDNESDAY)) {
                    System.out.println("Такой день уже есть");
                } else {
                    daysOfWeeks.add(DaysOfWeek.WEDNESDAY);
                }
            } else if (day == 4) {
                if (daysOfWeeks.contains(DaysOfWeek.THURSDAY)) {
                    System.out.println("Такой день уже есть");
                } else {
                    daysOfWeeks.add(DaysOfWeek.THURSDAY);
                }
            } else if (day == 5) {
                if (daysOfWeeks.contains(DaysOfWeek.FRIDEY)) {
                    System.out.println("Такой день уже есть");
                } else {
                    daysOfWeeks.add(DaysOfWeek.FRIDEY);
                }
            } else if (day == 6) {
                if (daysOfWeeks.contains(DaysOfWeek.SARURDAY)) {
                    System.out.println("Такой день уже есть");
                } else {
                    daysOfWeeks.add(DaysOfWeek.SARURDAY);
                }
            } else if (day == 7) {
                if (daysOfWeeks.contains(DaysOfWeek.SUNDAY)) {
                    System.out.println("Такой день уже есть");
                } else {
                    daysOfWeeks.add(DaysOfWeek.SUNDAY);
                }
            } else if (day == 0){
                if (daysOfWeeks.isEmpty()) {
                    System.out.println("Нужно выбрать хотя-бы 1 день недели");
                } else {
                    break;
                }
            } else {
                System.out.println("Нет такого варианта");
            }
            System.out.println("Выберете ещё день, или нажмите 0 для продолжения");
        }
        return daysOfWeeks;
    }

    protected static double setPrise(Scanner scanner) {
        while (true) {
            System.out.print("Введите стоимость билета: ");
            double prise = scanner.nextInt();
            scanner.nextLine();
            if (prise > 0) {
                return prise;
            }
        }
    }

    protected static Director setDirector(Scanner scanner) {
        while (true) {
            System.out.println("Введите номер режиссёра из списка: ");
            Director.listDirectors();
            int directorNumber = scanner.nextInt();
            scanner.nextLine();
            if (directorNumber >= 0 && directorNumber <= Director.sumDirector()) {
                return Director.setDirector(directorNumber);
            } else {
                System.out.println("В списке нет режиссёра с таким номером");
            }
        }
    }

    protected static ArrayList<Actor> setActors(Scanner scanner) {
        ArrayList<Actor> actors = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер актёра которого хотите добавить:");
            Actor.listActors();
            int numberActors = scanner.nextInt();
            scanner.nextLine();
            if (numberActors >= 0 && numberActors <= Actor.sumActors()) {
                if (actors.contains(Actor.getActor(numberActors - 1))) {
                    System.out.println("Такой актёр уже есть");
                } else {
                    actors.add(Actor.getActor(numberActors - 1));
                }
            } else {
                System.out.println("В списке нет актёра с таким номером");
            }
            System.out.println("Хотите выбрать ещё одного актёра: 1. - Да   2. - Нет");
            int endNumber = scanner.nextInt();
            scanner.nextLine();
            if (endNumber != 1) {
                break;
            }
        }
        return actors;
    }
    @Override
    public boolean equals(Object show) {
        if (this == show) return true;
        if (show == null || getClass() != show.getClass()) return false;
        Show otherShow = (Show) show;
        return Objects.equals(title, otherShow.title) &&
                Objects.equals(stage, otherShow.stage) &&
                Objects.equals(daysOfWeek, otherShow.daysOfWeek) &&
                Objects.equals(prise, otherShow.prise) &&
                Objects.equals(director, otherShow.director) &&
                Objects.equals(actor, otherShow.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, stage, daysOfWeek, prise, director, actor);
    }

    @Override
    public String toString() {
        return "Название: " + title +
                "\n   Сцена: " + stage +
                "\n   Дни показа: " + daysOfWeek +
                "\n   Стоимость: " + prise + " руб." +
                "\n   Режиссёр:\n   " + director +
                "\n   Актёры:\n   " + actor;
    }
}
