package infrastructure;

import domaincore.Level; 
import domainservices.Figure;
import domainservices.SlideComponentInterface; 
import domainservices.Subtitle;
import domainservices.Text;
import domainservices.Title;
import java.awt.Color; 

public class SlideProcessor {

    private static final String titleTag = "title";
    private static final String subTitleTag = "subtitle";
    private static final String level1Tag = "level1";
    private static final String level2Tag = "level2";
    private static final String level3Tag = "level3";
    private static final String level4Tag = "level4";
    private static final String figureTag = "figure";
    private static final String emptyString = "";

    public SlideComponentInterface createSlideElements(String data, Level elementLevel) {

        if (CheckTagTextLine(data, CreateTag(titleTag)) == true) {
            return new Title(Color.BLUE, data.replace(CreateTag(titleTag), emptyString), elementLevel);
        }

        if (CheckTagTextLine(data, CreateTag(subTitleTag)) == true) {
            return new Subtitle(Color.BLUE, data.replace(CreateTag(subTitleTag), emptyString), elementLevel);
        }

        if (CheckTagTextLine(data, CreateTag(level1Tag)) == true) {
            return new Text(Color.BLUE, data.replace(CreateTag(level1Tag), emptyString), elementLevel);
        }

        if (CheckTagTextLine(data, CreateTag(level2Tag)) == true) {
            return new Text(Color.BLUE, data.replace(CreateTag(level2Tag), emptyString), elementLevel);
        }

        if (CheckTagTextLine(data, CreateTag(level3Tag)) == true) {
            return new Text(Color.BLUE, data.replace(CreateTag(level3Tag), emptyString), elementLevel);
        }

        if (CheckTagTextLine(data, CreateTag(level4Tag)) == true) {
            return new Text(Color.BLUE, data.replace(CreateTag(level4Tag), emptyString), elementLevel);
        }

        if (CheckTagTextLine(data, CreateTag(figureTag)) == true) {
            return new Figure(Color.BLUE, data.replace(CreateTag(figureTag), emptyString), elementLevel);
        }
 
        return new Title(Color.RED, "No Elements", elementLevel);
    }

    private String CreateTag(String tag) {
        return "<" + tag + ">:";
    }

    private boolean CheckTagTextLine(String data, String tagToFind) {
        return data.contains(tagToFind);
    }
}
