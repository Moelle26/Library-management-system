public class Resource implements Comparable <Resource> {

  final String title;
  final String creator;
  final long identifier;
  final int ID;

  public Resource(String title, String creator, long identifier, int ID) {
    this.title = title;
    this.creator = creator;
    this.identifier = identifier;
    this.ID = ID;
  }

  public long getIdentifier() {
    return identifier;
  }

  public int getID() {
    return ID;
  }

  public int compareTo(Resource other) {
    return Long.compare(this.getIdentifier(), other.getIdentifier());
  }
}
