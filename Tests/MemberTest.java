import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {

    @Test
    void testGetName() {

        //Arrange
        Member member1 = new Member("Galf", 111);

        // Act
        String name = member1.name();

        // Assert
        assertEquals("Galf", name);
    }

    @Test
    void testGetMemberNumber() {

        // Arrange
        Member member1 = new Member("Galf", 111);

        // Act
        int memberNumber = member1.memberNumber();

        // Assert
        assertEquals(111, memberNumber);
    }

    @Test
    void testSaveMembers() throws IOException {

        List<Member> members = List.of(
                new Member("Galf", 111),
                new Member("Søren", 222),
                new Member("Peter", 333));

        LibrarySaver librarySaver = new LibrarySaver();

        librarySaver.saveMembers(members, "test-members.csv");
        String n = System.lineSeparator();

        String expected = "111,Galf" + n
                        + "222,Søren" + n
                        + "333,Peter" + n;

        var actual = Files.readString(Path.of("test-members.csv"));

        assertEquals(expected, actual);
    }
}
