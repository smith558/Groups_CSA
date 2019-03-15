
public class Student {

    private String fullName;
    private String hall;
    private byte year;
    private char gender;
    private byte groupIdentifier;

    Student(String Name, String Hall, byte Year, char Gender) {

        fullName = Name;
        hall = Hall;
        year = Year;
        gender = Gender;
        groupIdentifier = -1;
    }
}