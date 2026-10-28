import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Member> members;
    private List<Loan> loans;
    private List<Resource> resources;
    private LoanPolicy loanPolicy;

    public Library(LoanPolicy loanPolicy) {
        this.members = new ArrayList<>();
        this.resources = new ArrayList<>();
        this.loans = new ArrayList<>();
        this.loanPolicy = loanPolicy;
    }


    public void addResource(Resource resource) {
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

        if (!loanPolicy.canLoan(member, resource, loans)) {
            return LoanResult.NOT_PERMITTED;
        }

        for (Loan loan : loans) {
            if (loan.getResource().ID == getResources(ID).ID) {
                return LoanResult.ALREADY_LOANED;
            }
        }
        LocalDate dueDate = loanPolicy.calculateDueDate(resource, LocalDate.now());
        loans.add(new Loan(resource, member, dueDate));
        return LoanResult.SUCCES;
    }

    // Finder lånet for den bog og fjerner det fra listen
    public boolean returnResource(int ID) {
        for (Loan loan : loans) {
            if (loan.getResource().ID == ID) {
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