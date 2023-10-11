package main;

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

    // instantiating the key handler
    KeyHandler keyH = new KeyHandler();
    // creating the game clock
    Thread gameThread;

    // FPS
    int FPS = 32;

    // setting the player's default position, where does the player spawn?
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    // screen setup
    public GamePanel() 
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // improves rendering performance as drawing will be done in an offscreen painting buffer
        this.addKeyListener(keyH); // so that game panel can recognize key input
        this.setFocusable(true); // "focused" to receive input
    }

    // game thread
    public void startGameThread() 
    {
        gameThread = new Thread (this); // passing game panel to thread constructor, initiating the thread
        gameThread.start(); // will call the run method
    }

    // when we start a game thread, this run method is called
    @Override
    public void run() {

        // sleep method
        double drawInterval = (double) 1000000000 / FPS; // draw the screen this amount of times per second
        double nextDrawTime = System.nanoTime() + drawInterval; // next draw time will be hte current time plus
                                                                // draw interval seconds later

        // core game loop
        while (gameThread != null)
        {
            // 1 UPDATE : updating information such as character positions
            update();
            // 2 DRAW: drawing screen with the updated info
            repaint();

            try 
            {
                double remainingTime = nextDrawTime - System.nanoTime(); // document this later
                remainingTime = remainingTime/1000000;

                if (remainingTime< 0)
                {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } 
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public void update() 
    { // to update information

        // player movement
        if(keyH.upPressed){ // shorthand for keyH.upPressed being true
            playerY -= playerSpeed;
        }
        if(keyH.leftPressed){
            playerX -= playerSpeed;
        }
        if(keyH.downPressed){
            playerY += playerSpeed;
        }
        if(keyH.rightPressed){
            playerX += playerSpeed;
        }

    }

    public void paintComponent(Graphics g) 
    { /* paintComponent is a standard method to draw things on jpanel, Graphics is a class that
    has many functions to draw objects on the screen */

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose(); // disposes of graphic context &   releases systems resources to save memory
        
    }

}
