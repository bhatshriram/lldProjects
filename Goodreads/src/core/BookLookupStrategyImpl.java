package core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import models.Book;
import models.User;

public class BookLookupStrategyImpl implements BookLookupStrategy {


    @Override
    public List<Book> getTopBooksReadByFriends(User user, Map<String, Book> books) {
        Map<String, Integer> topBooks = new HashMap<>();

        for (Book book : user.getBooks()) {

            for (User friend : user.getFriends()) {
                if (friend.getBooks().contains(book)) {
                    topBooks.put(book.getBookId(), topBooks.getOrDefault(book.getBookId(), 0) + 1);
                }
            }
        }

        List<Book> booksRes = topBooks.entrySet().stream().sorted((a, b)-> b.getValue()-a.getValue())
            .map(entry -> books.get(entry.getKey())).collect(Collectors.toUnmodifiableList());

        return booksRes;
    }

    @Override
    public List<Book> getTopBooksReadByNetwork(User user, Map<String, Book> bookMap, int k, int maxDepth) {

        Map<String, Integer> topBooks = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<User> queue = new LinkedList<>();

        queue.add(user);
        visited.add(user.getUserId());

        while (!queue.isEmpty() && maxDepth >= 0) {

            int size = queue.size();
            maxDepth--;

            for (int i = 0; i < size; i++) {
                User friend = queue.remove();

                for(Book book: friend.getBooks()) {
                    topBooks.put(book.getBookId(), topBooks.getOrDefault(book.getBookId(), 0) + 1);
                }

                for (User friend1 : friend.getFriends()) {
                    if (!visited.contains(friend1.getUserId())) {
                        queue.add(friend1);
                        visited.add(friend1.getUserId());
                    }
                }
            }
        }

        List<Book> res = topBooks.entrySet().stream().sorted((a, b)-> b.getValue()-a.getValue()).limit(k)
            .map(entry -> bookMap.get(entry.getKey())).collect(Collectors.toUnmodifiableList());

        return res;
    }
}
