import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxNumberVideoMoviePolicyTest {
    @Test
    void testcanLoanAudiobook() {

        MaxNumberVideoMoviePolicy Policy = new MaxNumberVideoMoviePolicy();

        Member member1 = new Member("Galf", 111);
        Audiobook audiobook1 = new Audiobook("Mørkeland", "Camilla og Kristine", 43776895894L, 6, "12,2 timer");
        List<Loan> loans = new ArrayList<>();

        boolean result = Policy.canLoan(member1, audiobook1, loans);

        assertTrue(result);
    }
    @Test
    void testcanLoanMovie() {

        MaxNumberVideoMoviePolicy Policy = new MaxNumberVideoMoviePolicy();

        Member member1 = new Member("Galf", 111);
        Movie movie1 = new Movie("The Uprising", "Scanbox A/S", 2736482748L, 4, "Paul Greengrass", "127 min");
        List<Loan> loans = new ArrayList<>();

        boolean result = Policy.canLoan(member1, movie1, loans);

        assertTrue(result);
    }
    @Test
    void testMax3MovieOrVideogame() {
        MaxNumberVideoMoviePolicy Policy = new MaxNumberVideoMoviePolicy();
        Member member1 = new Member("Galf", 111);
        Movie movie1 = new Movie("The Uprising", "Scanbox A/S", 2736482748L, 4, "Paul Greengrass", "127 min");
        Videogame videogame1 = new Videogame("GTA 6", "Rockstar", 6738748208L, 5, "Playstation");
        Videogame videogame2 = new Videogame("CS 2", "Valve", 64836482L , 7, "Computerspil");
        Movie movie2 = new Movie("Django", "Columbia Pictures", 639927492L, 8, "Stacey Sher", "165 min");

        List<Loan> loans = new ArrayList<>();
        Library library = new Library(Policy);
        library.addMember(member1);
        library.addResource(movie1);
        library.addResource(videogame1);
        library.addResource(videogame2);
        library.addResource(movie2);
        library.loanResource(4, 111);
        library.loanResource(5, 111);
        library.loanResource(7, 111);

        library.loanResource(8, 111);

        boolean result = Policy.canLoan(member1, movie2, loans);

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


