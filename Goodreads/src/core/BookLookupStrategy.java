package core;

import java.util.List;
import java.util.Map;
import models.Book;
import models.User;

public interface BookLookupStrategy {

    List<Book> getTopBooksReadByFriends(User user, Map<String, Book> books);
    List<Book> getTopBooksReadByNetwork(User user, Map<String, Book> books, int k, int maxDepth);
}
