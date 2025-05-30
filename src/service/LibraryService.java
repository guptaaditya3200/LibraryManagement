package service;

import entity.*;
import Repository.*;
import java.util.*;

public class LibraryService {
    private StudentRepository studentRepo = new StudentRepository();
    private BookRepository bookRepo = new BookRepository();
    private LibraryCardRepository cardRepo = new LibraryCardRepository();
    private IssueHistoryRepository historyRepo = new IssueHistoryRepository();
    private Map<String, LibraryCardRequest> requests = new HashMap<>();

    public void registerStudent(Student student) {
        studentRepo.addStudent(student);
        System.out.println("Student registered successfully.");
    }

    public boolean isStudentExists(String sid) {
        return studentRepo.exists(sid);
    }

    public void addBook(Book book) {
        if (bookRepo.exists(book.getBookId())) {
            System.out.println("Book ID already exists. Choose a unique ID.");
            return;
        }
        bookRepo.addBook(book);
        System.out.println("Book added.");
    }
    

    public void removeBook(String id) {
        bookRepo.removeBook(id);
        System.out.println("Book removed.");
    }

    public void viewBooks(String sortOption) {
        List<Book> books = new ArrayList<>(bookRepo.getAllBooks());
    
        switch (sortOption.toLowerCase()) {
            case "id" -> books.sort((b1, b2) -> b1.getBookId().compareTo(b2.getBookId()));
            case "title" -> books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
            case "price" -> books.sort((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
            case "author" -> books.sort((b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));
            default -> System.out.println("Invalid sort option. Showing unsorted list.");
        }
    
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    

    public void issueBook(String bookId, String studentId) {
        Book book = bookRepo.getBook(bookId);
        Student student = studentRepo.getStudent(studentId);
        if (book != null && student != null && student.hasLibraryCard() && !book.isIssued()) {
            book.setIssued(true);
            historyRepo.log(studentId, bookId);
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Cannot issue book. "+
                (book == null ? "Book not found." : "") +
                (student == null ? " Student not found." : "") +
                (!student.hasLibraryCard() ? " Student does not have a library card." : "") +
                (book.isIssued() ? " Book already issued." : ""));
        }
    }

    public void requestLibraryCard(String studentId) {
        Student student = studentRepo.getStudent(studentId);
        if (student != null && !student.hasLibraryCard()) {
            requests.put(studentId, new LibraryCardRequest(studentId));
            System.out.println("Library card request submitted.");
        } else {
            System.out.println("Already has card or student not found.");
        }
    }

    public void approveLibraryCard(String studentId) {
        LibraryCardRequest req = requests.get(studentId);
        Student student = studentRepo.getStudent(studentId);
        if (req != null && student != null && !req.isApproved()) {
            LibraryCard card = new LibraryCard("LC" + studentId, studentId);
            cardRepo.addCard(card);
            student.setLibraryCard(true);
            req.setApproved(true);
            System.out.println("Library card issued: " + card);
        } else {
            System.out.println("Request not found or already approved.");
        }
    }

    public void viewStudentProfile(String studentId) {
        Student student = studentRepo.getStudent(studentId);
        if (student != null) {
            System.out.println(student);
            System.out.println("History: " + historyRepo.getHistory(studentId));
        } else {
            System.out.println("Student not found.");
        }
    }
    public void returnBook(String bookId) {
    Book book = bookRepo.getBook(bookId);
    if (book != null && book.isIssued()) {
        book.setIssued(false);
        System.out.println("Book returned successfully.");
    } else {
        System.out.println("Invalid book ID or book was not issued.");
    }
}
}