package userinterface;

import domainservices.SlideComponentInterface;
import domainservices.Title;
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
        assertTrue(projector.getSlideComposite().getSize()==1);
        
    }

    /**
     * Test of loadShapes method, of class Projector.
     
    @Test
    public void testLoadShapes() {
        System.out.println("loadShapes");
        SlideComponentInterface shapes = null;
        Projector instance = new Projector();
        instance.loadShapes(shapes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextSlide method, of class Projector.
     
    @Test
    public void testNextSlide() {
        System.out.println("nextSlide");
        Projector instance = new Projector();
        instance.nextSlide();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prevSlide method, of class Projector.
     
    @Test
    public void testPrevSlide() {
        System.out.println("prevSlide");
        Projector instance = new Projector();
        instance.prevSlide();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentSlideNumber method, of class Projector.
     
    @Test
    public void testSetCurrentSlideNumber() {
        System.out.println("setCurrentSlideNumber");
        int number = 0;
        Projector instance = new Projector();
        instance.setCurrentSlideNumber(number);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentSlide method, of class Projector.
     
    @Test
    public void testGetCurrentSlide() {
        System.out.println("getCurrentSlide");
        Projector instance = new Projector();
        SlideComponentInterface expResult = null;
        SlideComponentInterface result = instance.getCurrentSlide();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSlide method, of class Projector.
     
    @Test
    public void testGetSlide() {
        System.out.println("getSlide");
        int number = 0;
        Projector instance = new Projector();
        SlideComponentInterface expResult = null;
        SlideComponentInterface result = instance.getSlide(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
