package domaincore;

import org.jsoup.select.Elements;

public class HtmlElement {

    private String title = "";
    private String subtitle = "";
    private String[] level1 = null;
    private String[] level2 = null;
    private String[] level3 = null;
    private String[] level4 = null;
    private Elements images = null;

    // Constructor
    public HtmlElement() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setLevel1(String[] level1) {
        this.level1 = level1;
    }

    public void setLevel2(String[] level2) {
        this.level2 = level2;
    }

    public void setLevel3(String[] level3) {
        this.level3 = level3;
    }

    public void setLevel4(String[] level4) {
        this.level4 = level4;
    }

    public void setImages(Elements images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String[] getLevel1() {
        return level1;
    }

    public String[] getLevel2() {
        return level2;
    }

    public String[] getLevel3() {
        return level3;
    }

    public String[] getLevel4() {
        return level4;
    }

    public Elements getImages() {
        return images;
    }

    
}
