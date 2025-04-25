package Repository;

import entity.Book;
import java.util.*;

public class BookRepository {
    private Map<String, Book> books = new HashMap<>();
    {
        books.put("1", new Book("1", "Tushar sir Greatness", "Aditya",200));
        books.put("2", new Book("2", "Divyansh Biography", "Ish",300));
        books.put("3", new Book("3", "Love story of divyansh", "Ish",250));
    }

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public Book getBook(String id) {
        return books.get(id);
    }

    public int size() {
        return books.size();
    }

    public boolean exists(String id) {
        return books.containsKey(id);
    }

    public void removeBook(String id) {
        books.remove(id);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
