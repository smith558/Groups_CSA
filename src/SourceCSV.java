import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SourceCSV {
    private ArrayList<String> sourceArr = new ArrayList<>();

    SourceCSV() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src\\database\\sheet.csv"));
        scanner.useDelimiter(",");

        while (scanner.hasNext()) {
//            System.out.print(scanner.next() + "|");
            sourceArr.add(scanner.next());
        }
        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        SourceCSV source = new SourceCSV();
        System.out.println(source.sourceArr);
    }
}
