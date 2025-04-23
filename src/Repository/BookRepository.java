package Repository;

import entity.Book;
import java.util.*;

public class BookRepository {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public Book getBook(String id) {
        return books.get(id);
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
