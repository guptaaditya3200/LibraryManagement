package entity;

public class LibraryCard {
    private String cardId;
    private String studentId;

    public LibraryCard(String cardId, String studentId) {
        this.cardId = cardId;
        this.studentId = studentId;
    }

    public String getCardId() { return cardId; }
    public String getStudentId() { return studentId; }

    @Override
    public String toString() {
        return "Library Card [Card ID: " + cardId + ", Student ID: " + studentId + "]";
    }
}