package core;

import java.util.List;
import java.util.Map;
import models.Book;
import models.User;

public interface BookLookupStrategy {

    List<Book> getTopBooksReadByFriends(User user);
    List<Book> getTopBooksReadByNetwork(User user, Map<String, Book> books, int maxDepth);
}
