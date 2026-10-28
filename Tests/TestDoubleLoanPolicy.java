import java.time.LocalDate;

public class TestDoubleLoanPolicy implements LoanPolicy {
  @Override
  public boolean canLoan(Member member, Resource resource) {
    return true;
  }

  @Override
  public LocalDate calculateDueDate(LocalDate startDate) {
    return null;
  }
}