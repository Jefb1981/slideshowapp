package domaincore;

/* it determinate the place of the elements on the screen*/
public class Level {

    private int x_as;
    private int y_as;
    private int level;

    public Level() {
    }

    public Level(int level,int x_as, int y_as) {
        this.x_as = x_as;
        this.y_as = y_as;
        this.level = level;
    }
    // Getter
    public int getLevel() {
        return level;
    }

    // Setter
    public void setLevel(int newLevel) {
        this.level = newLevel;
    }
    
    // Getter
    public int getX() {
        return x_as;
    }

    // Setter
    public void setX(int newX) {
        this.x_as = newX;
    }

    // Getter
    public int getY() {
        return y_as;
    }

    // Setter
    public void setY(int newY) {
        this.y_as = newY;
    }

}
