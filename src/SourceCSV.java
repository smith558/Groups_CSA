import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SourceCSV {
    private ArrayList<String> sourceArr = new ArrayList<>();
    private static String newline = System.getProperty("line.separator");

    public SourceCSV() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src\\database\\sheet.csv"));
        scanner.useDelimiter(",");

        int i = 1;
        while (scanner.hasNext()) {
            if (i <= 3) {
                scanner.useDelimiter(",");
                sourceArr.add(scanner.next());
                i++;
            } else {
                scanner.useDelimiter(newline);
                sourceArr.add(scanner.next());
                i = 0;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        SourceCSV source = new SourceCSV();
        System.out.println(source.sourceArr);
    }
}
