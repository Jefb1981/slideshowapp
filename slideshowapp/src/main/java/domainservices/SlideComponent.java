package domainservices;

import domaincore.Level;
import domainservices.SlideComponentInterface;
import java.awt.*;

abstract class SlideComponent implements SlideComponentInterface {

    public Color color;
    private boolean selected = false;
    public Level level;
    public String title;

    public SlideComponent(Color color, String title, Level level) {
        this.color = color;
        this.title = title;
        this.level = level;
    }

    public String getTitle() {
        return null;
    }

    public int getX() {
        return level.getX();
    }

    public int getY() {
        return level.getY();
    }

    public void select() {
        selected = true;
    }

    public void unSelect() {
        selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    void enableSelectionStyle(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);

        Graphics2D g2 = (Graphics2D) graphics;
        float dash1[] = {2.0f};
        g2.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
    }

    void disableSelectionStyle(Graphics graphics) {
        graphics.setColor(color);
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke());
    }

    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
        } else {
            disableSelectionStyle(graphics);
        }
    }
//	@Override
//	public void appendSlideItem(SlideItem anItem) {
//		// TODO Auto-generated method stub
//		
//	}

}
