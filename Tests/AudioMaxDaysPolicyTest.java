import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AudioMaxDaysPolicyTest {
    @Test
    void testcanLoan() {

        AudioMaxDaysPolicy Policy = new AudioMaxDaysPolicy();

        Member member1 = new Member("Galf", 111);
        Audiobook audiobook1 = new Audiobook("Mørkeland", "Camilla og Kristine", 43776895894L, 6, "12,2 timer");
        List<Loan> loans = new ArrayList<>();

        boolean result = Policy.canLoan(member1, audiobook1, loans);

        assertTrue(result);
    }

    @Test
    void testcalculateDueDateAudiobook() {

        AudioMaxDaysPolicy Policy = new AudioMaxDaysPolicy();

        Audiobook audiobook1 = new Audiobook("Mørkeland", "Camilla og Kristine", 43776895894L, 6, "12,2 timer");
        LocalDate startDate = LocalDate.of(2026, 1, 1);

        LocalDate dueDate = Policy.calculateDueDate(audiobook1, startDate);

        assertEquals(LocalDate.of(2026, 1, 15), dueDate);
    }
    @Test
    void testcalculateDueDateNotAudiobook() {

        AudioMaxDaysPolicy Policy = new AudioMaxDaysPolicy();

        Videogame videogame = new Videogame("GTA 6", "Rockstar", 6738748208L, 5, "Playstation");
        LocalDate startDate = LocalDate.of(2026, 1, 1);

        LocalDate dueDate = Policy.calculateDueDate(videogame, startDate);

        assertEquals(LocalDate.of(2026, 1, 31), dueDate);
    }

}


