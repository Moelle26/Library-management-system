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
        Book book = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
        String title = book.title();

        assertEquals("Kastanjemanden", title);
    }
    @Test
    void testIdentifier() {
        Book book = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1,50);
        long identifier = book.ISBN();
        assertEquals(9781492072508L,identifier);
    }
    @Test
    void testPages() {
        Book book = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1,50);
        int page = book.page();
        assertEquals(50,page);
    }
    @Test
    void testID() {
        Book book = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1,50);
        int ID = book.ID();
        assertEquals(1,ID);
    }


}
