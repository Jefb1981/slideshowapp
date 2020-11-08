
package mocktest;

public class BookValidatorService implements BookValidatorServiceInterface {

    public BookValidatorService() {
        System.out.println("check");
    }
    
    

    @Override
    public boolean isValid(Book book, String bookString) {
        return book.getAuthor().equals(bookString);
    }

}
