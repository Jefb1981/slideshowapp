///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package mocktest;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
///**
// *
// * @author Phillip
// */
//public class AuthorServiceTest {
//
//    @Test
//    public void testTotalBooks() {
//
//        //1. Setup the service
//        AuthorServiceInterface authorService = new AuthorService();
//        BookServiceInterface bookService = new BookService();
//        //mock
//        BookServiceInterface bookServiceMock = mock(BookService.class);
//        AuthorServiceInterface authorServiceMock = mock(AuthorService.class);
//        //creating a list in bookService, 
//        bookService.setBookDao(new BookDao()); 
//        //with mock
//        bookServiceMock.setBookDao(new BookDao()); 
//        
//        authorService.setBookService(bookService);
//        authorServiceMock.setBookService(bookService);
//        
//        //k
//       authorServiceMock.setBookService(new WebService());
//
//        //2. Test method
//        int totalBooks = authorService.getSizeFilteredBooks("1984");
//        int resultMock=10;
//        
//
//        //3. Verify result
//        //assertEquals(2, totalBooks);
//        when(authorServiceMock.getSizeFilteredBooks("1984"));        
//
//    }
//}
