package entity;

public class Student {
    private String studentId;
    private String name;
    private boolean hasLibraryCard;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.hasLibraryCard = false;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public boolean hasLibraryCard() { return hasLibraryCard; }
    public void setLibraryCard(boolean hasCard) { this.hasLibraryCard = hasCard; }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Library Card: " + (hasLibraryCard ? "Yes" : "No");
    }
}