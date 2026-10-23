import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {


    @Test
    void testGetResource() {
        //Arrange
        Member member1 = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
        Loan loan = new Loan(book1, member1, LocalDate.now());
        //Act
        Resource resource = loan.getResource();

        //assert
        assertEquals(book1, resource);
    }

    @Test
    void testGetMember() {
        //Arrange
        Member member1 = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
        Loan loan = new Loan(book1, member1, LocalDate.now());
        //Act
        Member member = loan.getMember();

        //assert
        assertEquals(member1, member);
    }

    @Test
    void testGetDueDate() {
        //Arrange
        Member member1 = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
        Loan loan = new Loan(book1, member1, LocalDate.now());
        //Act
        LocalDate localDate = loan.getDueDate();

        //assert
        assertEquals(LocalDate.now().plusDays(14), localDate);
    }

    @Test
    void testIsOverDue() {
        //Arrange
        Member member1 = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
        Loan loan = new Loan(book1, member1, LocalDate.now());
        //Act
        boolean isOverdue = loan.isOverdue();

        //assert
        assertFalse(isOverdue);
    }
}
