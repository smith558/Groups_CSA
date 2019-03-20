import java.io.FileNotFoundException;
import java.util.ArrayList;

public class groupSplitting {
    public void groupByGender(ArrayList<Student> srcArr, int groupSize) {
        //  have a look at this, proper division
        int numOfGroups = srcArr.size() / groupSize;
        //  iterating through source
        for (int i = 0; i < srcArr.size(); i++) {
            Student nowStud = srcArr.get(i);
            if (nowStud.getGender() == 'f') {

            }
        }
    }

    public static void groupByHall(ArrayList<Student> srcArray, int nrInGroup) {
        int groupsNr;
        if(srcArray.size()%nrInGroup==0){
            groupsNr = srcArray.size()/nrInGroup;
        }
        else{
            groupsNr = srcArray.size()/nrInGroup + 1;
        }
        for(int i = 0;i<groupsNr;i++){
            int iteration = 1;
            for(int j=0;j<nrInGroup;j++){
            switch(iteration){
                case 1:
                    int index = 0;
                    while(!srcArray.get(j).getHall().equals("Founders")||srcArray.get(index).getGroupIdentifier()!=-1){
                        index++;
                        if(index==srcArray.size())
                            j--;
                            iteration=2;
                            break;
                    }
                    if(srcArray.get(j).getHall().equals("Founders")&&srcArray.get(index).getGroupIdentifier()==-1)
                        srcArray.get(j).setGroupIdentifier((byte)i);
                case 2:
                    index = 0;
                    while(!srcArray.get(j).getHall().equals("Gentlemen")||srcArray.get(index).getGroupIdentifier()!=-1){
                        index++;
                        if(index==srcArray.size())
                            j--;
                        iteration=3;
                        break;
                    }
                    if(srcArray.get(j).getHall().equals("Gentlemen")&&srcArray.get(index).getGroupIdentifier()==-1)
                        srcArray.get(j).setGroupIdentifier((byte)i);
                case 3:
                    index = 0;
                    while(!srcArray.get(j).getHall().equals("Sprouts")||srcArray.get(index).getGroupIdentifier()!=-1){
                        index++;
                        if(index==srcArray.size())
                            j--;
                        iteration=4;
                        break;
                    }
                    if(srcArray.get(j).getHall().equals("Sprouts")&&srcArray.get(index).getGroupIdentifier()==-1)
                        srcArray.get(j).setGroupIdentifier((byte)i);
                case 4:
                    index = 0;
                    while(!srcArray.get(j).getHall().equals("Fortes")||srcArray.get(index).getGroupIdentifier()!=-1){
                        index++;
                        if(index==srcArray.size())
                            j--;
                        iteration=4;
                        break;
                    }
                    if(srcArray.get(j).getHall().equals("Fortes")&&srcArray.get(index).getGroupIdentifier()==-1)
                        srcArray.get(j).setGroupIdentifier((byte)i);
            }

            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        SourceCSV source = new SourceCSV("src\\database\\sheet.csv");
        groupByHall(source.sourceArr, 5);
        System.out.println(source.sourceArr);

    }
}