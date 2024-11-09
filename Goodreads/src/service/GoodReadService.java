package service;

import core.BookLookupStrategy;
import java.util.List;
import models.Book;
import models.User;

public class GoodReadService {

    private UserService userService;
    private BookService bookService;
    private BookLookupStrategy bookLookupStrategy;

    public GoodReadService(BookLookupStrategy bookLookupStrategy) {
        userService = UserService.getInstance();
        bookService = BookService.getInstance();
        this.bookLookupStrategy = bookLookupStrategy;
    }

    public User addUser(String userName) {
        return userService.addUser(userName);
    }

    public Book addBook(String bookName) {
        return bookService.addBook(bookName);
    }

    public void addFriend(User user, User friend) {
        userService.addFriend(user, friend);
    }

    public void addBook(User user, Book book) {
        userService.addBook(user, book);
    }

    public List<Book> getTopKReadBooks(User user) {
        return this.bookLookupStrategy.getTopBooksReadByFriends(user, bookService.getBooks());
    }

    public List<Book> getTopBooksReadByNetwork(User user, int k, int maxDepth) {
        return this.bookLookupStrategy.getTopBooksReadByNetwork(user, bookService.getBooks(), k, maxDepth);
    }

}
