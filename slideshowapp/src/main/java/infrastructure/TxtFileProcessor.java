package infrastructure;

import domaincore.Level;
import domainservices.SlideComposite;
import domainservices.SlideComponentInterface;
import java.util.ArrayList;

public class TxtFileProcessor extends FileProcessor {

    private final SlideProcessor slideProcessor;
    private final ArrayList<SlideComponentInterface> slidesArray;
    private SlideComponentInterface slideComposite;

    public TxtFileProcessor() {
        slideProcessor = new SlideProcessor();
        slidesArray = new ArrayList<>();
        slideComposite = new SlideComposite();
    }

    @Override
    public ArrayList<SlideComponentInterface> loadFile(String filePath) {
        return loadTxtFile(filePath);
    }

    @Override
    public void saveFile(String fileName) {
        // TODO Auto-generated method stub
    }

    private ArrayList<SlideComponentInterface> loadTxtFile(String filePath) {
        String txtContent = SlideProcessor.readLineByLineFileContent(filePath);
        String[] arrOfStr = txtContent.split("\\r?\\n");
        int xasLevel = 10;
        int yasLevel = 0;

        for (String string : arrOfStr) {
            if (string.contains("<slide>:") == true) {
                if (slideComposite.getSize() != 0) {
                    // Add slide to the list
                    slidesArray.add(slideComposite);
                }
                // create a new object
                slideComposite = new SlideComposite();
                // reset the elements level
                yasLevel = 0;
            } else {
                //Add elememt to slideComposite
                if (!string.isEmpty()) {
                    slideComposite.add(slideProcessor.createSlideElements(string, new Level(xasLevel, yasLevel += 20)));
                }
            }
        }
        //  when just one slideCOmposite is created
        if (slideComposite.getSize() != 0) {
            // Add slide to the list
            slidesArray.add(slideComposite);
        }
        //SlideHelpers.PrintMappedContentSlides(slidesComposite);
        return slidesArray;
    }
}
