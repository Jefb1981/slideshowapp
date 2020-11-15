package domainservices;

import domaincore.Level;
import java.awt.Color;
import java.awt.Graphics;

public class Text extends SlideComponent {

    private String text;

    public Text(Color color, String text, Level level) {
        super(color, text, level);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.BLUE);
        graphics.drawString(this.text, getX(), getY());
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
