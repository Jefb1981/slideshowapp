package infrastructure;

import domaincore.HtmlElement;
import domaincore.Level;
import domaincore.SlideElements;
import domaincore.SlideHelpers;
import domainservices.Figure;
import domainservices.SlideComponentInterface;
import domainservices.SlideComposite;
import domainservices.Subtitle;
import domainservices.Text;
import domainservices.Title;
import java.awt.Color;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.jsoup.nodes.Element;

public class SlideProcessor implements SlideProcessorInterface {

    public String readLineByLineFileContent(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try ( Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return contentBuilder.toString();
    }

    @Override
    public SlideComponentInterface createSlideElements(String data, Level elementLevel) {
        String emptyString = "";
        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(SlideElements.TITLE.getElement()))) {
            return new Title(Color.BLUE, data.replace(SlideHelpers.CreateTag(SlideElements.TITLE.getElement()), emptyString), elementLevel);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(SlideElements.SUBTITLE.getElement()))) {
            return new Subtitle(Color.BLUE, data.replace(SlideHelpers.CreateTag(SlideElements.SUBTITLE.getElement()), emptyString), elementLevel);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(SlideElements.LEVEL1.getElement()))) {
            Level level = new Level(1, elementLevel.getX(), elementLevel.getY());

            return new Text(Color.BLUE, data.replace(SlideHelpers.CreateTag(SlideElements.LEVEL1.getElement()), emptyString), level);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(SlideElements.LEVEL2.getElement()))) {
            Level level = new Level(2, elementLevel.getX(), elementLevel.getY());
            return new Text(Color.BLUE, data.replace(SlideHelpers.CreateTag(SlideElements.LEVEL2.getElement()), emptyString), level);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(SlideElements.LEVEL3.getElement()))) {
            Level level = new Level(3, elementLevel.getX(), elementLevel.getY());
            return new Text(Color.BLUE, data.replace(SlideHelpers.CreateTag(SlideElements.LEVEL3.getElement()), emptyString), level);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(SlideElements.LEVEL4.getElement()))) {
            Level level = new Level(4, elementLevel.getX(), elementLevel.getY());
            return new Text(Color.BLUE, data.replace(SlideHelpers.CreateTag(SlideElements.LEVEL4.getElement()), emptyString), level);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(SlideElements.FIGURE.getElement()))) {
            return new Figure(Color.BLUE, data.replace(SlideHelpers.CreateTag(SlideElements.FIGURE.getElement()), emptyString), elementLevel);
        }

        return new Title(Color.RED, "No Elements", elementLevel);
    }

    public byte[] GetTxtDataFromSlideElement(SlideComponentInterface slideElement) {
        String stringContent = "";
        if (slideElement instanceof Title) {
            Title title = (Title) slideElement;
            stringContent = SlideHelpers.CreateTextLine(SlideElements.TITLE.getElement(), title.getTitle());
        }

        if (slideElement instanceof Subtitle) {
            Subtitle subtitle = (Subtitle) slideElement;
            stringContent = SlideHelpers.CreateTextLine(SlideElements.SUBTITLE.getElement(), subtitle.getSubTitle());
        }

        if (slideElement instanceof Text) {
            Text text = (Text) slideElement;
            String newlevelTag = null;
            if (text.level.getLevel() != 0) {
                newlevelTag = SlideElements.LEVEL.getElement().concat(Integer.toString(text.level.getLevel()));
            }
            stringContent = SlideHelpers.CreateTextLine(newlevelTag != null ? newlevelTag : SlideElements.LEVEL.getElement(), text.getText());
        }

        if (slideElement instanceof Figure) {
            Figure figure = (Figure) slideElement;
            stringContent = SlideHelpers.CreateTextLine(SlideElements.FIGURE.getElement(), figure.getUrl());
        }
        return stringContent.getBytes();
    }

    public String GetHtmlDataFromSlideElement(SlideComponentInterface slideElement) {

        String stringContent = "";
        if (slideElement instanceof Title) {
            Title title = (Title) slideElement;
            String newString = title.getTitle().replace("<title>:", "");
            return "<p id= 'title'>" + newString + "</p>";
        }

        if (slideElement instanceof Subtitle) {
            Subtitle subtitle = (Subtitle) slideElement;
            String newString = subtitle.getSubTitle().replace("<subtitle>:", "");
            return "<p id= 'subtitle'>" + newString + "</p>";
        }

        if (slideElement instanceof Text) {
            Text text = (Text) slideElement;
            String newlevelTag = null;

            if (text.level.getLevel() != 0) {
                newlevelTag = SlideElements.LEVEL.getElement().concat(Integer.toString(text.level.getLevel()));
            }

            return "<p id='" + newlevelTag + "'>" + text.getText() + "</p>";
        }

        if (slideElement instanceof Figure) {
            Figure figure = (Figure) slideElement;
            stringContent = SlideHelpers.CreateTextLine(SlideElements.FIGURE.getElement(), figure.getUrl());
            return "<img src=\"" + figure.getUrl() + "\">";
        }
        return stringContent;
    }

    public ArrayList<SlideComponentInterface> CreateSlideCompositeArray(HtmlElement htmlElement) {

        ArrayList<SlideComponentInterface> slidesArray = new ArrayList<>();
        SlideComponentInterface slideComposite = new SlideComposite();
        int xasLevel = 10;
        int yasLevel = 0;

        if (!htmlElement.getTitle().isEmpty()) {
            slideComposite.add(new Title(Color.BLUE, htmlElement.getTitle(), new Level(0, xasLevel, yasLevel += 20)));
        }

        if (!htmlElement.getSubtitle().isEmpty()) {
            slideComposite.add(new Subtitle(Color.BLUE, htmlElement.getSubtitle(), new Level(0, xasLevel, yasLevel += 20)));
        }

        if (htmlElement.getLevel1() != null && htmlElement.getLevel1().length > 0) {
            for (String string : htmlElement.getLevel1()) {
                slideComposite.add(new Text(Color.BLUE, string, new Level(1, xasLevel, yasLevel += 20)));
            }
        }

        if (htmlElement.getLevel2() != null && htmlElement.getLevel2().length > 0) {
            for (String string : htmlElement.getLevel2()) {
                slideComposite.add(new Text(Color.BLUE, string, new Level(2, xasLevel, yasLevel += 20)));
            }
        }

        if (htmlElement.getLevel3() != null && htmlElement.getLevel3().length > 0) {
            for (String string : htmlElement.getLevel3()) {
                slideComposite.add(new Text(Color.BLUE, string, new Level(3, xasLevel, yasLevel += 20)));
            }
        }

        if (htmlElement.getLevel4() != null && htmlElement.getLevel4().length > 0) {
            for (String string : htmlElement.getLevel4()) {
                slideComposite.add(new Text(Color.BLUE, string, new Level(4, xasLevel, yasLevel += 20)));
            }
        }

        if (htmlElement.getImages() != null && !htmlElement.getImages().isEmpty()) {
            for (Element string : htmlElement.getImages()) {
                slideComposite.add(new Figure(Color.BLUE, string.absUrl("src"), new Level(0, xasLevel, yasLevel += 20)));
            }
        }

        if (slideComposite == null || slideComposite.getSize() == 0) {
            slideComposite.add(new Text(Color.RED, "The loaded document is empty or has not correct elements", new Level(1, 10, 20)));
        }

        slidesArray.add(slideComposite);
        return slidesArray;
    }
}
