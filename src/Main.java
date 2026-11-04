void main(String[] args) {
    Path path = Path.of(args[0]);
    LoanPolicy standardLoanPolicy = new StandardLoanPolicy();
    Library library = new Library(standardLoanPolicy);

    LibraryLoader loader = new LibraryLoader();
    LibrarySaver saver = new LibrarySaver();

    //Members

    List<Member> members = null;
    try {
        members = loader.loadMembers(path.resolve("members.csv"));
        for (Member member : members) {
            library.addMember(member);
        } members.sort(null);
    } catch (IOException e) {
        IO.println(" could not find members.csv");
    }


    //
    List<Book> books = null;
    try {
        books = loader.loadBooks(path.resolve("books.csv"));
        for (Book book : books) {
            library.addResource(book);
        } books.sort(new ResourceCreatorComparator());
    } catch (IOException e) {
        IO.println("Could not find books.csv");
    }

    List<Audiobook> audiobooks = null;
    try {
        audiobooks = loader.loadAudiobooks(path.resolve("Audiobooks.csv"));
        for (Audiobook audiobook : audiobooks) {
            library.addResource(audiobook);
        } audiobooks.sort(new ResourceTitleComparator());
    } catch (IOException e) {
        IO.println("could not find Audiobooks.csv ");
        ;
    }

    List<Videogame> videogames = null;
    try {
        videogames = loader.loadvideogame(path.resolve("Videogames.csv"));
        for (Videogame videogame : videogames) {
            library.addResource(videogame);
        }
    } catch (IOException e) {
        IO.println("Could not find videogames.csv");
    }

    List<Movie> movies = null;
    try {
        movies = loader.loadMovies(path.resolve("Movies.csv"));
        for (Movie movie : movies) {
            library.addResource(movie);
        } movies.sort(null);
    } catch (IOException e) {
        IO.println("Could not find Movies.csv");
    }

    List<Loan> loans = null;
    try {
        loans = loader.loadLoans(path.resolve("Loans.csv"), library);
        for (Loan loan : loans) {
            library.loanResource(loan.getResource().getID(), loan.getMember().memberNumber());
        } loans.sort(new LoanBorrowedDateComparator());
    } catch (IOException e) {
        IO.println("Could not find Loans.csv");
    }


    ConsoleUI consoleUI = new ConsoleUI(library);

    consoleUI.run();

    try {
        saver.saveLoans(library.getLoans(), path.resolve("Loans.csv").toString());
    } catch (IOException e) {
        IO.println("Could not be saved");
    }
}