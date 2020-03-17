package main;

import javax.swing.*;

public class Main {
    private static final int WIDTH = 1080;
    private static final int HEIGHT = 720;
    private static final int FPS = 60, DRAW_FPS = 120;

    public static void main(String[] args) {
        // Intiialize the main game frame
        JFrame frame = new JFrame("Adventure Craft");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        GameWindow gameWindow = new GameWindow(WIDTH, HEIGHT);
        frame.add(gameWindow);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        gameWindow.createBufferStrategy(3);

        // Main game loop
        long lastTime = System.nanoTime(), currTime;
        long nsElapsedFrame = 0, nsElapsedDraw = 0;
        long nsPerFrame = 1_000_000_000 / FPS;
        long nsPerDraw = 1_000_000_000 / DRAW_FPS;
        frame.toFront();
        frame.requestFocus();
        while (gameWindow.isRunning()) {
            // Update tracked times
            currTime = System.nanoTime();
            nsElapsedFrame += currTime - lastTime;
            nsElapsedDraw += currTime - lastTime;
            lastTime = currTime;

            while (nsElapsedFrame >= nsPerFrame) {
                // Time for a new frame!
                gameWindow.tick();
                nsElapsedFrame -= nsPerFrame;
            }

            while (nsElapsedDraw >= nsPerDraw) {
                // Time to redraw the screen!
                gameWindow.draw();
                nsElapsedDraw -= nsPerDraw;
            }
        }

        // Close the window
        frame.setVisible(false);
        frame.dispose();
    }
}
