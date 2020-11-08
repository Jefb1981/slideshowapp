/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocktest;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Phillip
 */
public class AuthorServiceTest {

    @Test
    public void testTotalBooks() {

        //1. Setup the service
        AuthorServiceInterface authorService = new AuthorService();
        BookServiceInterface bookService = new BookService();
        //creating a list in bookService, 
        bookService.setBookDao(new BookDao()); 
        authorService.setBookService(bookService);
        //not returing any book
//        authorService.setBookValidatorService(new WebValidatorService());

        //2. Test method
        int totalBooks = authorService.getSizeFilteredBooks("1984");

        //3. Verify result
        assertEquals(2, totalBooks);

    }
}
