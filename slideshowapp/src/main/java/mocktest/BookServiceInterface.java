package mocktest;

import java.util.List;

public interface BookServiceInterface {

    List<Book> findBookByTitle(String author);
    void setBookDao(BookDao bookDao);

}
