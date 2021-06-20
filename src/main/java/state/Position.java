package state;

import java.util.Objects;

public class Position implements Cloneable {

    private int x;
    private int y;
    private Orientation orientation;

    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    public void decrementX() {
        x--;
    }

    public void decrementY() {
        y--;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", x, y, orientation);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Position clone()  {
        return new Position(x, y, orientation);
    }

}
