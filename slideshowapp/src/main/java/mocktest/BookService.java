package mocktest;

import java.util.List;

public class BookService implements BookServiceInterface {

    private BookDao bookDao = new BookDao();

    public BookDaoInterface getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> findBookByTitle(String name) {
        return bookDao.findBookByTitle(name);
    }

}
