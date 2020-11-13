package infrastructure;

import domaincore.HtmlElement;
import domaincore.Level;
import domaincore.SlideElements;
import domaincore.SlideHelpers;
import domainservices.Figure;
import domainservices.SlideComponentInterface;
import domainservices.SlideComposite;
import domainservices.Text;
import domainservices.Title;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test
    public void testGetTxtDataFromSlideElementTitle() {
        Level elementLevel = new Level(0, 10, 20);
        SlideComponentInterface slideElement = new Title(Color.BLUE, "Presentatie", elementLevel);

        SlideProcessor instance = new SlideProcessor();
        String expTitleResult = "<title>:Presentatie";
        byte[] result = instance.GetTxtDataFromSlideElement(slideElement);
        String titleResult = new String(result).replaceAll("(\\r|\\n)", "");
        assertEquals(expTitleResult, titleResult);
    }

    @Test
    public void testGetTxtDataFromSlideElementTextWithLevel1() {
        Level elementLevel = new Level(1, 10, 20);
        SlideComponentInterface slideElement = new Text(Color.BLUE, "RandomText1", elementLevel);

        SlideProcessor instance = new SlideProcessor();
        String expTextResult = "<level1>:RandomText1";
        byte[] result = instance.GetTxtDataFromSlideElement(slideElement);
        String textResult = new String(result).replaceAll("(\\r|\\n)", "");
        assertEquals(expTextResult, textResult);
    }

    @Test
    public void testGetHtmlDataFromSlideElementTitle() {
        Level elementLevel = new Level(0, 10, 20);
        SlideComponentInterface slideElement = new Title(Color.BLUE, "Presentatie", elementLevel);

        SlideProcessor instance = new SlideProcessor();
        String expResult = "<p id= 'title'>Presentatie</p>";
        String result = instance.GetHtmlDataFromSlideElement(slideElement);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHtmlDataFromSlideElementFigure() {
        Level elementLevel = new Level(0, 10, 20);
        SlideComponentInterface slideElement = new Figure(Color.BLUE, "http://www.slide1.nl/image1", elementLevel);

        SlideProcessor instance = new SlideProcessor();
        String expResult = "<img src=\"http://www.slide1.nl/image1\">";
        String result = instance.GetHtmlDataFromSlideElement(slideElement);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateSlideCompositeArrayTextLevel3() {
        HtmlElement htmlElement = new HtmlElement();

        String text1 = "<p id='level3'>Datum: 20 Oktober 2020 <br> Presentators: Phillip and Jhaner</p>";
        String text2 = "<p id='level3'>Tot ziens!</p>";
        String[] strings = {text1, text2};
        htmlElement.setLevel1(strings);

        SlideProcessor instance = new SlideProcessor();

        ArrayList<SlideComponentInterface> result = instance.CreateSlideCompositeArray(htmlElement);
        SlideComponentInterface slides = (SlideComposite) result.get(0);
        Text slide1 = (Text) slides.getSlide(0);
        Text slide2 = (Text) slides.getSlide(1);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(2, slides.getSize());
        assertEquals(text1, slide1.getText());
        assertEquals(text2, slide2.getText());
    }
}
