package mocktest;

import java.util.List;

public class WebService implements BookServiceInterface {


    @Override
    public List<Book> findBookByTitle(String author) {
        return null;
    }

    @Override
    public void setBookDao(BookDao bookDao) {
    }

}
