package infrastructure;

import domaincore.Level; 
import domainservices.SlideComposite;
import domainservices.SlideComponentInterface;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TxtFileProcessor extends FileProcessor {

    private SlideProcessor slideProcessor;
    private ArrayList<SlideComponentInterface> slidesArray;
    private SlideComponentInterface slideComposite;

    public TxtFileProcessor() {
        slideProcessor = new SlideProcessor();
        slidesArray = new ArrayList<>();
    }

    @Override
    public ArrayList<SlideComponentInterface> loadFile(String fileLocation) {
        return loadTxtFile(fileLocation);
    }

    @Override
    public void saveFile(String fileName) {
        // TODO Auto-generated method stub
    }

    private ArrayList<SlideComponentInterface> loadTxtFile(String filePath) {
        String fileContent = readLineByLine(filePath); 
        String[] arrOfStr = fileContent.split("\\r?\\n");
        int xasLevel = 10;
        int yasLevel = 0;
        slideComposite = null;
        
        for (String string : arrOfStr) {

            if (string.contains("<slide>:") == true) {
                if (slideComposite != null) {
                    // Add slide to the list
                    slidesArray.add(slideComposite);
                }
                // create a new object
                slideComposite = new SlideComposite();
                // reset the elements level
                yasLevel = 0;
            } else {
                //Add elememt to slideComposite
                slideComposite.add(slideProcessor.createSlideElements(string, new Level(xasLevel, yasLevel += 20)));
            }
        }
        //  when just one slideCOmposite is created
        if (slideComposite != null) {
            // Add slide to the list
            slidesArray.add(slideComposite);
        }
        //SlideHelpers.PrintMappedContentSlides(slidesComposite);
        return slidesArray;
    }

    private static String readLineByLine(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try ( Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
