package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private String userId;
    private String userName;
    private List<Book> books;
    private List<User> friends;

    public User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.books = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
