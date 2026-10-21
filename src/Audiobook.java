public class Audiobook extends Resource {
    String duration;

    public Audiobook (String title, String creator, long identifier, int ID, String duration) {
        super(title, creator, identifier, ID);
        this.duration = duration;
    }

    public String title() {
        return title;
    }

    public String author() {
        return creator;
    }

    public long ISBN(){
        return identifier;
    }

    public String duration() {
        return duration;
    }
    public String toString() {
        return String.format(title() +" forfatter: " + author() + " ISBN: " + ISBN() + " Bogens varighed: " + duration());
    }
}
