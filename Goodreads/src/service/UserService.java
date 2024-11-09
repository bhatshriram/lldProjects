package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Book;
import models.User;

public class UserService {

    private final Map<String, User> users;

    private UserService() {
        this.users = new HashMap<>();
    }

    private static class helper {

        private static final UserService instance = new UserService();
    }

    public static UserService getInstance() {
        return helper.instance;
    }

    public User addUser(String userName) {
        User user = new User(userName);
        users.put(user.getUserId(), user);
        return user;
    }

    public User removeUser(String userId) {
        User user = users.get(userId);
        users.remove(userId);
        return user;
    }

    public User getUser(String userId) {
        if (!users.containsKey(userId)) {
            return null;
        }

        return users.get(userId);
    }

    public void addFriend(User user, User friend) {
        user.getFriends().add(friend);
    }

    public void addBook(User user, Book book) {
        user.getBooks().add(book);
    }

}
