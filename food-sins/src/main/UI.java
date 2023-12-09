package main;

import object.SuperObject;
import object.heart;
import java.awt.Image;
import java.awt.BasicStroke;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import java.awt.Graphics;



public class UI {
    Graphics2D g2;
    BufferedImage heart_full, heart_half, heart_empty;
    GamePanel gp;


    public UI(GamePanel gp) {
        this.gp = gp;
        SuperObject heart = new heart(gp);
        heart_empty = heart.image;
        heart_half = heart.image2;
        heart_full = heart.image3;

    }


    //play state add things below or above if you want!
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        if (gp.gameState == gp.playState) {
            drawPlayerLife();
            System.out.println("uwu");

        }
        if (gp.gameState == gp.pauseState) {
            drawPlayerLife();

        }



    }
    //Create HUD for Hearts
    public void drawPlayerLife() {
        int x = gp.tileSize;
        int y = gp.tileSize;
        int i = 0;
        //Displays blank hearts
        while(i < gp.player.maxLife/2) {
            g2.drawImage(heart_empty, x, y, null);
            i++;
            x += gp.tileSize;
        }

    }
}