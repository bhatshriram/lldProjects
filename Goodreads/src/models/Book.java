package models;

import java.util.UUID;

public class Book {

    private String bookId;
    private String bookName;

    public Book(String bookName) {
        this.bookId = UUID.randomUUID().toString();
        this.bookName = bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
