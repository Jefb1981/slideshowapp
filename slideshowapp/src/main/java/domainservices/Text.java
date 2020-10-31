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

    public void setText(String title) {
        this.title = title;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.BLUE);
        graphics.drawString(this.text, getX(), getY());
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
