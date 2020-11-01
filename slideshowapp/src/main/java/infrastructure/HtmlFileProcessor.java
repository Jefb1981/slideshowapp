package infrastructure;

import domaincore.Level;
import domaincore.SlideHelpers;
import domainservices.Figure;
import domainservices.SlideComponentInterface;
import domainservices.SlideComposite;
import domainservices.Subtitle;
import domainservices.Text;
import domainservices.Title;
import java.awt.Color;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlFileProcessor extends FileProcessor {

    @Override
    public ArrayList<SlideComponentInterface> loadFile(String filePath) {
        return loadHtmlFile(filePath);
    }

    @Override
    public void saveFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private ArrayList<SlideComponentInterface> loadHtmlFile(String filePath) {

        // TODO: refactor make it more pretty
        String delimiters = ";;\\s*|\\;; \\s*";
        String replacement = ";;";
        String regularExpression = "(?i)<br[^>]*>";
        String htmlContent = SlideProcessor.readLineByLineFileContent(filePath);
        Document htmlDocument = Jsoup.parse(htmlContent.replaceAll(regularExpression, replacement), "UTF-8");
        String title = "";
        String subtitle = "";
        String[] level1 = null;
        String[] level2 = null;
        String[] level3 = null;
        String[] level4 = null;
        Elements images = null;

        if (checkElementsById(htmlDocument, "title")) {
            title = getElementById(htmlDocument, "title");
        }

        if (checkElementsById(htmlDocument, "subtitle")) {
            subtitle = getElementById(htmlDocument, "subtitle");
        }

        if (checkElementsById(htmlDocument, "level1")) {
            level1 = getElementById(htmlDocument, "level1").split(delimiters);
        }

        if (checkElementsById(htmlDocument, "level2")) {
            level2 = getElementById(htmlDocument, "level2").split(delimiters);
        }

        if (checkElementsById(htmlDocument, "level3")) {
            level3 = getElementById(htmlDocument, "level3").split(delimiters);
        }

        if (checkElementsById(htmlDocument, "level4")) {
            level4 = getElementById(htmlDocument, "level4").split(delimiters);
        }

        if (!htmlDocument.body().getElementsByTag("img").isEmpty()) {
            images = htmlDocument.body().getElementsByTag("img");
        }

        return CreateSlideArray(title, subtitle, level1, level2, level3, level4, images);
    }

    private boolean checkElementsById(Document htmlDocument, String tag) {
        // the Jsoup checks for empty or hastext are always returning false.
        // the jsoup library is not working correctly
        try {
            // if the tag is not found in th html body an exception will be raised and false will be returned
            String element = htmlDocument.body().getElementById(tag).text();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String getElementById(Document htmlDocument, String tag) { 
        return htmlDocument.body().getElementById(tag).text();
    }

    private ArrayList<SlideComponentInterface> CreateSlideArray(String title,
            String subtitle, String[] level1, String[] level2,
            String[] level3, String[] level4, Elements images) {

        ArrayList<SlideComponentInterface> slidesArray = new ArrayList<>();
        SlideComponentInterface slideComposite = new SlideComposite();
        int xasLevel = 10;
        int yasLevel = 0;

        if (!title.isEmpty()) {
            slideComposite.add(new Title(Color.BLUE, title, new Level(xasLevel, yasLevel += 20)));
        }

        if (!subtitle.isEmpty()) {
            slideComposite.add(new Subtitle(Color.BLUE, subtitle, new Level(xasLevel, yasLevel += 20)));
        }
        if (level1 != null && level1.length > 0) {
            for (String string : level1) {
                slideComposite.add(new Text(Color.BLUE, string, new Level(xasLevel, yasLevel += 20)));
            }
        }

        if (level2 != null && level2.length > 0) {
            for (String string : level2) {
                slideComposite.add(new Text(Color.BLUE, string, new Level(xasLevel, yasLevel += 20)));
            }
        }

        if (level3 != null && level3.length > 0) {
            for (String string : level3) {
                slideComposite.add(new Text(Color.BLUE, string, new Level(xasLevel, yasLevel += 20)));
            }
        }

        if (level4 != null && level4.length > 0) {
            for (String string : level4) {
                slideComposite.add(new Text(Color.BLUE, string, new Level(xasLevel, yasLevel += 20)));
            }
        }

        if (images != null && !images.isEmpty()) {
            for (Element string : images) {
                slideComposite.add(new Figure(Color.BLUE, string.absUrl("src"), new Level(xasLevel, yasLevel += 20)));
            }
        }

        if (slideComposite == null || slideComposite.getSize() == 0) {
            slideComposite.add(new Text(Color.RED, "The loaded document is empty or has not correct elements", new Level(10, 20)));
        }

        slidesArray.add(slideComposite);
        return slidesArray;
    }

}
