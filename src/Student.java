public class Student {

    private String email;
    private String fullName;
    private String hall;
    private byte year;
    private char gender;
    private byte groupIdentifier;

    public Student(String email, String name, String hall, byte year, char gender) {
        this.email = email;
        fullName = name;
        this.hall = hall;
        this.year = year;
        this.gender = gender;
        groupIdentifier = -1;
    }
}