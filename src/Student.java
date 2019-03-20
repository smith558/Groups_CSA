public class Student {

    private String email;
    private String fullName;
    private String hall;
    // changed to int, makes more sense [Stanley]
    private int year;
    // gender is set based on hall [Jirka]
    private char gender;
    private byte groupIdentifier = -1;

    public Student() { }

    public Student(String email) { this.email = email; }

    public Student(String email, String name, String hall, int year) {
        this.email = email;
        this.fullName = name;
        this.hall = hall;
        this.year = year;
        if(hall.equals("Founders") || hall.equals("Gentlemen")){
            gender = 'm';
        }
        else{
            gender = 'f';
        }
    }

    @Override
    public String toString() {
        return fullName + ", " + email + ", " + hall + ", " + "Year " + year + ", Gender: " + gender + ", Group: " +groupIdentifier;
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

    void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHall() {
        return hall;
    }

    void setHall(String hall) {
        this.hall = hall;
    }

    public int getYear() {
        return year;
    }

    void setYear(int year) {
        this.year = year;
    }

    void setGender(char gender){
        this.gender = gender;
    }

    public char getGender() { return gender; }

    public byte getGroupIdentifier() {
        return groupIdentifier;
    }

    public void setGroupIdentifier(byte groupIdentifier) {
        this.groupIdentifier = groupIdentifier;
    }
}