package infrastructure;

import domaincore.FileOutputStreamWrapper;
import domaincore.FileWrapper;
import domaincore.Level;
import domainservices.FileOutputStreamWrapperInterface;
import domainservices.FileWrapperInterface;
import domainservices.SlideComposite;
import domainservices.SlideComponentInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TxtFileProcessor extends FileProcessor {

    private SlideProcessorInterface slideProcessor;
    private final ArrayList<SlideComponentInterface> slidesArray;
    private SlideComponentInterface slideComposite;
    private final FileWrapperInterface fileWrapper;
    private final FileOutputStreamWrapperInterface fileOutputStream;

    public TxtFileProcessor() {
        slideProcessor = new SlideProcessor();
        slidesArray = new ArrayList<>();
        slideComposite = new SlideComposite();
        fileWrapper = new FileWrapper();
        fileOutputStream = new FileOutputStreamWrapper();
    }

    // overloaded constructor 
    public TxtFileProcessor(SlideProcessorInterface slideProcessor,
            SlideComponentInterface slideComponentInterface,
            FileWrapperInterface fileWrapperInterface,
            FileOutputStreamWrapperInterface fileOutputStreamWrapperInterface
    ) {
        this.slideProcessor = slideProcessor;
        this.slidesArray = new ArrayList<>();
        this.slideComposite = slideComponentInterface;
        this.fileWrapper = fileWrapperInterface;
        this.fileOutputStream = fileOutputStreamWrapperInterface;
    }

    @Override
    public ArrayList<SlideComponentInterface> loadFile(String filePath) {
        return loadTxtFile(filePath);
    }

    @Override
    public void saveFile(String filePath, ArrayList<SlideComponentInterface> slides) {
        File txtFile = fileWrapper.CreateTextFile(filePath);
        FileOutputStream outputStream = fileOutputStream.CreateFileStream(txtFile);

        if (slides.size() > 0 && txtFile != null && outputStream != null) {
            saveTxtFile(slides, outputStream);
        }
    }

    private void saveTxtFile(ArrayList<SlideComponentInterface> slides, FileOutputStream outputStream) {

        for (SlideComponentInterface obj : slides) {
            String slideText = "<slide>: \r\n";
            fileOutputStream.WriteContent(outputStream, slideText.getBytes());
            if (obj instanceof SlideComposite) {
                SlideComposite slideComposite = (SlideComposite) obj;
                List<SlideComponentInterface> slideElements = slideComposite.getAllSlideElements();
                for (int i = 0; i < slideElements.size(); i++) {
                    byte[] slideElementString = slideProcessor.GetTxtDataFromSlideElement(slideElements.get(i));
                    fileOutputStream.WriteContent(outputStream, slideElementString);
                }
            }
        }
        fileOutputStream.CloseOutputStream(outputStream);
    }

    private ArrayList<SlideComponentInterface> loadTxtFile(String filePath) {
        String txtContent = slideProcessor.readLineByLineFileContent(filePath);
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
                    slideComposite.add(slideProcessor.createSlideElements(string, new Level(0, xasLevel, yasLevel += 20)));
                }
            }
        }
        //  when just one slideComposite is created
        if (slideComposite.getSize() != 0) {
            // Add slide to the list
            slidesArray.add(slideComposite);
        }

        return slidesArray;
    }
}
