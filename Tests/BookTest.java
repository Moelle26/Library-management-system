import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

  @Test
  void testCreator() {
    //Arrange
    Book book = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
    //Act
    String creator = book.author();
    //Assert
    assertEquals(" Søren Sveistrup", creator);
  }

  @Test
  void testTitle() {
    //Arrange
    Book book = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
    //Act
    String title = book.title();
    //Assert
    assertEquals("Kastanjemanden", title);
  }

  @Test
  void testIdentifier() {
    //Arrange
    Book book = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
    //Act
    long identifier = book.ISBN();
    //Assert
    assertEquals(9781492072508L, identifier);
  }

  @Test
  void testPages() {
    //Arrange
    Book book = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
    //Act
    int page = book.page();
    //Assert
    assertEquals(50, page);
  }

  @Test
  void testID() {
    //Arrange
    Book book = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
    //Act
    int ID = book.ID();
    //Assert
    assertEquals(1, ID);
  }
}