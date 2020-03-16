package level;

import entity.*;
import main.*;
import misc.Screen;

import java.awt.*;
import java.util.ArrayList;

public class Level implements Screen {
    private GameWindow gameWindow;
    private Camera camera;
    private Player player;
    private ArrayList<Entity> entities;

    private LevelListener levelListener;

    public Level(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public void tick() {
        for (Entity entity : entities) entity.tick();
    }

    public void draw(Graphics2D g2d) {
        // Clear the screen
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, gameWindow.getWidth(), gameWindow.getHeight());

        // Enable antialiasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Render all entities
        for (Entity entity : entities) entity.draw(g2d);
    }

    public void loadLevel() {
        // Add listeners
        levelListener = new LevelListener(this);
        gameWindow.addKeyListener(levelListener);
        gameWindow.addMouseListener(levelListener);
        gameWindow.addFocusListener(levelListener);

        // Initialize camera
        camera = new Camera();
        camera.getLoc().setLocation(0, 0);
        camera.setZoom(1.0);

        // Initialize player
        player = new Player(this);
        player.getLoc().setLocation(100, 200);
        entities = new ArrayList<>();
        addEntity(player);
    }

    public void unloadLevel() {
        gameWindow.removeKeyListener(levelListener);
        gameWindow.removeMouseListener(levelListener);
        gameWindow.removeFocusListener(levelListener);
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public Camera getCamera() {
        return camera;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public LevelListener getLevelListener() {
        return levelListener;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }
}
