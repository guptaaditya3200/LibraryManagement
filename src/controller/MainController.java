package controller;
import entity.*;
import service.LibraryService;

import java.util.*;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        while (true) {
            System.out.println("\n1. Login as Student\n2. Login as Librarian\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student ID: ");
                    String sid = sc.next();
                    studentMenu(service, sc, sid);
                }
                case 2 -> librarianMenu(service, sc);
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void librarianMenu(LibraryService service, Scanner sc) {
        while (true) {
            System.out.println("\nLibrarian Menu:\n1. Add Book\n2. Remove Book\n3. Issue Book\n4. Create Library Card\n5. View All Books\n6. Back");
            int opt = sc.nextInt();
            switch (opt) {
                case 1 -> {
                    System.out.print("Enter Book ID, Title, Author: ");
                    String bid = sc.next();
                    String title = sc.next();
                    String author = sc.next();
                    service.addBook(new Book(bid, title, author));
                }
                case 2 -> {
                    System.out.print("Enter Book ID to remove: ");
                    service.removeBook(sc.next());
                }
                case 3 -> {
                    System.out.print("Enter Book ID and Student ID: ");
                    service.issueBook(sc.next(), sc.next());
                }
                case 4 -> {
                    System.out.print("Enter Student ID: ");
                    service.createLibraryCard(sc.next());
                }
                case 5 -> service.viewBooks();
                case 6 -> { return; }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static void studentMenu(LibraryService service, Scanner sc, String sid) {
        service.addStudent(new Student(sid, "Student" + sid));
        while (true) {
            System.out.println("\nStudent Menu:\n1. View Profile\n2. Request Library Card\n3. View Books\n4. Back");
            int opt = sc.nextInt();
            switch (opt) {
                case 1 -> service.viewStudentProfile(sid);
                case 2 -> service.createLibraryCard(sid);
                case 3 -> service.viewBooks();
                case 4 -> { return; }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
