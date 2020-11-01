package domainservices;

import java.awt.*;

public interface SlideComponentInterface {

    int getX();

    int getY();
    
    int getSize();

    void select();

    void unSelect();

    boolean isSelected();

    void paint(Graphics graphics);

    void add(SlideComponentInterface slide);

    void clear();
}
