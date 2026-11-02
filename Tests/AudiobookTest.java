import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudiobookTest {

  Audiobook audiobook;

  @BeforeEach
  void setup() {
    audiobook = new Audiobook("Mørkeland", "Camilla og Kristine", 43776895894L, 6, "12,2 timer");
  }

  @Test
  void testTitle() {
    //Act
    String title = audiobook.title();
    //Assert
    assertEquals("Mørkeland", title);
  }

  @Test
  void testCreator() {
    //Act
    String creator = audiobook.author();
    //Assert
    assertEquals("Camilla og Kristine", creator);
  }

  @Test
  void testIdentifier() {
    //Act
    Long identifier = audiobook.ISBN();
    //Assert
    assertEquals(43776895894L, identifier);
  }

  @Test
  void testDuration() {
    //Act
    String duration = audiobook.duration();
    //Assert
    assertEquals("12,2 timer", duration);
  }
  @Test
  void testSaveAudiobooks() throws IOException {

    List<Audiobook> audiobooks = List.of(
             new Audiobook("Mørkeland", "Camilla og Kristine", 43776895894L, 6, "12,2 timer"));

    LibrarySaver librarySaver = new LibrarySaver();

    librarySaver.saveAudiobooks(audiobooks, "test-audiobooks.csv");
    String n = System.lineSeparator();

    String expected = "Mørkeland,Camilla og Kristine,43776895894,12,2 timer" + n;

    var actual = Files.readString(Path.of("test-audiobooks.csv"));

    assertEquals(expected, actual);
  }
}
