package domainservices;

import domaincore.Level;
import domaincore.Level;
import domainservices.SlideComponent;
import domainservices.SlideComponentInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Subtitle extends SlideComponent {

    private String subtitle;

    public Subtitle(Color color, String subtitle, Level level) {
        super(color, subtitle, level);
        this.subtitle = subtitle;
    }

    public void setSubTitle(String title) {
        this.title = subtitle;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.BLUE);
        graphics.drawString(this.subtitle, getX(), getY());
    }

    @Override
    public void add(SlideComponentInterface slide) {
        // TODO Auto-generated method stub

    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }
}
