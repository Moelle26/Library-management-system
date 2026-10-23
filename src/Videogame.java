public class Videogame extends Resource{
    String platform;

    public Videogame(String title, String creator, long identifier, int ID, String platform) {
        super(title, creator, identifier, ID);
        this.platform = platform;
    }

    public String title(){
        return title;
    }

    public String studio() {
        return creator;
    }

    public long EAN() {
        return identifier;
    }

    public String platform(){
        return platform;
    }

    public int ID(){
        return ID;
    }
    public String toString() {
        return String.format(title() +" studio: " + studio() + " EAN: " + EAN() + " platform: " + platform());
    }
}
