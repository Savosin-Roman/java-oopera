public class Ballet extends MusicalShow {
    protected Person choreographer;

    public Ballet(String title, Director director, int duration, Person musicAuthor,
                  String librettoText, Person choreographer) {
        super(title, director, duration, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }
}
