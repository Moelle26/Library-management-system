import java.time.LocalDate;

public class StandardLoanPolicy implements LoanPolicy {
  @Override
  public boolean canLoan(Member member, Resource resource) {
    return true;
  }

  @Override
  public LocalDate calculateDueDate(LocalDate startDate) {
    return startDate.plusDays(30);
  }
}