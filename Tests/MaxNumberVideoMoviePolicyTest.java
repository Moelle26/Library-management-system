import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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


        Library library = new Library(Policy);
        library.addMember(member1);
        library.addResource(movie1);
        library.addResource(videogame1);
        library.addResource(videogame2);
        library.addResource(movie2);
        library.loanResource(4, 111);
        library.loanResource(5, 111);
        library.loanResource(7, 111);
        List<Loan> loans1 = library.findLoansByMemberNumber(111);



        boolean result = Policy.canLoan(member1, movie2, loans1);

        assertFalse(result);


    }
    @Test
    void testLoanBelongsToAnotherMember() {
        Member member1 = new Member("Galf", 111);
        Member member2 = new Member("Søren", 222);
        Movie movie1 = new Movie("The Uprising", "Scanbox A/S", 2736482748L, 4, "Paul Greengrass", "127 min");
        MaxNumberVideoMoviePolicy policy = new MaxNumberVideoMoviePolicy();
        Library library = new Library(policy);

        library.addMember(member1);
        library.addMember(member2);
        library.addResource(movie1);
        library.loanResource(4,111);
        List<Loan> loans = new ArrayList<>();
        Loan loan = new Loan(movie1,member1, LocalDate.now());
        loans.add(loan);

        boolean result = policy.canLoan(member2, movie1, loans);

        assertTrue(result);
    }

    @Test
    void testInstanceOfVideoOrMovie() {
        Member member1 = new Member("Galf", 111);
        Audiobook audiobook1 = new Audiobook("Mørkeland", "Camilla og Kristine", 43776895894L, 6, "12,2 timer");
        Movie movie1 = new Movie("The Uprising", "Scanbox A/S", 2736482748L, 4, "Paul Greengrass", "127 min");

        MaxNumberVideoMoviePolicy policy = new MaxNumberVideoMoviePolicy();
        Library library = new Library(policy);
        library.addMember(member1);
        library.addResource(audiobook1);
        library.addResource(movie1);
        library.loanResource(6, 111);
        library.loanResource(4,111);
        List<Loan> loans = new ArrayList<>();

        boolean result = policy.canLoan(member1, movie1, loans);

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


