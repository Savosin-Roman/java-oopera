public class Main {
    public static void main(String[] args) {
        Actor actor1 = new Actor(Gender.FEMALE, "Алёна", "Васильева", 165);
        Actor actor2 = new Actor(Gender.MALE, "Сергей", "Петров", 180);
        Actor actor3 = new Actor(Gender.FEMALE, "Дарья", "Иванова", 160);

        Director director1 = new Director(Gender.MALE, "Пётр", "Николаев", 20);
        Director director2 = new Director(Gender.FEMALE, "Ангелина", "Заботина", 4);

        Person musicAutor = new Person(Gender.FEMALE, "Ирина", "Музыкалкина");
        Person choreographer = new Person(Gender.MALE, "Иван", "Танцевалкин");

        String libretto1 = "Либретто для оперы";
        String libretto2 = "Либретто для балета";

        Show show = new Show("Война и мир", director1, 120);
        Opera opera = new Opera("Верде", director2, 160, musicAutor, libretto1, 36);
        Ballet ballet = new Ballet("Лебединое озеро", director1, 180,
                musicAutor, libretto2, choreographer);

        show.setActor(actor1);
        show.setActor(actor3);

        opera.setActor(actor2);
        opera.setActor(actor3);

        ballet.setActor(actor1);

        show.getActors();
        opera.getActors();
        ballet.getActors();

        show.targetActor(actor2, "Алёна");
        show.getActors();
        ballet.targetActor(actor1, "Денис");

        System.out.println(opera.getLibrettoText());
        System.out.println(ballet.getLibrettoText());

        show.getDirrector();
        opera.getDirrector();
        ballet.getDirrector();
    }
}
