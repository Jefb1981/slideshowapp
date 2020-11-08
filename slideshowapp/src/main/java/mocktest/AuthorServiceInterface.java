package mocktest;
public interface AuthorServiceInterface {

    int getSizeFilteredBooks(String author);
    void setBookService(BookServiceInterface bookService);

}