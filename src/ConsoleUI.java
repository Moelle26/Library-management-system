import java.util.ArrayList;

public class ConsoleUI {
  private Library library;

  public ConsoleUI(Library library) {
    this.library = library;
  }

  public void run() {
    boolean running = true;
    while (running) {
      showMenu();
      int choice = Integer.parseInt(IO.readln("Indtast valg "));
      switch (choice) {
        case 1 -> borrowBook();
        case 2 -> returnBook();
        case 3 -> showLoans();
        case 0 -> running = false;
        default -> IO.println("Ugyldigt valg. Indtast igen ");
      }
    }
  }

  private void showMenu() {
    IO.println();
    IO.println("1. Lån ");
    IO.println("2. Aflever ");
    IO.println("3. Vis alle lån ");
    IO.println("0. Afslut ");
    IO.println();
  }


  private void borrowBook() {
    int ID = Integer.parseInt(IO.readln("Indtast bog ID "));
    int memberNumber = Integer.parseInt(IO.readln("Indtast medlemsnummer "));

    boolean succes = library.loanResource(ID,memberNumber);

    if (succes) {
      IO.println("Bog udlånt");
    } else {
      IO.println("Lånt misslykedes");
    }
  }

  private void returnBook() {
    int bookId = Integer.parseInt(IO.readln("Indtast bog ID "));

    boolean succes = library.returnBook(bookId);

    if (succes) {
      IO.println("Bog afleveret");
    } else {
      IO.println("aflevering misslykedes");
    }
  }

  private void showLoans() {
    int memberNumber = Integer.parseInt(IO.readln("Indtast medlemsnummer "));

    ArrayList<Loan> Loans = library.findLoansByMemberNumber(memberNumber);

    if (Loans == null) {
      IO.println("Du har ingen lån");
    } else {
      IO.println("Dine lån");
    }
    for (Loan loan : Loans) {
      IO.println(loan);
    }
  }
}