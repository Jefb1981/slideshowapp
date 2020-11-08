package mocktest;
import java.util.List;

public interface BookDaoInterface {

    List<Book> findBookByTitle(String author);
    
}