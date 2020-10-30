package domaincore;

import domaincore.SlideInternalDataModel;
import java.util.Map;

public final class SlideHelpers {

    public static void printDataObject(SlideInternalDataModel slideInfo) {
        System.out.println("*********** print Data Object *********");
        System.out.println("Value: " + slideInfo.getTitle());
        System.out.println("Value: " + slideInfo.getSubTitle());
        System.out.println("Value: " + slideInfo.getLevel1());
        System.out.println("Value: " + slideInfo.getLevel2());
        System.out.println("Value: " + slideInfo.getLevel3());
        System.out.println("Value: " + slideInfo.getLevel4());
        System.out.println("Value: " + slideInfo.getFigure());

    }

    public static void PrintMapContent(Map<String, SlideInternalDataModel> slides) {

        System.out.println("******** Print Map ********");
        System.out.println("******** Amount of Slides: " + slides.size());

        slides.forEach((k, v) -> {
            System.out.println("**********************");
            System.out.println("SLIDE: " + k);
            System.out.println("**********************");
            System.out.println("Title: " + v.getTitle());
            System.out.println("SubTitle: " + v.getSubTitle());
            System.out.println("Level1: " + v.getLevel1());
            System.out.println("Level2: " + v.getLevel2());
            System.out.println("Level3: " + v.getLevel3());
            System.out.println("Level4: " + v.getLevel4());
            System.out.println("Figure: " + v.getFigure());
        });
        System.out.println("******** End Print Map ********");
    }

}
