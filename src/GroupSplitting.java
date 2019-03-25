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
        for(int i = 0;i<groupsNr;i++){
            int iteration = 1;
            int pplInGroup = 0;
            while(pplInGroup<nrInGroup){
            switch(iteration){
                case 1:
                    int index = 0;
                    while(!srcArray.get(index).getHall().equals("Founders")||srcArray.get(index).getGroupIdentifier()!=-1){
                        index++;
                        System.out.println("founders not found yet");
                        if(index==srcArray.size()){
                            System.out.println("founders not found anywhere");

                            iteration=2;
                            break;}


                    }
                    if(srcArray.get(index).getHall().equals("Founders")&&srcArray.get(index).getGroupIdentifier()==-1){
                        srcArray.get(index).setGroupIdentifier((byte)i);
                        System.out.println("trying to change group of a founder");
                        pplInGroup++;
                        iteration++;
                    }
                case 2:
                    index = 0;
                    while(!srcArray.get(index).getHall().equals("Gentlemen")||srcArray.get(index).getGroupIdentifier()!=-1){
                        index++;
                        System.out.println("gentlemen not found yet");
                        if(index==srcArray.size()){
                            System.out.println("gentlemen not found anywhere");

                            iteration=3;
                            break;}


                    }
                    if(srcArray.get(index).getHall().equals("Gentlemen")&&srcArray.get(index).getGroupIdentifier()==-1){
                        srcArray.get(index).setGroupIdentifier((byte)i);
                        System.out.println("trying to change group of a gentleman");
                        pplInGroup++;
                        iteration++;
                    }
                case 3:
                    index = 0;
                    while(!srcArray.get(index).getHall().equals("Sprouts")||srcArray.get(index).getGroupIdentifier()!=-1){
                        index++;
                        System.out.println("sprouts not found yet");
                        if(index==srcArray.size()){
                            System.out.println("sprouts not found anywhere");

                            iteration=4;
                            break;}


                    }
                    if(srcArray.get(index).getHall().equals("Sprouts")&&srcArray.get(index).getGroupIdentifier()==-1){
                        srcArray.get(index).setGroupIdentifier((byte)i);
                        System.out.println("trying to change group of a sprout");
                        pplInGroup++;
                        iteration++;
                    }
                case 4:
                    index = 0;
                    while(!srcArray.get(index).getHall().equals("Fortes")||srcArray.get(index).getGroupIdentifier()!=-1){
                        index++;
                        System.out.println("fortes not found yet");
                        if(index==srcArray.size()){
                            System.out.println("fortes not found anywhere");

                            iteration=1;
                            break;}


                    }
                    if(srcArray.get(index).getHall().equals("Fortes")&&srcArray.get(index).getGroupIdentifier()==-1){
                        srcArray.get(index).setGroupIdentifier((byte)i);
                        System.out.println("trying to change group of a fortes");
                        pplInGroup++;
                        iteration++;
                    }
            }

            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        SourceCSV source = new SourceCSV("src\\database\\sheet.csv");
        groupByHall(source.getSourceArr(),6);
        System.out.println(source.getSourceArr());
    }
}