import javax.swing.*;
import java.awt.*;
// java awt, api for developing gui

public class GamePanel extends JPanel implements Runnable{

    // game panel works kind of like a game screen
    // SCREEN SETTINGS

    // 32x32 tiles
    final int originalTileSize = 32;
    // scale factor
    final int scale = 2;

    // the size that you'll see on screen - 64x tiles
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16; // n tiles wide
    final int maxScreenRow = 10; // n tiles tall

    final int screenWidth = tileSize * maxScreenCol; // 1920 pixels
    final int screenHeight = tileSize * maxScreenRow; // 1088 pixels.

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // improves rendering performance as drawing will be done in an offscreen painting buffer
    }

    // creating the game clock
    Thread gameThread;

    public void startGameThread() {
        gameThread = new Thread (this); // passing game panel to thread constructor, initiating the thread
        gameThread.start(); // will call the run method
    }

    @Override
    public void run() { // when we start a game thread, this run method is called
        // core game loop
        while (gameThread != null) {
            // 1 UPDATE : updating information such as character positions
            update();
            // 2 DRAW: drawing screen with the updated info
            repaint();
        }
    }

    public void update() { // to update information

    }

    public void paintComponent(Graphics g) {
    /* paintComponent is a standard method to draw things on jpanel, Graphics is a class that
    has many functions to draw objects on the screen */

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose(); // disposes of graphic context &   releases systems resources to save memory

    }

}
