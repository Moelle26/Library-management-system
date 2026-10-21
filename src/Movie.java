public class Movie extends Resource {
    String director;
    String duration;

    public Movie(String title, String creator, long identifier,String director, String duration) {
        super(title, creator, identifier);
        this.director = director;
        this.duration = duration;
    }

    public String title() {
        return title;
    }

    public String studio(){
        return creator;
    }

    public long EAN(){
        return identifier;
    }

    public String director(){
        return director;
    }

    public String duration() {
        return duration;
    }

    public String toString() {
        return String.format(title() +" instrukør:" + director() + " Studio: " + studio() + " Filmens varighed: " + duration());
    }
}
