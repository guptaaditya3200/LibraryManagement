package service;

import entity.*;

import java.util.*;

public class LibraryService {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Student> students = new HashMap<>();
    private Map<String, LibraryCard> cards = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(String bookId) {
        if (books.containsKey(bookId)) {
            books.remove(bookId);
            System.out.println("Book removed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void issueBook(String bookId, String studentId) {
        Book book = books.get(bookId);
        Student student = students.get(studentId);
        if (book != null && student != null && student.hasLibraryCard() && !book.isIssued()) {
            book.setIssued(true);
            System.out.println("Book issued to " + student.getName());
        } else {
            System.out.println("Cannot issue book.");
        }
    }

    public void createLibraryCard(String studentId) {
        Student student = students.get(studentId);
        if (student != null && !student.hasLibraryCard()) {
            String cardId = "LC" + studentId;
            LibraryCard card = new LibraryCard(cardId, studentId);
            cards.put(cardId, card);
            student.setLibraryCard(true);
            System.out.println("Library card created: " + card);
        } else {
            System.out.println("Library card already exists or student not found.");
        }
    }

    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
        System.out.println("Student registered.");
    }

    public void viewStudentProfile(String studentId) {
        Student student = students.get(studentId);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void viewBooks() {
        books.values().forEach(System.out::println);
    }
}
