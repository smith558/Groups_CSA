import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class GroupSplitting {
    /**
     * Returns an Image object that can then be painted on the screen.
     * The url argument must specify an absolute {@link URL}. The name
     * argument is a specifier that is relative to the url argument.
     * <p>
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     *
     * @param  url  an absolute URL giving the base location of the image
     * @param  name the location of the image, relative to the url argument
     * @return      the image at the specified URL
     * @see         Image
     */
    public static int groupByGender(ArrayList<Student> srcArr, int groupSize) {
        //  shuffling the srcArr to ensure 'randomness'
        Collections.shuffle(srcArr);
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
        System.out.println("There is " + srcArray.size() + " students");
        int groupsNr;
        if (srcArray.size() % nrInGroup == 0) {
            groupsNr = srcArray.size() / nrInGroup;
        } else {
            groupsNr = srcArray.size() / nrInGroup + 1;
        }
        System.out.println("There will be " + groupsNr + " groups.");
        int pplAdded = 0;
        for (int i = 1; i < groupsNr+1; i++) {
            int iteration = 1;
            int pplInGroup = 0;
            while (pplInGroup < nrInGroup && pplAdded < srcArray.size()) {
                switch (iteration) {
                    case 1:
                        if (pplInGroup == nrInGroup)
                            break;
                        for (int r = 0; r < srcArray.size(); r++) {
                            if (srcArray.get(r).getHall().equals("Founders") && srcArray.get(r).getGroupIdentifier() == -1) {
                                srcArray.get(r).setGroupIdentifier((byte) i);
                                pplInGroup++;
                                pplAdded++;
                                break;
                            }
                            if (r == srcArray.size()) {
                                iteration = 2;
                                break;
                            }
                        }
                    case 2:
                        if (pplInGroup == nrInGroup)
                            break;
                        for (int r = 0; r < srcArray.size(); r++) {
                            if (srcArray.get(r).getHall().equals("Gentlemen") && srcArray.get(r).getGroupIdentifier() == -1) {
                                srcArray.get(r).setGroupIdentifier((byte) i);
                                pplInGroup++;
                                pplAdded++;
                                break;
                            }
                            if (r == srcArray.size()) {
                                iteration = 3;
                                break;
                            }
                        }
                    case 3:
                        if (pplInGroup == nrInGroup)
                            break;
                        for (int r = 0; r < srcArray.size(); r++) {
                            if (srcArray.get(r).getHall().equals("Sprouts") && srcArray.get(r).getGroupIdentifier() == -1) {
                                srcArray.get(r).setGroupIdentifier((byte) i);
                                pplInGroup++;
                                pplAdded++;
                                break;
                            }
                            if (r == srcArray.size()) {
                                iteration = 4;
                                break;
                            }
                        }
                    case 4:
                        if (pplInGroup == nrInGroup)
                            break;
                        for (int r = 0; r < srcArray.size(); r++) {
                            if (srcArray.get(r).getHall().equals("Fortes") && srcArray.get(r).getGroupIdentifier() == -1) {
                                srcArray.get(r).setGroupIdentifier((byte) i);
                                pplInGroup++;
                                pplAdded++;
                                break;
                            }
                            if (r == srcArray.size()) {
                                iteration = 1;
                                break;
                            }
                        }
                }
            }
        }
    }

    public static int groupByYear(ArrayList<Student> srcArr, int groupSize) {
        //  have a look at this, proper division?
        int numOfGroups = srcArr.size() / groupSize;

        //  iterating through source
        int g1 = 1, g2 = 1, g3 = 1, g4 = 1;
        for (Student student : srcArr) {
            student.setGroupIdentifier((byte) 0);
            if (student.getYear() == 1) {
                if (g1 > numOfGroups) g1 = 1;
                student.setGroupIdentifier((byte) g1);
                g1++;
            } else if (student.getYear() == 2) {
                if (g2 > numOfGroups) g2 = 1;
                student.setGroupIdentifier((byte) g2);
                g2++;
            } else if (student.getYear() == 3) {
                if (g3 > numOfGroups) g3 = 1;
                student.setGroupIdentifier((byte) g3);
                g3++;
            } else {
                if (g4 > numOfGroups) g4 = 1;
                student.setGroupIdentifier((byte) g4);
                g4++;
            }
        }
        return numOfGroups;
    }

    public static void testGroups(ArrayList<Student> srcArr){
        int nrGroups = 0;
        for(int i=0;i<srcArr.size();i++){
            if(srcArr.get(i).getGroupIdentifier()>nrGroups)
                nrGroups = srcArr.get(i).getGroupIdentifier();
        }
        System.out.println("We have " +nrGroups+ " groups");
        for(int i=1;i<=nrGroups;i++){
            System.out.println("In group number "+i+" there are these objects:");
            for(int j=0;j<srcArr.size();j++){
                if(srcArr.get(j).getGroupIdentifier()==i)
                    System.out.println(srcArr.get(j));
            }
            System.out.println("");
        }
    }

    public static void shuffleReset(ArrayList<Student> srcArray){
        Collections.shuffle(srcArray);
        for(int i=0;i<srcArray.size();i++)
            srcArray.get(i).setGroupIdentifier((byte)-1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        SourceCSV source = new SourceCSV("src\\database\\sheet.csv");
        groupByHall(source.getSourceArr(), 8);
        testGroups(source.getSourceArr());
        shuffleReset(source.getSourceArr());
        groupByHall(source.getSourceArr(),8);
        testGroups(source.getSourceArr());

    }
}