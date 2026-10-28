import java.time.LocalDate;
import java.util.List;

public class StandardLoanPolicy implements LoanPolicy {
    @Override
    public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
        return true;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource, LocalDate localDate) {
        return localDate.plusDays(30);
    }
}
