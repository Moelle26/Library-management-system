import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    void testGetMemberSuccess() {
        //Arrange
        Member member1 = new Member("Galf", 111);

        //Act
        int membernumber = member1.memberNumber();

        //Assert
        assertEquals(111, membernumber);
    }

    @Test
    void testGetMemberLoop() {
        //Arrange
        Member member1 = new Member("Galf", 111);
        Member member2 = new Member("Søren", 222);

        int membernumber1 = member1.memberNumber();
        int membernumber2 = member2.memberNumber();

        LoanPolicy testDoubleLoanPolicy = new TestDoubleLoanPolicy();
        Library library = new Library(testDoubleLoanPolicy);

        library.addMember(member1);
        library.addMember(member2);
        //Act
        Member result = library.getMember(membernumber2);
        //Assert
        assertEquals(member2, result);
    }

    @Test
    void testLoanResourceSuccess() {
        //Arrange
        Member member1 = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);

        int ID = book1.ID();
        int memberNumber = member1.memberNumber();

        LoanPolicy testDoubleLoanPolicy = new TestDoubleLoanPolicy();
        Library library = new Library(testDoubleLoanPolicy);

        library.addResource(book1);
        library.addMember(member1);

        //Act
        LoanResult result = library.loanResource(ID, memberNumber);

        //Assert
        assertEquals(LoanResult.SUCCES, result);
    }

    @Test
    void testLoanResourceMemberNotFound() {
        //Arrange
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);

        int ID = book1.ID();
        int memberNumber = 112;

        LoanPolicy testDoubleLoanPolicy = new TestDoubleLoanPolicy();
        Library library = new Library(testDoubleLoanPolicy);
        library.addResource(book1);

        //Act
        LoanResult result = library.loanResource(ID, memberNumber);

        //Assert
        assertEquals(LoanResult.MEMBER_NOT_FOUND, result);
    }

    @Test
    void testLoanResourceResourceNotFound() {
        //Arrange
        Member member1 = new Member("Galf", 111);

        int ID = 200;
        int memberNumber = member1.memberNumber();

        LoanPolicy testDoubleLoanPolicy = new TestDoubleLoanPolicy();
        Library library = new Library(testDoubleLoanPolicy);
        library.addMember(member1);

        //Act
        LoanResult result = library.loanResource(ID, memberNumber);

        //Assert
        assertEquals(LoanResult.NOT_FOUND, result);
    }

    @Test
    void testLoanResourceAlreadyLoanedSuccess() {
        Member member1 = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);

        int ID = book1.ID();
        int memberNumber = member1.memberNumber();

        LoanPolicy testDoubleLoanPolicy = new TestDoubleLoanPolicy();
        Library library = new Library(testDoubleLoanPolicy);

        library.addResource(book1);
        library.addMember(member1);
        library.loanResource(ID, memberNumber);

        //Act
        LoanResult result = library.loanResource(ID, memberNumber);

        //Assert
        assertEquals(LoanResult.ALREADY_LOANED, result);
    }

    @Test
    void testLoanResourceLoanLoop() {
        Member member1 = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
        Book book2 = new Book("Meter i sekundet", "Stine Pilgaard", 9788763851664L, 2, 65);

        int ID1 = book1.ID();
        int ID2 = book2.ID();
        int memberNumber = member1.memberNumber();

        LoanPolicy testDoubleLoanPolicy = new TestDoubleLoanPolicy();
        Library library = new Library(testDoubleLoanPolicy);

        library.addResource(book1);
        library.addResource(book2);
        library.addMember(member1);

        library.loanResource(ID1, memberNumber);

        //Act
        LoanResult result = library.loanResource(ID2, memberNumber);

        //Assert
        assertEquals(LoanResult.SUCCES, result);
    }

    @Test
    void testReturnResourceSuccess() {
        //Arrange
        Member member1 = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);

        int ID = book1.ID();
        int memberNumber = member1.memberNumber();

        LoanPolicy testDoubleLoanPolicy = new TestDoubleLoanPolicy();
        Library library = new Library(testDoubleLoanPolicy);

        library.addResource(book1);
        library.addMember(member1);

        library.loanResource(ID, memberNumber);

        //Act
        boolean result = library.returnResource(ID);

        //Assert
        assertTrue(result);
    }

    @Test
    void testReturnResourceFail() {
        //Arrange
        Member member1 = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);

        int ID = 2;
        int memberNumber = member1.memberNumber();

        LoanPolicy testDoubleLoanPolicy = new TestDoubleLoanPolicy();
        Library library = new Library(testDoubleLoanPolicy);

        library.addResource(book1);
        library.addMember(member1);

        library.loanResource(ID, memberNumber);

        //Act
        boolean result = library.returnResource(ID);

        //Assert
        assertFalse(result);
    }

    @Test
    void testReturnResourceLoanLoop() {
        //Arrange
        Member member1 = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
        Book book2 = new Book("Meter i sekundet", "Stine Pilgaard", 9788763851664L, 2, 65);

        int ID1 = book1.ID();
        int ID2 = book2.ID();
        int memberNumber = member1.memberNumber();

        LoanPolicy testDoubleLoanPolicy = new TestDoubleLoanPolicy();
        Library library = new Library(testDoubleLoanPolicy);

        library.addResource(book1);
        library.addResource(book2);

        library.addMember(member1);

        library.loanResource(ID1, memberNumber);
        library.loanResource(ID2, memberNumber);

        //Act
        boolean result = library.returnResource(ID2);

        //Assert
        assertTrue(result);
    }

    @Test
    void testFindLoansByMemberNumberSucces() {
        //Arrange
        Member member1 = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
        Book book2 = new Book("Meter i sekundet", "Stine Pilgaard", 9788763851664L, 2, 65);

        int memberNumber = member1.memberNumber();

        LoanPolicy testDoubleLoanPolicy = new TestDoubleLoanPolicy();
        Library library = new Library(testDoubleLoanPolicy);

        library.addMember(member1);
        library.addResource(book1);
        library.addResource(book2);

        library.loanResource(book1.ID(), member1.memberNumber());
        library.loanResource(book2.ID(), member1.memberNumber());

        //Act
        ArrayList<Loan> result = library.findLoansByMemberNumber(memberNumber);

        //Assert - 2 lån
        assertEquals(2, result.size());
    }

    @Test
    void testFindLoansByMemberNumberEmpty() {
        Member member1 = new Member("Galf", 111);
        Member member2 = new Member("Søren", 222);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);

        int memberNumber1 = member1.memberNumber();
        int memberNumber2 = member2.memberNumber();
        int ID = book1.ID();

        LoanPolicy testDoubleLoanPolicy = new TestDoubleLoanPolicy();
        Library library = new Library(testDoubleLoanPolicy);

        library.addResource(book1);
        library.addMember(member1);
        library.addMember(member2);

        library.loanResource(ID, memberNumber2);

        //Act
        ArrayList<Loan> result = library.findLoansByMemberNumber(memberNumber1);

        //Assert
        assertTrue(result.isEmpty());


    }

    @Test
    public void testLibraryCallsCanLoan() {
        //Arrange
        TestDoubleLoanPolicy testDouble = new TestDoubleLoanPolicy();
        Library library = new Library(testDouble);
        Member member = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
        library.addMember(member);
        library.addResource(book1);

        //Act
        LoanResult result = library.loanResource(1, 111);
        boolean canLoanCalled = testDouble.canLoanCalled;

        //Assert
        assertEquals(LoanResult.SUCCES, result);
        assertTrue(canLoanCalled);
    }

    @Test
    public void testLibraryCallsCalculateDueDate() {
        //Arrange
        TestDoubleLoanPolicy testDouble = new TestDoubleLoanPolicy();
        Library library = new Library(testDouble);
        Member member = new Member("Galf", 111);
        Book book1 = new Book("Kastanjemanden", " Søren Sveistrup", 9781492072508L, 1, 50);
        library.addMember(member);
        library.addResource(book1);

        library.loanResource(1, 111);
        boolean calculateDueDateCalled = testDouble.calculateDueDateCalled;

        assertTrue(calculateDueDateCalled);
    }
    @Test
    void testLoanNotPermitted() {
        MaxNumberVideoMoviePolicy policy = new MaxNumberVideoMoviePolicy();
        Library library = new Library(policy);
        Member member1 = new Member("Galf", 111);
        Movie movie1 = new Movie("The Uprising", "Scanbox A/S", 2736482748L, 4, "Paul Greengrass", "127 min");
        Videogame videogame1 = new Videogame("GTA 6", "Rockstar", 6738748208L, 5, "Playstation");
        Videogame videogame2 = new Videogame("CS 2", "Valve", 64836482L , 7, "Computerspil");
        Movie movie2 = new Movie("Django", "Columbia Pictures", 639927492L, 8, "Stacey Sher", "165 min");

        library.addMember(member1);
        library.addResource(movie1);
        library.addResource(movie2);
        library.addResource(videogame1);
        library.addResource(videogame2);

        library.loanResource(4,111);
        library.loanResource(5, 111);
        library.loanResource(7, 111);

        LoanResult result = library.loanResource(8,111);

        assertEquals(LoanResult.NOT_PERMITTED, result);
    }
}

