package entity;

public class LibraryCardRequest {
    private String studentId;
    private boolean approved;

    public LibraryCardRequest(String studentId) {
        this.studentId = studentId;
        this.approved = false;
    }

    public String getStudentId() { return studentId; }
    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
}