import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    Movie movie;

    @BeforeEach
    void setup() {
        movie = new Movie("The Uprising", "Scanbox A/S", 2736482748L, 4, "Paul Greengrass", "127 min");
    }

    @Test
    void testMovieTitle() {
        // Act
        final String title = movie.title();

        // Assert
        assertEquals("The Uprising", title);
    }

    @Test
    void testCreator() {
        // Act
        final String creator = movie.studio();

        // Assert
        assertEquals("Scanbox A/S", creator);
    }

    @Test
    void testIdentifier() {
        // Act
        final long identifier = movie.EAN();

        // Assert
        assertEquals(2736482748L, identifier);
    }

    @Test
    void testID() {
        // Act
        final int ID = movie.ID();

        // Assert
        assertEquals(4, ID);
    }

    @Test
    void testDirector() {
        // Act
        String director = movie.director();

        // Assert
        assertEquals("Paul Greengrass", director);
    }

    @Test
    void testDuration() {
        // Act
        String duration = movie.duration();

        // Assert
        assertEquals("127 min", duration);
    }

    @Test
    void testSaveMovies() throws IOException {

        List<Movie> movies = List.of(
                new Movie("The Uprising", "Scanbox A/S", 2736482748L, 4, "Paul Greengrass", "127 min"),
                new Movie("Django", "Columbia Pictures", 639927492L, 8, "Stacey Sher", "165 min"));


        LibrarySaver librarySaver = new LibrarySaver();

        librarySaver.saveMovies(movies, "test-movies.csv");
        String n = System.lineSeparator();

        String expected = "The Uprising,Paul Greengrass,Scanbox A/S,127 min" + n
                + "Django,Stacey Sher,Columbia Pictures,165 min" + n;

        var actual = Files.readString(Path.of("test-movies.csv"));

        assertEquals(expected, actual);
    }
}
