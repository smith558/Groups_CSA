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

    void groupByHall(ArrayList<Student> srcArray, int nrInGroup) {

    }

    public static void main(String[] args) {

    }
}