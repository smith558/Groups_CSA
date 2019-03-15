public class Student {

    private String email;
    private String fullName;
    private String hall;
    private int year;
    // no gender field available from data
    private char gender;
    private byte groupIdentifier = -1;

    public Student() { }

    public Student(String email) { this.email = email; }

    public Student(String email, String name, String hall, int year) {
        this.email = email;
        this.fullName = name;
        this.hall = hall;
        this.year = year;
    }

    @Override
    public String toString() {
        return fullName + ", " + email + ", " + hall + ", " + "Year " + year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public byte getGroupIdentifier() {
        return groupIdentifier;
    }

    public void setGroupIdentifier(byte groupIdentifier) {
        this.groupIdentifier = groupIdentifier;
    }
}