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

        String title = htmlDocument.body().getElementById("title").text();
        String subtitle = htmlDocument.body().getElementById("subtitle").text();
        String[] level1 = htmlDocument.body().getElementById("level1").text().split(delimiters);
        String[] level2 = htmlDocument.body().getElementById("level2").text().split(delimiters);
        String[] level3 = htmlDocument.body().getElementById("level3").text().split(delimiters);
        String[] level4 = htmlDocument.body().getElementById("level4").text().split(delimiters);
        Elements images = htmlDocument.body().getElementsByTag("img");

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

        for (String string : level1) {
            slideComposite.add(new Text(Color.BLUE, string, new Level(xasLevel, yasLevel += 20)));
        }

        for (String string : level2) {
            slideComposite.add(new Text(Color.BLUE, string, new Level(xasLevel, yasLevel += 20)));
        }

        for (String string : level3) {
            slideComposite.add(new Text(Color.BLUE, string, new Level(xasLevel, yasLevel += 20)));
        }

        for (String string : level4) {
            slideComposite.add(new Text(Color.BLUE, string, new Level(xasLevel, yasLevel += 20)));
        }

        for (Element string : images) { 
            slideComposite.add(new Figure(Color.BLUE, string.absUrl("src"), new Level(xasLevel, yasLevel += 20)));
        }
        
        slidesArray.add(slideComposite);
        return slidesArray;
    }

}
