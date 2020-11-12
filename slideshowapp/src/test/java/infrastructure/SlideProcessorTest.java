/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

import domaincore.HtmlElement;
import domaincore.Level;
import domaincore.SlideElements;
import domaincore.SlideHelpers;
import domainservices.SlideComponentInterface;
import domainservices.Title;
import java.awt.Color;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhane
 */
public class SlideProcessorTest {

    public SlideProcessorTest() {
    }

    @Test
    public void testReadLineByLineFileContent() {
        // wont test, we can create a wrapper around the Files class to mock the method Lines
    }

    // Foreach Object(Title/Subtitle/Level1,2,3,4 and Figure) we should create tests.
    // but all the test should look the same as here bellow
    @Test
    public void testCreateSlideElementsFromTextTitleFromData() {

        String data = "<title>:Presentatie";
        Level elementLevel = new Level(0, 10, 20);

        SlideProcessor instance = new SlideProcessor();
        Title expResult = new Title(Color.BLUE, "Presentatie", elementLevel);
        Title result = (Title) instance.createSlideElements(data, elementLevel);

        assertEquals(expResult.color, result.color);
        assertEquals(expResult.getTitle(), result.getTitle());
        assertEquals(expResult.level, result.level);
    }

//    @Test
//    public void testGetTxtDataFromSlideElement() {
//        System.out.println("GetTxtDataFromSlideElement");
//        SlideComponentInterface slideElement = null;
//        SlideProcessor instance = new SlideProcessor();
//        byte[] expResult = null;
//        byte[] result = instance.GetTxtDataFromSlideElement(slideElement);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetHtmlDataFromSlideElement() {
//        System.out.println("GetHtmlDataFromSlideElement");
//        SlideComponentInterface slideElement = null;
//        SlideProcessor instance = new SlideProcessor();
//        String expResult = "";
//        String result = instance.GetHtmlDataFromSlideElement(slideElement);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testCreateSlideCompositeArray() {
//        System.out.println("CreateSlideCompositeArray");
//        HtmlElement htmlElement = null;
//        SlideProcessor instance = new SlideProcessor();
//        ArrayList<SlideComponentInterface> expResult = null;
//        ArrayList<SlideComponentInterface> result = instance.CreateSlideCompositeArray(htmlElement);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
