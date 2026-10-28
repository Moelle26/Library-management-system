import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VideogameTest {

  Videogame videogame;

  @BeforeEach
  void setup() {
    videogame = new Videogame("GTA 6", "Rockstar", 6738748208L, 5, "Playstation");
  }

  @Test
  void testTitle() {
    //Act
    String title = videogame.title();

    //assert
    assertEquals("GTA 6", title);
  }

  @Test
  void testCreator() {
    //Act
    String creator = videogame.studio();

    //assert
    assertEquals("Rockstar", creator);
  }

  @Test
  void testIdentifier() {
    //Act
    Long identifier = videogame.EAN();

    //assert
    assertEquals(6738748208L, identifier);
  }

  @Test
  void testID() {
    //Act
    int ID = videogame.ID();

    //assert
    assertEquals(5, ID);
  }

  @Test
  void testPlatform() {
    //Act
    String platform = videogame.platform();
    //Assert
    assertEquals("Playstation", platform);
  }
}
