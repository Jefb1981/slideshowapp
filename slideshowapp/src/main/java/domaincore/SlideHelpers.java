package domaincore;

import domainservices.SlideComponentInterface; 
import java.util.ArrayList;

public final class SlideHelpers {

    public static void printDataObject(SlideComponentInterface slideInfo) {
        System.out.println("*********** print Data Object *********");

    }

    public static void PrintMappedContentSlides(ArrayList<SlideComponentInterface> slides) {

        System.out.println("******** Print Map ********");
        System.out.println("******** Amount of Slides: " + slides.size());
        /* For Loop for iterating ArrayList */
        System.out.println("For Loop");
        for (int counter = 0; counter < slides.size(); counter++) {
            System.out.println(slides.get(counter));
        }

        System.out.println("******** End Print Map ********");
    }
}
