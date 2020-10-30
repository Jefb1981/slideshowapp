package infrastructure;

import domaincore.Level;
import domaincore.SlideInternalDataModel;
import domainservices.Figure;
import domainservices.SlideComponentInterface;
import domainservices.SlideComposite;
import domainservices.Subtitle;
import domainservices.Text;
import domainservices.Title;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SlideProcessor {

    private ArrayList<SlideComponentInterface> slidesComponentsList;
    private Map<String, SlideInternalDataModel> sortedMap;

    public ArrayList<SlideComponentInterface> createSlides(Map<String, SlideInternalDataModel> data) {
        SlideComponentInterface slide;
        int x_as = 20;
        slidesComponentsList = new ArrayList<>();
        // TreeMap is only  used to sort the elements by the Key
        sortedMap = new TreeMap<String, SlideInternalDataModel>(data);

        for (Map.Entry<String, SlideInternalDataModel> entry : sortedMap.entrySet()) {
            slide = new SlideComposite();

            if (entry.getValue().getTitle() != null) { 
                slide.add(new Title(Color.BLUE, entry.getValue().getTitle(), new Level(10, x_as += 20)));
            }

            if (entry.getValue().getSubTitle() != null) {
                slide.add(new Subtitle(Color.BLUE, entry.getValue().getSubTitle(), new Level(10, x_as += 20)));
            }
            if (entry.getValue().getLevel1() != null) {
                slide.add(new Text(Color.BLUE, entry.getValue().getLevel1(), new Level(10, x_as += 20)));
            }
            if (entry.getValue().getLevel2() != null) {
                for (String s : SplitTextLine(entry.getValue().getLevel2())) {
                    if (!s.isEmpty()) {
                        slide.add(new Text(Color.BLUE, s, new Level(10, x_as += 20)));
                    }
                }
            }
            if (entry.getValue().getLevel3() != null) {
                for (String s : SplitTextLine(entry.getValue().getLevel3())) {
                    slide.add(new Text(Color.BLUE, s, new Level(10, x_as += 20)));
                }
            }

            if (entry.getValue().getLevel4() != null) {
                slide.add(new Text(Color.BLUE, entry.getValue().getLevel4(), new Level(10, x_as += 20)));
            }

            if (entry.getValue().getFigure() != null) {
                slide.add(new Figure(Color.RED, entry.getValue().getFigure(), new Level(10, x_as += 20)));
            }

            slidesComponentsList.add(slide);
            x_as = 20;
        }

        return slidesComponentsList;
    }

    private String[] SplitTextLine(String text) {
        String delimiters = " ;\\s*|\\; \\s*";
        String[] arrOfStr = text.split(delimiters);
        return arrOfStr;
    }
}
