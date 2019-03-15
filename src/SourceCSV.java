import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SourceCSV {
    private ArrayList<String> sourceArr = new ArrayList<>();
    private static String newline = System.getProperty("line.separator");

    public SourceCSV() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src\\database\\sheet.csv"));
        scanner.useDelimiter(",|\r\n");

        while (scanner.hasNext()) {
            sourceArr.add(scanner.next());
        }
        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        SourceCSV source = new SourceCSV();
        System.out.println(source.sourceArr.get(10));
    }
}
