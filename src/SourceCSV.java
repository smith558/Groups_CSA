import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SourceCSV {
    private ArrayList<Student> sourceArr = new ArrayList<>();
    // deprecated from the last version, instead -> regular expression delimiter
    private static String newline = System.getProperty("line.separator");

    public SourceCSV() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src\\database\\sheet.csv"));
        scanner.useDelimiter(",|\r\n");

        int i = 0;
        while (scanner.hasNext()) {
            switch (i++) {
                case 0:
                    sourceArr.add(new Student(scanner.next()));
                    break;
                case 1:
                    sourceArr.get(sourceArr.size() - 1).setHall(scanner.next());
                    break;
                case 2:
                    sourceArr.get(sourceArr.size() - 1).setFullName(scanner.next());
                    break;
                case 3:
                    sourceArr.get(sourceArr.size() - 1).setYear(Integer.parseInt(scanner.next().substring(5)));
                    i = 0;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        SourceCSV source = new SourceCSV();
        System.out.println(source.sourceArr.get(0));
    }
}
