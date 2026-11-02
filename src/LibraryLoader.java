import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibraryLoader {


    public List<Member> loadMembers(String filename) throws IOException {
        List<Member> members = new ArrayList<>();
        Path path = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while ((line = reader.readLine()) !=null) {
                Member member =
            }
        }
    }
}
