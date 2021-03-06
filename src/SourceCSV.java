import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class provides all the functionality to convert provided expected .csv
 * into an ArrayList of Student objects which represent single students
 *
 * @author Stanley
 * @author Jirka
 */
public class SourceCSV {
    private ArrayList<Student> sourceArr = new ArrayList<>();
    public int numOfFemales = 0;
    public int numOfMales = 0;

    /**
     * The constructor mutates the 'sourceArr' array by adding Student objects
     *
     * @param path path to the .csv file in String data-type
     * @throws FileNotFoundException handling exception when file not found
     */
    public SourceCSV(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        scanner.useDelimiter(",|\r\n");

        int i = 0;
        while (scanner.hasNext()) {
            switch (i++) {
                case 0:
                    sourceArr.add(new Student(scanner.next()));
                    break;
                case 1:
                    sourceArr.get(sourceArr.size() - 1).setHall(scanner.next());
                    if (sourceArr.get(sourceArr.size() - 1).getHall().equals("Gentlemen") || sourceArr.get(sourceArr.size() - 1).getHall().equals("Founders")) {
                        sourceArr.get(sourceArr.size() - 1).setGender('m');
                        //  change 'numOfMales'
                        numOfMales++;
                    } else {
                        sourceArr.get(sourceArr.size() - 1).setGender('f');
                        // change 'numOfFemales'
                        numOfFemales++;
                    }
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

    //  is this actually needed?
    /**
     * Ensure that the client-class cannot directly access the main database ArrayList 'sourceArr'
     *
     * @return the reference variable copy
     */
    public ArrayList<Student> getSourceArr() {
        return sourceArr;
    }
}