package domainservices;

import domaincore.Level;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SlideComposite extends SlideComponent {

    protected List<SlideComponentInterface> children = new ArrayList<>();

    // Default constructor
    public SlideComposite() {
        super(Color.BLACK, "", new Level(0,0, 0));
    }

    public void add(SlideComponentInterface component) {
        children.add(component);
    }

    public void clear() {
        children.clear();
    }

    public SlideComponentInterface getSlide(int number) {
        return children.get(number);
    }

    public int getSize() {
        return children.size();
    }

    public List<SlideComponentInterface> getAllSlideElements() {
        return children;
    }

    @Override
    public void paint(Graphics graphics) {

        if (isSelected()) {
            enableSelectionStyle(graphics);
        }
        for (SlideComponentInterface child : children) {
            child.paint(graphics);
        }
    }
}
