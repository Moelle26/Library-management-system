import org.junit.jupiter.api.Test;

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
}
