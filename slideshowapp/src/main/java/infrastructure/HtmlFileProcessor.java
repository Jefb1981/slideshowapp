package infrastructure;

import domaincore.FileOutputStreamWrapper;
import domaincore.FileWrapper;
import domaincore.HtmlElement;
import domaincore.HtmlProcessorHelpers;
import domaincore.SlideElements;
import domainservices.FileOutputStreamWrapperInterface;
import domainservices.FileWrapperInterface;
import domainservices.HtmlProcessorHelpersInterface;
import domainservices.SlideComponentInterface;
import domainservices.SlideComposite;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlFileProcessor extends FileProcessor {

    private final HtmlProcessorHelpersInterface htmlProcessorHelper;
    private final SlideProcessor slideProcessor;
    private final FileWrapperInterface fileWrapper;
    private final FileOutputStreamWrapperInterface fileOutputStream;

    public HtmlFileProcessor() {
        htmlProcessorHelper = new HtmlProcessorHelpers();
        slideProcessor = new SlideProcessor();
        fileWrapper = new FileWrapper();
        fileOutputStream = new FileOutputStreamWrapper();
    }

    @Override
    public ArrayList<SlideComponentInterface> loadFile(String filePath) {
        return loadHtmlFile(filePath);
    }

    @Override
    public void saveFile(String filePath, ArrayList<SlideComponentInterface> slides) {

        if (slides.size() > 0) {
            saveHtmlFile(slides, filePath);
        }
    }

    private void saveHtmlFile(ArrayList<SlideComponentInterface> slides, String filePath) {
        int slideCounter = 1;
        String filename = filePath.substring(0, filePath.lastIndexOf("."));
        for (SlideComponentInterface obj : slides) {
            if (slideCounter > 1) {
                filename = filename.concat(Integer.toString(slideCounter));
            }
            File htmlFile = fileWrapper.CreateTextFile(filename + ".html");
            FileOutputStream outputStream = fileOutputStream.CreateFileStream(htmlFile);
            
            if (obj instanceof SlideComposite) { 
                Document doc = Jsoup.parse("<html></html>");
                SlideComposite slideComposite = (SlideComposite) obj;
                List<SlideComponentInterface> slideElements = slideComposite.getAllSlideElements();
                for (int i = 0; i < slideElements.size(); i++) {
                    String strings = slideProcessor.GetHtmlDataFromSlideElement(slideElements.get(i));
                    if (!strings.isEmpty()) {
                        doc.body().append(strings);
                    }
                } 
                fileOutputStream.WriteContent(outputStream, doc.toString().getBytes());

            }
            slideCounter++;
            fileOutputStream.CloseOutputStream(outputStream);
        }

    }

    private ArrayList<SlideComponentInterface> loadHtmlFile(String filePath) {
        String delimiters = ";;\\s*|\\;; \\s*";
        String replacement = ";;";
        String regularExpression = "(?i)<br[^>]*>";
        String htmlContent = SlideProcessor.readLineByLineFileContent(filePath);
        Document htmlDocument = Jsoup.parse(htmlContent.replaceAll(regularExpression, replacement), "UTF-8");

        HtmlElement htmlElement = new HtmlElement();

        if (htmlProcessorHelper.isElementsByIdFound(htmlDocument, SlideElements.TITLE.getElement())) {
            htmlElement.setTitle(htmlProcessorHelper.getElementById(htmlDocument, SlideElements.TITLE.getElement()));
        }

        if (htmlProcessorHelper.isElementsByIdFound(htmlDocument, SlideElements.SUBTITLE.getElement())) {
            htmlElement.setSubtitle(htmlProcessorHelper.getElementById(htmlDocument, SlideElements.SUBTITLE.getElement()));
        }

        if (htmlProcessorHelper.isElementsByIdFound(htmlDocument, SlideElements.LEVEL1.getElement())) {
            htmlElement.setLevel1(htmlProcessorHelper.getElementById(htmlDocument, SlideElements.LEVEL1.getElement()).split(delimiters));
        }

        if (htmlProcessorHelper.isElementsByIdFound(htmlDocument, SlideElements.LEVEL2.getElement())) {
            htmlElement.setLevel2(htmlProcessorHelper.getElementById(htmlDocument, SlideElements.LEVEL2.getElement()).split(delimiters));
        }

        if (htmlProcessorHelper.isElementsByIdFound(htmlDocument, SlideElements.LEVEL3.getElement())) {
            htmlElement.setLevel3(htmlProcessorHelper.getElementById(htmlDocument, SlideElements.LEVEL3.getElement()).split(delimiters));
        }

        if (htmlProcessorHelper.isElementsByIdFound(htmlDocument, SlideElements.LEVEL4.getElement())) {
            htmlElement.setLevel4(htmlProcessorHelper.getElementById(htmlDocument, SlideElements.LEVEL4.getElement()).split(delimiters));
        }

        if (!htmlDocument.body().getElementsByTag("img").isEmpty()) {
            htmlElement.setImages(htmlDocument.body().getElementsByTag("img"));
        }

        return slideProcessor.CreateSlideCompositeArray(htmlElement);
    }

    // Todo remove method for test purpose
    @Override
    public String loadFileTest(String fileLocation) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
