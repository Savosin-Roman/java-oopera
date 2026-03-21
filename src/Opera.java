public class Opera extends MusicalShow {
    protected int choirSize;

    public Opera(String title, Director director, int duration, Person musicAuthor,
                 String librettoText, int choirSize) {
        super(title, director, duration, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }
}
