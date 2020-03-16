package menu;

import main.GameWindow;
import misc.*;

import java.awt.*;

public class Menu implements Screen {
    private GameWindow gameWindow;

    public Menu(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.MAGENTA);
        g2d.fillRect(0, 0, gameWindow.getWidth(), gameWindow.getHeight());
    }
}
