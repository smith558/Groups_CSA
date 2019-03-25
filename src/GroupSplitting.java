import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GroupSplitting {
    public static int groupByGender(ArrayList<Student> srcArr, int groupSize) {
        //  have a look at this, proper division
        int numOfGroups = srcArr.size() / groupSize;

        //  iterating through source
        int gB = 1, gG = 1;
        for (Student student : srcArr) {
            student.setGroupIdentifier((byte) 0);
            if (student.getGender() == 'f') {
                if (gG > numOfGroups) gG = 1;
                student.setGroupIdentifier((byte) gG);
                gG++;
            } else {
                if (gB > numOfGroups) gB = 1;
                student.setGroupIdentifier((byte) gB);
                gB++;
            }
        }
        return numOfGroups;
    }

    void groupByHall(ArrayList<Student> srcArray, int nrInGroup) {

    }

    public static void main(String[] args) throws FileNotFoundException {
        SourceCSV source = new SourceCSV("src\\database\\sheet.csv");
        System.out.println("females " + source.numOfFemales);
        System.out.println("males " + source.numOfMales);
        System.out.println("num of groups" + GroupSplitting.groupByGender(source.getSourceArr(), 8));
        System.out.println(source.getSourceArr());
        for (Student student : source.getSourceArr()) {
            System.out.println(student);
            System.out.println();
        }
    }
}