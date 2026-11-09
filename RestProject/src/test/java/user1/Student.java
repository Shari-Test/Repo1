package user1;

public class Student {

    private String name;
    private String email;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}