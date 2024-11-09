package service;

import java.util.HashMap;
import java.util.Map;
import models.Book;

public class BookService {

    private final Map<String, Book> books;

    private BookService() {
        this.books = new HashMap<>();
    }

    private static class helper {

        public static final BookService bookService = new BookService();
    }

    public static BookService getInstance() {
        return helper.bookService;
    }

    public Book getBook(String bookId) {
        return this.books.get(bookId);
    }

    public Book addBook(String bookName) {
        Book book = new Book(bookName);
        books.put(book.getBookId(), book);
        return book;
    }

    public Map<String, Book> getBooks() {
        return books;
    }
}
