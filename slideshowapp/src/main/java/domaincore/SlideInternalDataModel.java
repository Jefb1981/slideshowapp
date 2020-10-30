package domaincore;

public class SlideInternalDataModel {

    private int slideNumber;
    private String title;
    private String subTitle;
    private String level1;
    private String level2;
    private String level3;
    private String level4;
    private String figure;

    // Getter
    public int getSlideNumber() {
        return slideNumber;
    }

    // Setter
    public void setSlideNumber(int newSlideNumber) {
        this.slideNumber = newSlideNumber;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    // Setter
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    // Getter
    public String getSubTitle() {
        return subTitle;
    }

    // Setter
    public void setSubTitle(String newSubTitle) {
        this.subTitle = newSubTitle;
    }
    // Getter

    public String getLevel1() {
        return level1;
    }

    // Setter
    public void setLevel1(String newLevel) {
        this.level1 = newLevel;
    }
    // Getter

    public String getLevel2() {
        return level2;
    }

    // Setter
    public void setLevel2(String newLevel) {
        this.level2 = newLevel;
    }
    // Getter

    public String getLevel3() {
        return level3;
    }

    // Setter
    public void setLevel3(String newLevel) {
        this.level3 = newLevel;
    }

    public String getLevel4() {
        return level4;
    }

    // Setter
    public void setLevel4(String newLevel) {
        this.level4 = newLevel;
    }

    public String getFigure() {
        return figure;
    }

    // Setter
    public void setFigure(String newFigure) {
        this.figure = newFigure;
    }
}
