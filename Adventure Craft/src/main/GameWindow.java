package main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import level.*;
import misc.Screen;

public class GameWindow extends Canvas {

    private Screen screen;
    private boolean running = true;

    GameWindow(int width, int height) {
        // Set size of the game window
        setSize(width, height);

        // For debug purposes
        Level level = new Level(this);
        level.loadLevel();
        screen = level;
    }

    public void switchScreen(Screen screen) {
        this.screen = screen;
    }

    public void tick() {
        screen.tick();
    }

    public void draw() {
        BufferStrategy strategy = getBufferStrategy();
        Graphics2D g2d = (Graphics2D) strategy.getDrawGraphics();

        // Render the current screen
        screen.draw(g2d);

        // Show the final image
        strategy.show();
    }

    public Screen getScreen() {
        return screen;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
