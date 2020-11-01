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
public class TxtFileProcessorTest {
    
    public TxtFileProcessorTest() {
    }

    /**
     * Test of loadFile method, of class TxtFileProcessor.
     */
    @Test
    public void testLoadFile() {
        System.out.println("load text file");
        String filePath = "C:\\Users\\Phillip\\Documents\\NetBeansProjects\\slideshow\\Documents\\Slide_txt_example.txt";
        TxtFileProcessor txtFileProcessor = new TxtFileProcessor();
        ArrayList<SlideComponentInterface> expResult = null;
        ArrayList<SlideComponentInterface> result = txtFileProcessor.loadFile(filePath);
        int numberOfSlides=3;
        assertEquals(numberOfSlides, result.size());
    }

    /**
     * Test of saveFile method, of class TxtFileProcessor.
     */
    @Test
    public void testSaveFile() {
        System.out.println("saveFile");
        String fileName = "";
        TxtFileProcessor instance = new TxtFileProcessor();
        instance.saveFile(fileName);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
