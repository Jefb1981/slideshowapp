package infrastructure;

import domaincore.Level;
import domaincore.SlideHelpers;
import domainservices.Figure;
import domainservices.SlideComponentInterface;
import domainservices.Subtitle;
import domainservices.Text;
import domainservices.Title;
import java.awt.Color;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SlideProcessor {

    private static final String titleTag = "title";
    private static final String subTitleTag = "subtitle";
    private static final String levelTag = "level";
    private static final String level1Tag = "level1";
    private static final String level2Tag = "level2";
    private static final String level3Tag = "level3";
    private static final String level4Tag = "level4";
    private static final String figureTag = "figure";
    private static final String emptyString = "";

    public static String readLineByLineFileContent(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try ( Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return contentBuilder.toString();
    }

    public SlideComponentInterface createSlideElements(String data, Level elementLevel) {

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(titleTag))) {
            return new Title(Color.BLUE, data.replace(SlideHelpers.CreateTag(titleTag), emptyString), elementLevel);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(subTitleTag))) {
            return new Subtitle(Color.BLUE, data.replace(SlideHelpers.CreateTag(subTitleTag), emptyString), elementLevel);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(level1Tag))) {
            Level level = new Level(1, elementLevel.getX(), elementLevel.getY());

            return new Text(Color.BLUE, data.replace(SlideHelpers.CreateTag(level1Tag), emptyString), level);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(level2Tag))) {
            Level level = new Level(2, elementLevel.getX(), elementLevel.getY());
            return new Text(Color.BLUE, data.replace(SlideHelpers.CreateTag(level2Tag), emptyString), level);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(level3Tag))) {
            Level level = new Level(3, elementLevel.getX(), elementLevel.getY());
            return new Text(Color.BLUE, data.replace(SlideHelpers.CreateTag(level3Tag), emptyString), level);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(level4Tag))) {
            Level level = new Level(4, elementLevel.getX(), elementLevel.getY());
            return new Text(Color.BLUE, data.replace(SlideHelpers.CreateTag(level4Tag), emptyString), level);
        }

        if (SlideHelpers.isTagInString(data, SlideHelpers.CreateTag(figureTag))) {
            return new Figure(Color.BLUE, data.replace(SlideHelpers.CreateTag(figureTag), emptyString), elementLevel);
        }

        return new Title(Color.RED, "No Elements", elementLevel);
    }

    public byte[] GetDataFromSlideElement(SlideComponentInterface slideElement) {
        String stringContent = "";
        if (slideElement instanceof Title) {
            Title title = (Title) slideElement;
            stringContent = SlideHelpers.CreateTextLine(titleTag, title.getTitle());
        }

        if (slideElement instanceof Subtitle) {
            Subtitle subtitle = (Subtitle) slideElement;
            stringContent = SlideHelpers.CreateTextLine(subTitleTag, subtitle.getSubTitle());
        }

        if (slideElement instanceof Text) {
            Text text = (Text) slideElement;
            String newlevelTag = null;
            if (text.level.getLevel() != 0) {
                newlevelTag = levelTag.concat(Integer.toString(text.level.getLevel()));
            }
            stringContent = SlideHelpers.CreateTextLine(newlevelTag != null ? newlevelTag : levelTag, text.getText());
        }

        if (slideElement instanceof Figure) {
            Figure figure = (Figure) slideElement;
            stringContent = SlideHelpers.CreateTextLine(figureTag, figure.getUrl());
        }
        return stringContent.getBytes();
    }
}
