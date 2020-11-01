package userinterface;

import domaincore.Level;
import domainservices.Figure;
import domainservices.SlideComponentInterface;
import domainservices.SlideComposite;
import domainservices.Title;
import java.awt.Color;
import java.awt.Graphics;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Phillip
 */
public class ProjectorTest {

    public ProjectorTest() {
    }

    /**
     * Test of startShow method, of class Projector.
     */
    @Test
    public void testStartShow() {
        System.out.println("startShow");
        Projector projector = new Projector();
        projector.startShow();
        assertTrue(projector.getSlideComposite().getSize() == 1);
    }

    /**
     * a test to see if the files have been imported correctly
     */
    @Test
    public void testLoadFile() {
        System.out.println("loadShapes");
        Projector projector = new Projector();
        assertEquals(projector.testFileExtension(), "txt");

    }
}
