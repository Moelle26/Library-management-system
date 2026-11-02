public class CsvMapper {
    private String delimiter = ",";

    public Member memberFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);

    }
}
