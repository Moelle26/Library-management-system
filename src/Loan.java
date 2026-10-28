import java.time.LocalDate;

public class Loan {
  private final Resource resource;
  private final Member member;
  private final LocalDate borrowedDate;

  public Loan(Resource resource, Member member, LocalDate borrowedDate) {
    this.resource = resource;
    this.member = member;
    this.borrowedDate = borrowedDate;
  }

  public Resource getResource() {
    return resource;
  }

  public Member getMember() {
    return member;
  }

  public LocalDate getDueDate() {
    return borrowedDate.plusDays(14);
  }

  public boolean isOverdue() {
    return LocalDate.now().isAfter(getDueDate());
  }

  public String toString() {
    String overdueText = isOverdue() ? " (OVERSKREDET!)" : "";
    return String.format("""
                    Lån: %s
                    Lånt af: %s
                    Lånt den: %s
                    Afleveres senest: %s%s""",
            resource,
            member,
            borrowedDate,
            getDueDate(),
            overdueText);
  }
}