package domainservices;

import domaincore.Level;
import java.awt.Color;
import java.awt.Graphics;
// this is not a image is a figure create with x , y and z coordinates
// what is a little limited form of images

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

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.BLUE);
        graphics.drawString(this.url, getX(), getY());
    }

    @Override
    public void add(SlideComponentInterface slide) {
        // TODO Auto-generated method stub

    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
