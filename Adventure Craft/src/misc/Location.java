package misc;

public class Location {
    protected int x, y;
    protected float fx, fy;

    public Location() {
        this(0, 0);
    }

    public Location(float fx, float fy) {
        this.fx = fx;
        this.fy = fy;
        updateLocation();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLocation(float fx, float fy) {
        this.fx = fx;
        this.fy = fy;
        updateLocation();
    }

    public void move(float dx, float dy) {
        fx += dx;
        fy += dy;
        updateLocation();
    }

    protected void updateLocation() {
        x = Math.round(fx);
        y = Math.round(fy);
    }
}
