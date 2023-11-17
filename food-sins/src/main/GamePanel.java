package main;

import entity.Player;
import tile.TileManager;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
// java awt, api for developing gui

/*
GamePanel is the "game screen" so to speak. It contains...
- Screen settings
- FPS
- Game clock/loop
    - Paint and update
 */

public class GamePanel extends JPanel implements Runnable{
    // ----------------------- TILE SETTINGS -----------------------
    // 32x32 tiles
    final int originalTileSize = 32;
    // scale factor
    final int scale = 2;

    // the size that you'll see on screen - 64x tiles
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16; // n tiles wide
    final int maxScreenRow = 10; // n tiles tall

    final int screenWidth = tileSize * maxScreenCol; // 1920 pixels
    final int screenHeight = tileSize * maxScreenRow; // 1088 pixels.

    // ----------------------- FPS -----------------------
    int FPS = 32;

    // ----------------------- CONSTRUCTORS -----------------------
    TileManager tileM = new TileManager(this);
    // instantiating the key handler
    KeyHandler keyH = new KeyHandler();
    // creating the game clock
    Thread gameThread;
    // Allows for usage of key handler and game panel fom player.jav
    Player player = new Player(this,keyH);

    // ----------------------- GAME STATE -----------------------
    public  int gameState;
    public final int playState = 1;
    public final int pauseState = 2;


    // ----------------------- SCREEN SETUP -----------------------
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK );
        this.setDoubleBuffered(true); // improves rendering performance as drawing will be done in an offscreen painting buffer
        this.addKeyListener(keyH); // so that game panel can recognize key input
        this.setFocusable(true); // "focused" to receive input
    }


    // ----------------------- GAME THREAD -----------------------
    public void startGameThread()
    {
        gameThread = new Thread (this); // passing game panel to thread constructor, initiating the thread
        gameThread.start(); // will call the run method
    }

    // ----------------------- RUN METHOD -----------------------
    // when we start a game thread, this run method is called
    @Override // <--- just to say that we override the run() method from Runnable. we're using our own implementation.
    public void run()
    {
        // sleep method
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null)
        {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000)
            {
                drawCount = 0;
                timer = 0;
            }
        }
    }

    // ----------------------- UPDATE -----------------------
    public void update()
    { 
        player.update();
    }

    // ----------------------- PAINT -----------------------
    public void paintComponent(Graphics g)
    {
    /* paintComponent is a standard method to draw things on jpanel, Graphics is a class that
    has many functions to draw objects on the screen */

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        player.draw(g2);

        g2.dispose(); // disposes of graphic context & releases systems resources to save memory
    }

}
