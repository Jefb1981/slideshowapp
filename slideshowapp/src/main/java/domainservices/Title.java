package domainservices;

import domaincore.Level;
import java.awt.Color;
import java.awt.Graphics;

public class Title extends SlideComponent {

    private String title;

    public Title(Color color, String title, Level level) {
        super(color, title, level);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.BLUE);
        graphics.drawString(this.title, getX(), getY());
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

    @Override
    public SlideComponentInterface getSlide(int number) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
