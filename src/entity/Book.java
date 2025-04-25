package entity;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isIssued;
    private double price; 

    public Book(String bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isIssued = false;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public double getPrice() { return price; }

    public void setIssued(boolean issued) { this.isIssued = issued; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "[" + bookId + "] " + title + " by " + author + " - Rs. " + price + (isIssued ? " (Issued)" : " (Available)");
    }
}
