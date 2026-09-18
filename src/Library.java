import java.time.LocalDate;
import java.util.ArrayList;


public class Library {
  private ArrayList<Book> books = new ArrayList<>();
  private ArrayList<Member> members = new ArrayList<>();
  private ArrayList<Loan> loans = new ArrayList<>();

  public void addBook(Book book) {
    books.add(book);
  }

  public void addMember(Member member) {
    members.add(member);
  }

  public void printMembers() {
    for (Member member : members) {
      IO.println(member);
    }
  }
// Finder bog
  public Book getBooks(int id) {
    for (Book book : books) {
      if (id == book.id()) {
        return book;
      }
    }
    return null;
  }
// Finder member
  public Member getMember(int id) {
    for (Member member : members) {
      if (id == member.memberNumber()) {
        return member;
      }
    }
    return null;
  }
// Tjekker om member og bog findes, og om bogen allerede er udlånt, ellers oprettes et nyt Loan
  public boolean loanBook(int bookId, int memberNumber) {
    Member member = getMember(memberNumber);
    if (member == null) {
      return false;
    }
    Book book = getBooks(bookId);
    if (book == null) {
      return false;
    }
    for (Loan loan : loans) {
      if (loan.getBook().id() == bookId) {
        return false;
      }
    }
    loans.add(new Loan(book, member, LocalDate.now()));
    return true;
  }
// Finder lånet for den bog og fjerner det fra listen
  public boolean returnBook(int bookId) {
    for (Loan loan : loans) {
      if (loan.getBook().id() == bookId) {
        loans.remove(loan);
        return true;
      }
    }
    return false;
  }
//
  public ArrayList<Loan> findLoansByMemberNumber(int memberNumber) {
    ArrayList<Loan> result = new ArrayList<>();
    for (Loan loan : loans) {
      if (loan.getMember().memberNumber() == memberNumber) {
        result.add(loan);
      }
    }
    return result;
  }
}