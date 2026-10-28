

import java.time.LocalDate;
import java.util.List;


public class TestDoubleLoanPolicy implements LoanPolicy {
  public boolean canLoanCalled = false;
  public boolean calculateDueDateCalled = false;

  @Override
  public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
    canLoanCalled = true;
    return true;
  }

  @Override
  public LocalDate calculateDueDate(Resource resource, LocalDate localDate) {
    calculateDueDateCalled = true;
    return null;
  }

}