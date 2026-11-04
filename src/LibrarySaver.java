import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibrarySaver {
    private String delimiter = ",";

    public void saveMembers(List<Member> members, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                writer.write(member.memberNumber() + delimiter + member.name());
                writer.newLine();
            }
        }
    }

    public void saveBooks(List<Book> books, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Book book : books) {
                writer.write(book.title() + delimiter
                        + book.author() + delimiter
                        + book.ISBN() + delimiter
                        + book.ID() + delimiter
                        + book.page());
                writer.newLine();
            }
        }
    }

    public void saveVideogames(List<Videogame> videogames, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Videogame videogame : videogames) {
                writer.write(videogame.title() + delimiter
                        + videogame.studio() + delimiter
                        + videogame.EAN() + delimiter
                        + videogame.ID() + delimiter
                        + videogame.platform());
                writer.newLine();
            }
        }
    }

    public void saveMovies(List<Movie> movies, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Movie movie : movies) {
                writer.write(movie.title() + delimiter
                        + movie.studio() + delimiter
                        + movie.EAN() + delimiter
                        + movie.ID() + delimiter
                        + movie.director() + delimiter
                        + movie.duration());
                writer.newLine();
            }
        }
    }

    public void saveAudiobooks(List<Audiobook> audiobooks, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Audiobook audiobook : audiobooks) {
                writer.write(audiobook.title() + delimiter
                        + audiobook.author() + delimiter
                        + audiobook.ISBN() + delimiter
                        + audiobook.ID() + delimiter
                        + audiobook.duration());
                writer.newLine();
            }
        }
    }

    public void saveLoans(List<Loan> loans, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Loan loan : loans) {
                writer.write(loan.getMember().memberNumber() + delimiter
                        + loan.getResource().getIdentifier() + delimiter
                        + loan.getBorrowedDate() + delimiter
                        + loan.getDueDate());
                writer.newLine();
            }
        }
    }
}

