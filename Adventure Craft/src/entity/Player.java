package entity;

import level.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {
    private float speed;
    private boolean canMove;

    public Player(Level level) {
        super(level);
        speed = 3.5f;
        canMove = true;
    }

    @Override
    public void tick() {
        LevelListener levelListener = level.getLevelListener();
        if (levelListener.isKeyHeld(KeyEvent.VK_W)) {
            loc.move(0, -speed);
        }
        if (levelListener.isKeyHeld(KeyEvent.VK_S)) {
            loc.move(0, speed);
        }
        if (levelListener.isKeyHeld(KeyEvent.VK_A)) {
            loc.move(-speed, 0);
        }
        if (levelListener.isKeyHeld(KeyEvent.VK_D)) {
            loc.move(speed, 0);
        }
    }

    @Override
    public void draw(Graphics2D g2d, int x, int y) {
        g2d.setColor(Color.BLUE);
        g2d.fillOval(x, y, 50, 50);
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(x+15, y+15, 5, 5);
        g2d.fillRect(x+30, y+15, 5, 5);
        g2d.fillRoundRect(x+20, y+30, 10, 10, 3, 3);
    }
}
