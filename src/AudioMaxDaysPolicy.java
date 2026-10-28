import java.time.LocalDate;
import java.util.List;

public class AudioMaxDaysPolicy implements LoanPolicy {
    @Override
    public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
        return false;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource, LocalDate localDate) {
        if (resource instanceof Audiobook) {
            return localDate.plusDays(14);
        } else
            return null;
    }
}
