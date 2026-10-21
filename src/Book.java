public class Book extends Resource {
    int page;

    public Book(String title, String creator, long identifier, int ID, int page) {
        super(title, creator, identifier, ID);
        this.page = page;
    }

    public long ISBN() {
        return identifier;
    }

    public String title() {
        return title;
    }

    public String author() {
        return creator;
    }

    public int ID() {
        return ID;
    }

    public int page() {
        return page;
    }

    public String toString() {
        return String.format(title() +" af: " + author() + " ISBN: " + ISBN() + " Antal sider: " + page());
    }

}