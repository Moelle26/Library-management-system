import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudiobookTest {

    Audiobook audiobook;

    @BeforeEach
    void setup() {
        audiobook = new Audiobook("Mørkeland", "Camilla og Kristine", 43776895894L, 6, "12,2 timer");
    }

    @Test
    void testTitle() {
        //Arrange
        //Act
        String title = audiobook.title();
        //Assert
        assertEquals("Mørkeland", title);
    }
    @Test
    void testCreator() {
        //Arrange
        //Act
        String creator = audiobook.author();
        //Assert
        assertEquals("Camilla og Kristine", creator);
    }
    @Test
    void testIdentifier() {
        //Arrange
        //Act
        Long identifier = audiobook.ISBN();
        //Assert
        assertEquals(43776895894L, identifier);
    }
    @Test
    void testDuration() {
        //Arrange
        //Act
        String duration = audiobook.duration();
        //Assert
        assertEquals("12,2 timer", duration);
    }
}
