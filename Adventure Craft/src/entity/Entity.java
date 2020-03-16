package entity;

import java.awt.*;

import level.*;
import main.*;
import misc.*;

public abstract class Entity {
    protected Level level;
    protected Location loc;
    protected boolean offsetIgnored;

    public Entity(Level level) {
        this.level = level;
        loc = new Location();
        offsetIgnored = false;
    }

    public abstract void tick();

    public abstract void draw(Graphics2D g2d, int x, int y);

    public void draw(Graphics2D g2d) {
        if (offsetIgnored) draw(g2d, loc.getX(), loc.getY());
        else {
            Location cameraLoc = level.getCamera().getLoc();
            int x = loc.getX() - cameraLoc.getX();
            int y = loc.getY() - cameraLoc.getY();
            draw(g2d, x, y);
        }
    }

    public Location getLoc() {
        return loc;
    }

    public boolean isOffsetIgnored() {
        return offsetIgnored;
    }
}
