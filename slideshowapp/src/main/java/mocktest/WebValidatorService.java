package mocktest;

public class WebValidatorService implements BookValidatorServiceInterface {

    @Override
    public boolean isValid(Book book, String title) {
        if (book == null) {
            return false;
        }

        return !(title.equals(book.getTitle()));
    }

}
