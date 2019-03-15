import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sourceCSV {
    private ArrayList<Student> initialList;

    List<List<String>> records = new ArrayList<>();
    try(
    Scanner scanner = new Scanner(new File("book.csv"));)

    {
        while (scanner.hasNextLine()) {
            records.add(getRecordFromLine(scanner.nextLine()));
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
