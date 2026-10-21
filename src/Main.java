void main() {

  Library library = new Library();


  Book book1 = new Book("Søren Sveistrup", "Kastanjemanden", 9781492072508L, 1, 50);

  Book book2 = new Book("Stine Pilgaard", "Meter i sekundet", 9788763851664L, 2, 65);

  Book book3 = new Book("Tove Jansson", "Kometen kommer", 9780062316097L, 3, 55);


  Member member1 = new Member("Jonas", 111);
  Member member2 = new Member("Filippos", 222);
  Member member3 = new Member("Peter", 333);



  library.addMember(member1);
  library.addMember(member2);
  library.addMember(member3);


  library.addBooks(book1);
  library.addBooks(book2);
  library.addBooks(book3);

  ConsoleUI consoleUI = new ConsoleUI(library);

  consoleUI.run();
}