/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

import domainservices.SlideComponentInterface;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Phillip
 */
public class HtmlFileProcessorTest {
    
    public HtmlFileProcessorTest() {
    }

    /**
     * Test of loadFile method, of class HtmlFileProcessor.
     */
    @Test
    public void testLoadFile() {
        System.out.println("load HTML file");
        String filePath = "C:\\Users\\Phillip\\Documents\\NetBeansProjects\\slideshowapp\\Documents\\slide_1_html_example.html";
        HtmlFileProcessor instance = new HtmlFileProcessor();
        int expResult = 1;
        ArrayList<SlideComponentInterface> result = instance.loadFile(filePath);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
    }

    
}
