import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibraryLoader {
    private CsvMapper csvMapper = new CsvMapper();


    public List<Member> loadMembers(Path path) throws IOException {
        List<Member> members = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Member member = csvMapper.memberFromCsv(line);
                members.add(member);
            }
        }
        return members;
    }

    public List<Book> loadBooks(Path path) throws IOException {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = csvMapper.bookFromCsv(line);
                books.add(book);
            }
        }
        return books;
    }

    public List<Movie> loadMovies(Path path) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Movie movie = csvMapper.movieFromCsv(line);
                movies.add(movie);
            }
        }
        return movies;
    }

    public List<Audiobook> loadAudiobooks(Path path) throws IOException {
        List<Audiobook> audiobooks = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Audiobook audiobook = csvMapper.audiobookFromCsv(line);
                audiobooks.add(audiobook);
            }
        }
        return audiobooks;
    }
    public List<Videogame> loadvideogame(Path path) throws IOException {
        List<Videogame> videogames = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Videogame videogame = csvMapper.videogameFromCsv(line);
                videogames.add(videogame);
            }
        }
        return videogames;
    }

    public List<Loan> loadLoans(Path path, Library library) throws IOException {
        List<Loan> loans = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Loan loan = csvMapper.loanFromCsv(line,library);
                loans.add(loan);
            }
        }
        return loans;
    }
}
