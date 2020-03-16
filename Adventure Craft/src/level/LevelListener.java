package level;

import level.*;
import menu.*;
import java.util.*;
import java.awt.event.*;

public class LevelListener implements KeyListener, MouseListener, FocusListener {
    final int MAX_KEYCODE = 256;
    private Level level;
    private boolean[] keyHeld;

    public LevelListener(Level level) {
        this.level = level;
        keyHeld = new boolean[MAX_KEYCODE];
    }

    public boolean isKeyHeld(int keyCode) {
        return keyHeld[keyCode];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key typed: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyChar());

        // Record key being held down
        int code = e.getKeyCode();
        if (code < MAX_KEYCODE) keyHeld[code] = true;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                // Quit level
                level.unloadLevel();
                Menu menu = new Menu(level.getGameWindow());
                level.getGameWindow().switchScreen(menu);
                break;
            case KeyEvent.VK_R:
                // Restart level
                level.unloadLevel();
                level.loadLevel();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released: " + e.getKeyChar());

        // Record key being released
        int code = e.getKeyCode();
        if (code < MAX_KEYCODE) keyHeld[code] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked at " + e.getLocationOnScreen());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed at " + e.getLocationOnScreen());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released at " + e.getLocationOnScreen());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered at " + e.getLocationOnScreen());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited at " + e.getLocationOnScreen());
    }

    @Override
    public void focusGained(FocusEvent e) {
        System.out.println("Focus gained: " + e.getCause());
    }

    @Override
    public void focusLost(FocusEvent e) {
        System.out.println("Focus lost: " + e.getCause());
        Arrays.fill(keyHeld, false);
    }
}
