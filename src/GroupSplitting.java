import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GroupSplitting {
    public static int groupByGender(ArrayList<Student> srcArr, int groupSize) {
        //  have a look at this, proper division?
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

    public static void groupByHall(ArrayList<Student> srcArray, int nrInGroup) {
        System.out.println("There is "+srcArray.size()+" students");
        int groupsNr;
        if(srcArray.size()%nrInGroup==0){
            groupsNr = srcArray.size()/nrInGroup;
        }
        else{
            groupsNr = srcArray.size()/nrInGroup + 1;
        }
        System.out.println("There will be " +groupsNr+ " groups.");
        int pplAdded = 0;
        for(int i = 0;i<groupsNr;i++){
            int iteration = 1;
            int pplInGroup = 0;
            while(pplInGroup<nrInGroup&&pplAdded<srcArray.size());

        }
    }

    public static void groupByYear(ArrayList<Student> srcArr, int groupSize) {
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        SourceCSV source = new SourceCSV("src\\database\\sheet.csv");
        groupByHall(source.getSourceArr(),6);
        System.out.println(source.getSourceArr());
    }
}