import java.time.LocalDate;
import java.util.List;

public class MaxNumberVideoMoviePolicy implements LoanPolicy {
    @Override
    public boolean canLoan(Member member, Resource resource, List<Loan> loans) {
        if (!(resource instanceof Videogame || resource instanceof Movie))
            return true;
        int count = 0;
        for (Loan loan : loans) {
            if (loan.getMember().equals(member)) {
                Resource borrowedResource = loan.getResource();
                if (borrowedResource instanceof Movie || borrowedResource instanceof Videogame) {
                    count++;
                }
                if (count >= 3) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public LocalDate calculateDueDate(Resource resource, LocalDate localDate) {
        return localDate.plusDays(30);
    }
}
