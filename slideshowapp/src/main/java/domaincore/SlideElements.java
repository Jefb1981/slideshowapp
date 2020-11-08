package domaincore;
 
public enum SlideElements {
    TITLE("title"),
    SUBTITLE("subtitle"),
    LEVEL("level"),
    LEVEL1("level1"),
    LEVEL2("level2"),
    LEVEL3("level3"),
    LEVEL4("level4"),
    FIGURE("figure");

    private String element;

    SlideElements(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }
}
