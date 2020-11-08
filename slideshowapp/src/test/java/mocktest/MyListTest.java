/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocktest;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author Phillip
 */
public class MyListTest {
    
    public MyListTest() {
    }
    
    @Test
    public void testGet() {
        MyList listMock = Mockito.mock(MyList.class);
        
    }

    
}
