import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StandardLoanPolicyTest {

  @Test
  void testcanLoan() {

    StandardLoanPolicy Policy = new StandardLoanPolicy();

    Member member1 = new Member("Galf", 111);
    Videogame videogame = new Videogame("GTA 6", "Rockstar", 6738748208L, 5, "Playstation");
    List<Loan> loans = new ArrayList<>();

    boolean result = Policy.canLoan(member1, videogame, loans);

    assertTrue(result);
  }

  @Test
  void testcalculateDueDate() {

    StandardLoanPolicy Policy = new StandardLoanPolicy();


    Videogame videogame = new Videogame("GTA 6", "Rockstar", 6738748208L, 5, "Playstation");
    LocalDate startDate = LocalDate.of(2026, 1, 1);

    LocalDate dueDate = Policy.calculateDueDate(videogame, startDate);

    assertEquals(LocalDate.of(2026, 1, 31), dueDate);
  }
}
