import java.time.LocalDate;

public class CsvMapper {
  private String delimiter = ",";

  public Member memberFromCsv(String line) {
    String[] tokens = line.split(delimiter, -1);
    int number = Integer.parseInt(tokens[1]);
    return new Member(tokens[0], number);
  }

  public Book bookFromCsv(String line) {
    String[] tokens = line.split(delimiter, -1);
    long identifier = Long.parseLong(tokens[2]);
    int id = Integer.parseInt(tokens[3]);
    int page = Integer.parseInt(tokens[4]);
    return new Book(tokens[0], tokens[1], identifier, id, page);
  }

  public Movie movieFromCsv(String line) {
    String[] tokens = line.split(delimiter, -1);
    long identifier = Long.parseLong(tokens[2]);
    int id = Integer.parseInt(tokens[3]);
    return new Movie(tokens[0], tokens[1], identifier, id, tokens[4], tokens[5]);
  }

  public Audiobook audiobookFromCsv(String line) {
    String[] tokens = line.split(delimiter, -1);
    Long identifier = Long.parseLong(tokens[2]);
    int id = Integer.parseInt(tokens[3]);
    return new Audiobook(tokens[0], tokens[1], identifier, id, tokens[4]);
  }

  public Videogame videogameFromCsv(String line) {
    String[] tokens = line.split(delimiter, -1);
    Long identifier = Long.parseLong(tokens[2]);
    int id = Integer.parseInt(tokens[3]);
    return new Videogame(tokens[0], tokens[1], identifier, id, tokens[4]);
  }

  public Loan loanFromCsv(String line, Library library) {
    String[] tokens = line.split(delimiter, -1);
    int memberID = Integer.parseInt(tokens[0]);
    Long resourceID = Long.parseLong(tokens[1]);
    LocalDate lånedato = LocalDate.parse(tokens[2]);

    Member member = library.getMember(memberID);
    Resource resource = library.getResourcesIdentifyer(resourceID);
    return new Loan(resource, member, lånedato);
  }

  public String LoanToCsv(Loan loan) {
    return loan.getMember() + delimiter + loan.getResource() + delimiter +
            loan.getBorrowedDate() + delimiter + loan.getDueDate() + delimiter;
  }
}

