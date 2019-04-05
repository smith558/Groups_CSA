import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

/**
 * This class provides for all the static grouping methods available, these methods group
 * students from the 'groupByHall' based on a characteristic
 */
public class GroupSplitting {

    /**
     * @param srcArr bla
     * @param groupSize bla
     * @return bla
     */
    public static int groupByGender(ArrayList<Student> srcArr, int groupSize) {
        //  shuffling the srcArr to ensure 'randomness'
        Collections.shuffle(srcArr);
        //  have a look at this, proper division?
        int numOfGroups = (int) (srcArr.size() / groupSize + 0.5);

        //  iterating through source
        int gB = 1, gG = 1;
        for (Student student : srcArr) {
            student.setGroupIdentifier((byte) 0);
            if (student.getGender() == 'f') {
                if (gG > numOfGroups)
                    gG = 1;
                student.setGroupIdentifier((byte) gG);
                gG++;
            } else {
                if (gB > numOfGroups)
                    gB = 1;
                student.setGroupIdentifier((byte) gB);
                gB++;
            }
        }
        return numOfGroups;
    }

    /**
     * Groups the array specified in input by hall so that there is an equal count of each
     * hall in each group - works best if number of people in group is divisible by 4
     *
     * @param srcArray  array we want to sort by hall
     * @param nrInGroup number of people we want in one group
     */
    public static void groupByHall(ArrayList<Student> srcArray, int nrInGroup) {
        out.println("There is " + srcArray.size() + " students");
        int groupsNr;
        //counts groups
        if (srcArray.size() % nrInGroup == 0) {
            groupsNr = srcArray.size() / nrInGroup;
        } else {
            groupsNr = srcArray.size() / nrInGroup + 1;
        }
        out.println("There will be " + groupsNr + " groups.");
        int pplAdded = 0;
        for (int i = 1; i < groupsNr + 1; i++) {
            int iteration = 1;
            int pplInGroup = 0;
            //always picks a person from each hall and adds them to the group
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

    /**
     * @param srcArr bla
     * @param groupSize bla
     * @return bla
     */
    public static int groupByYear(ArrayList<Student> srcArr, int groupSize) {
        //  shuffling the srcArr to ensure 'randomness'
        Collections.shuffle(srcArr);
        //  have a look at this, proper division?
        int numOfGroups = (int) (srcArr.size() / groupSize + 0.5);

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

    /**
     * Prints out the specified field sorted by groups that are created in it and speaks about the groups' parameters
     *
     * @param srcArr the array we want to print
     */
    public static void testGroups(ArrayList<Student> srcArr) {
        int nrGroups = 0;
        for (Student aSrcArr : srcArr) {
            if (aSrcArr.getGroupIdentifier() > nrGroups)
                nrGroups = aSrcArr.getGroupIdentifier();
        }
        out.println("We have " + nrGroups + " groups");
        for (int i = 1; i <= nrGroups; i++) {
            int nrBoys = 0, nrGirls = 0, nrFounders = 0, nrGentlemen = 0, nrSprouts = 0, nrFortes = 0, nrY1 = 0, nrY2 = 0, nrY3 = 0, nrY4 = 0;
            out.println("In group number " + i + " there are these objects:");

            for (Student aSrcArr : srcArr) {
                if (aSrcArr.getGroupIdentifier() == i) {
                    switch (aSrcArr.getGender()) {
                        case 'f':
                            nrGirls++;
                            break;
                        case 'm':
                            nrBoys++;
                            break;
                    }
                    switch (aSrcArr.getHall()) {
                        case "Founders":
                            nrFounders++;
                            break;
                        case "Gentlemen":
                            nrGentlemen++;
                            break;
                        case "Sprouts":
                            nrSprouts++;
                            break;
                        case "Fortes":
                            nrFortes++;
                            break;
                    }
                    switch (aSrcArr.getYear()) {
                        case 1:
                            nrY1++;
                            break;
                        case 2:
                            nrY2++;
                            break;
                        case 3:
                            nrY3++;
                            break;
                        case 4:
                            nrY4++;
                            break;
                    }
                    if (aSrcArr.getGroupIdentifier() == i)
                        out.println(aSrcArr);
                }
            }
            out.println("\nThere is " + nrFounders + " Founders, " + nrGentlemen + " Gentlemen, " + nrSprouts + " Sprouts, " + nrFortes + " Fortes in this group.");
            out.println("There is " + nrGirls + " females and " + nrBoys + " males.");
            out.println("There is " + nrY1 + " Y1s, " + nrY2 + " Y2s, " + nrY3 + " Y3s and " + nrY4 + " Y4s.");
            out.println();
        }

    }

    /**
     * Shuffles the specified array and sets the group identifier to -1
     *
     * @param srcArray array we want to shuffle
     */
    public static void shuffleReset(ArrayList<Student> srcArray) {
        Collections.shuffle(srcArray);
        for (Student aSrcArray : srcArray)
            aSrcArray.setGroupIdentifier((byte) -1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        SourceCSV source = new SourceCSV("src\\database\\sheet.csv");

        groupByGender(source.getSourceArr(), 5);
        testGroups(source.getSourceArr());
    }
}