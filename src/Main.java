void main() {

  Library library = new Library();

  Book book1 = new Book("Søren Sveistrup",
          "Kastanjemanden",
          "9781492072508", 1);

  Book book2 = new Book("Stine Pilgaard",
          "Meter i sekundet",
          "9788763851664", 2);

  Book book3 = new Book("Tove Jansson",
          "Kometen kommer",
          "9780062316097", 3);

  Member member1 = new Member("Jonas", 111);
  Member member2 = new Member("Filippos", 222);
  Member member3 = new Member("Peter", 333);


  library.addMember(member1);
  library.addMember(member2);
  library.addMember(member3);


  library.addBook(book1);
  library.addBook(book2);
  library.addBook(book3);

  ConsoleUI consoleUI = new ConsoleUI(library);

  consoleUI.run();
}