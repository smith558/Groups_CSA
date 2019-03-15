import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sourceCSV {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("sheet.csv"));
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            System.out.print(scanner.next() + "|");
        }
        scanner.close();
    }

}
