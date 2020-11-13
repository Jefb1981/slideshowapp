package domainservices;

import domaincore.Level;
import java.awt.Color;
import java.awt.Graphics;

// This object is not a image as an figure that can be create with x , y and z coordinates
public class Figure extends SlideComponent {

    private String url;

    public Figure(Color color, String url, Level level) {
        super(color, url, level);
        this.url = url;
    }

    @Override
    public int getX() {
        return level.getX();
    }

    @Override
    public int getY() {
        return level.getY();
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.BLUE);
        graphics.drawString(this.url, getX(), getY());
    }

    @Override
    public void add(SlideComponentInterface slide) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SlideComponentInterface getSlide(int number) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
