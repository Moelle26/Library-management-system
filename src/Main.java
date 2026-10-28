void main() {


    Library library = new Library();


//Book oprettelse
    Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
    Book book2 = new Book("Meter i sekundet", "Stine Pilgaard", 9788763851664L, 2, 65);
    Book book3 = new Book("Kometen kommer", "Tove Jansson", 9780062316097L, 3, 55);

    //movie oprettelse
    Movie movie1 = new Movie("The Uprising", "Scanbox A/S", 2736482748L, 4, "Paul Greengrass", "127 min");

    // Videogame oprettelse
    Videogame videogame1 = new Videogame("GTA 6", "Rockstar", 6738748208L, 5, "Playstation");

    // Audiobook oprettelse
    Audiobook audiobook1 = new Audiobook("Mørkeland", "Camilla og Kristine", 43776895894L, 6, "12,2 timer");

    //member oprettelse
    Member member1 = new Member("Galf", 111);
    Member member2 = new Member("Søren", 222);
    Member member3 = new Member("Peter", 333);


    library.addResource(book1);
    library.addResource(book2);
    library.addResource(book3);

    library.addResource(movie1);

    library.addResource(videogame1);

    library.addResource(audiobook1);

    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);


    ConsoleUI consoleUI = new ConsoleUI(library);

    consoleUI.run();
}