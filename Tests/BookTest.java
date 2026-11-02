import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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

    @Test
    void testSaveBooks() throws IOException {

        List<Book> books = List.of(
                new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50),
                new Book("Meter i sekundet", "Stine Pilgaard", 9788763851664L, 2, 65),
                new Book("Kometen kommer", "Tove Jansson", 9780062316097L, 3, 55));

        LibrarySaver librarySaver = new LibrarySaver();

        librarySaver.saveBooks(books, "test-books.csv");
        String n = System.lineSeparator();

        String expected = "Kastanjemanden, Søren Sveistrup,9781492072508,1,50" + n
               +  "Meter i sekundet,Stine Pilgaard,9788763851664,2,65" + n
               + "Kometen kommer,Tove Jansson,9780062316097,3,55"+n;

        var actual = Files.readString(Path.of("test-books.csv"));

        assertEquals(expected, actual);
    }
}