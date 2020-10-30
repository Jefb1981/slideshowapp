package infrastructure;

import domaincore.Level;
import domaincore.SlideInternalDataModel;
import domainservices.SlideComponentInterface;
import domainservices.Title;
import java.awt.Color;

public class InternalModelMapper {

    private static final String titleTag = "title";
    private static final String subTitleTag = "subtitle";
    private static final String level1Tag = "level1";
    private static final String level2Tag = "level2";
    private static final String level3Tag = "level3";
    private static final String level4Tag = "level4";
    private static final String figureTag = "figure";
    private static final String emptyString = "";

    public SlideInternalDataModel createInternalObject(String data, SlideInternalDataModel slide) {
        String levelText = "";

        if (CheckTagTextLine(data, CreateTag(titleTag)) == true) {
            slide.setTitle(data.replace(CreateTag(titleTag), emptyString));
        }
        if (CheckTagTextLine(data, CreateTag(subTitleTag)) == true) {
            slide.setSubTitle(data.replace(CreateTag(subTitleTag), emptyString));
        }
        if (CheckTagTextLine(data, CreateTag(level1Tag)) == true) {
            levelText = data.replace(CreateTag(level1Tag), emptyString);
            if (slide.getLevel1() != null) {
                levelText = slide.getLevel1() + ";" + levelText;
            }

            slide.setLevel1(levelText);
        }
        if (CheckTagTextLine(data, CreateTag(level2Tag)) == true) {
            levelText = data.replace(CreateTag(level2Tag), emptyString);
            if (slide.getLevel2() != null) {
                levelText = slide.getLevel2() + " ; " + levelText;
            }

            slide.setLevel2(levelText);
        }
        if (CheckTagTextLine(data, CreateTag(level3Tag)) == true) {
            levelText = data.replace(CreateTag(level3Tag), emptyString);
            if (slide.getLevel3() != null) {
                levelText = slide.getLevel3() + " ; " + levelText;
            }

            slide.setLevel3(levelText);
        }
        if (CheckTagTextLine(data, CreateTag(level4Tag)) == true) {
            levelText = data.replace(CreateTag(level4Tag), emptyString);
            if (slide.getLevel4() != null) {
                levelText = slide.getLevel4() + " ; " + levelText;
            }

            slide.setLevel4(levelText);
        }
        if (CheckTagTextLine(data, CreateTag(figureTag)) == true) {
            slide.setFigure(data.replace(CreateTag(figureTag), emptyString));
        }
        return slide;
    }

    public String CreateTag(String tag) {
        return "<" + tag + ">:";
    }

    public boolean CheckTagTextLine(String data, String tagToFind) {
        return data.contains(tagToFind);
    }

    public SlideComponentInterface createArray(String data) {
        String levelText = "";

        if (CheckTagTextLine(data, CreateTag(titleTag)) == true) {
            //
            return new Title(Color.BLUE, data, new Level(10, 20));
        }
       
        return  null;
    }

}
