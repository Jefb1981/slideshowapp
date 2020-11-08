package mocktest;
public interface AuthorServiceInterface {

    int getSizeFilteredBooks(String author);
    void setBookService(BookServiceInterface bookService);
    void setBookValidatorService(BookServiceInterface bookService);

}