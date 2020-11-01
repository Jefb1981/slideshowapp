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
    public void testLoadShapes() {
        System.out.println("loadShapes");
        Projector projector = new Projector();
        assertEquals(projector.testFileExtension(),"txt");
    }

    /**
     * Test of nextSlide method, of class Projector.
     *
     * @Test public void testNextSlide() { System.out.println("nextSlide");
     * Projector instance = new Projector(); instance.nextSlide(); // TODO
     * review the generated test code and remove the default call to fail.
     * fail("The test case is a prototype."); }
     *
     * /**
     * Test of prevSlide method, of class Projector.
     *
     * @Test public void testPrevSlide() { System.out.println("prevSlide");
     * Projector instance = new Projector(); instance.prevSlide(); // TODO
     * review the generated test code and remove the default call to fail.
     * fail("The test case is a prototype."); }
     *
     * /**
     * Test of setCurrentSlideNumber method, of class Projector.
     *
     * @Test public void testSetCurrentSlideNumber() {
     * System.out.println("setCurrentSlideNumber"); int number = 0; Projector
     * instance = new Projector(); instance.setCurrentSlideNumber(number); //
     * TODO review the generated test code and remove the default call to fail.
     * fail("The test case is a prototype."); }
     *
     * /**
     * Test of getCurrentSlide method, of class Projector.
     *
     * @Test public void testGetCurrentSlide() {
     * System.out.println("getCurrentSlide"); Projector instance = new
     * Projector(); SlideComponentInterface expResult = null;
     * SlideComponentInterface result = instance.getCurrentSlide();
     * assertEquals(expResult, result); // TODO review the generated test code
     * and remove the default call to fail. fail("The test case is a
     * prototype."); }
     *
     * /**
     * Test of getSlide method, of class Projector.
     *
     * @Test public void testGetSlide() { System.out.println("getSlide"); int
     * number = 0; Projector instance = new Projector(); SlideComponentInterface
     * expResult = null; SlideComponentInterface result =
     * instance.getSlide(number); assertEquals(expResult, result); // TODO
     * review the generated test code and remove the default call to fail.
     * fail("The test case is a prototype."); }
     */
}
