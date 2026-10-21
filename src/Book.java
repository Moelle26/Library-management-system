public class Book extends Resource {
int ID;
  int page;

  public Book(String title, String creator, long identifier, int ID, int page) {
    super(title, creator, identifier);
    this.ID = ID;
    this.page = page;
  }

  public long identifier() {
    return identifier;
  }

  public String title() {
    return title;
  }

  public String creator() {
    return creator;
  }
}