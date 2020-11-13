package domainservices;

import domaincore.Level;
import java.awt.Color;
import java.awt.Graphics;

public class Subtitle extends SlideComponent {

    private String subtitle;

    public Subtitle(Color color, String subtitle, Level level) {
        super(color, subtitle, level);
        this.subtitle = subtitle;
    }

    public void setSubTitle(String title) {
        this.subtitle = subtitle;
    }

    public String getSubTitle() {
        return subtitle;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.BLUE);
        graphics.drawString(this.subtitle, getX(), getY());
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
