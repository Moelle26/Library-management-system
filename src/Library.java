import java.time.LocalDate;
import java.util.ArrayList;


public class Library {
  private ArrayList<Member> members = new ArrayList<>();
  private ArrayList<Loan> loans = new ArrayList<>();
  private ArrayList<Resource> resources = new ArrayList<>();


  public void addResource(Resource resource){
  resources.add(resource);
  }

  public void addMember(Member member) {
    members.add(member);
  }

// Finder bog
  public Resource getResources(int ID) {
    for (Resource resource : resources) {
      if (ID == resource.ID) {
        return resource;
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
  public LoanResult loanResource(int ID, int memberNumber) {

    Member member = getMember(memberNumber);
    if (member == null) {
      return LoanResult.MEMBER_NOT_FOUND;
    }
    Resource resource = getResources(ID);
    if (resource == null) {
      return LoanResult.NOT_FOUND;
    }
    for (Loan loan : loans) {
      if (loan.getResource().ID == getResources(ID).ID) {
        return LoanResult.ALREADY_LOANED;
      }
    }
    loans.add(new Loan(resource, member, LocalDate.now()));
    return LoanResult.SUCCES;
  }
// Finder lånet for den bog og fjerner det fra listen
  public boolean returnBook(int bookId) {
    for (Loan loan : loans) {
      if (loan.getResource().ID == bookId) {
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