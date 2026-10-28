public class Movie extends Resource {
  String director;
  String duration;

  public Movie(String title, String creator, long identifier, int ID, String director, String duration) {
    super(title, creator, identifier, ID);
    this.director = director;
    this.duration = duration;
  }

  public String title() {
    return title;
  }

  public String studio() {
    return creator;
  }

  public long EAN() {
    return identifier;
  }

  public int ID() {
    return ID;
  }

  public String director() {
    return director;
  }

  public String duration() {
    return duration;
  }

  public String toString() {
    return String.format(title() + " instrukør: " + director() + " Studio: " + studio() + " Filmens varighed: " + duration());
  }
}
