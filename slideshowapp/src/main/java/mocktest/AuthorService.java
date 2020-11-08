package mocktest;

public class AuthorService implements AuthorServiceInterface {

    private BookServiceInterface bookService;
    private BookValidatorService bookValidatorService = new BookValidatorService();

    ;

    public AuthorService() {
        this.bookService = new BookService();
    }

    public BookValidatorService getBookValidatorService() {
        return bookValidatorService;
    }

    public void setBookValidatorService(BookValidatorService bookValidatorService) {
        this.bookValidatorService = bookValidatorService;
    }

    public BookServiceInterface getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    //How to test this method ???
    @Override
    public int getSizeFilteredBooks(String title) {
        return bookService.findBookByTitle(title).size();
    }

    @Override
    public void setBookService(BookServiceInterface bookService) {
        this.bookService = bookService;
    }

}
