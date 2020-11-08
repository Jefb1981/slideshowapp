package mocktest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDao implements BookDaoInterface {

    @Override
    public List<Book> findBookByTitle(String name) {
        List<Book> bookList = initBookListFromDatabase();
        List<Book> filteredList = bookList
                .stream()
                .filter(book -> book.getTitle().equals(name))
                .collect(Collectors.toList());
        return filteredList;
    }

    private List<Book> initBookListFromDatabase() {
        List<Book> bookList = new ArrayList();
        bookList.add(new Book("George Orwell", "1984"));
        bookList.add(new Book("George Orwell", "2020"));
        bookList.add(new Book("Stephen Hawking", "1984"));
        return bookList;
    }

}
