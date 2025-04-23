package entity;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private String phone;
    private boolean hasLibraryCard;

    public Student(String studentId, String name, String email, String phone) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.hasLibraryCard = false;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public boolean hasLibraryCard() { return hasLibraryCard; }
    public void setLibraryCard(boolean hasCard) { this.hasLibraryCard = hasCard; }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Email: " + email + ", Phone: " + phone + ", Library Card: " + (hasLibraryCard ? "Yes" : "No");
    }
}
