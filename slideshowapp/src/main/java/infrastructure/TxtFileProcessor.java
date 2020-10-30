package infrastructure;

import domainservices.Figure;
import domainservices.Subtitle;
import domainservices.Title;
import domainservices.Text;
import domaincore.SlideInternalDataModel;
import domaincore.Level;
import domaincore.SlideHelpers;
import domainservices.SlideComposite;
import domainservices.SlideComponentInterface;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TxtFileProcessor extends FileProcessor {

    private Map<String, SlideInternalDataModel> slides;
    private Map<String, SlideComponentInterface> slidesNew;
    private SlideProcessor SlideProcessor;
    private InternalModelMapper dataMapper;

    public TxtFileProcessor() {
        slides = new HashMap<String, SlideInternalDataModel>();
        slidesNew =  new HashMap<String, SlideComponentInterface>();
        SlideProcessor = new SlideProcessor();
        dataMapper = new InternalModelMapper();
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
        String delimiters = "\\r?\\n";
        String[] arrOfStr = fileContent.split(delimiters);
        slides = new HashMap<String, SlideInternalDataModel>();

        int slideNumber = 1;
        SlideInternalDataModel slideData = null;
        SlideComponentInterface slideComponentInterface = null;

        for (String string : arrOfStr) {

            if (string.contains("<slide>:") == true) {
                if (slideData != null || slideComponentInterface != null) {
                    slides.put("slide_" + slideNumber, slideData);
                    slidesNew.put("slide_" + slideNumber,  null);
                    slideNumber++;
                }
                // create a new object
                slideData = new SlideInternalDataModel();
            } else {
                slideData = dataMapper.createInternalObject(string, slideData);
                slideComponentInterface = dataMapper.createArray(string);
            }
        }

        if (slideData != null) {
            slides.put("slide_" + slideNumber, slideData);
        }
//        System.out.println(fileContent);
//        SlideHelpers.printDataObject(slideData);
//        SlideHelpers.PrintMapContent(slides);

        return SlideProcessor.createSlides(slides);
    }

    private static String readLineByLine(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
