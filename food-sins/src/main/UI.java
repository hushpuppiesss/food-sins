package main;

import object.OBJ_Boba;
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
import java.awt.*;
import java.awt.image.BufferedImage;
//Mateo and Rachel
public class UI {


    GamePanel gp;
    Graphics2D g2;
    // font
    Font arial_40;

    // images
    BufferedImage bobaImage;
    BufferedImage heart_full, heart_half, heart_empty;

    // whether we are showing message or not
    public boolean messageOn = false;
    public String message = "";
    // for message disappearing
    int messageCounter = 0;


    public UI(GamePanel gp) {
        Graphics2D g2;


        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        OBJ_Boba boba = new OBJ_Boba();
        bobaImage = boba.image;

        SuperObject heart = new heart(gp);
        heart_empty = heart.image;
        heart_half = heart.image2;
        heart_full = heart.image3;

    }


    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {


        if (gp.gameState == gp.playState) {
            drawPlayerLife();
            System.out.println("uwu");

        }
        if (gp.gameState == gp.pauseState) {
            drawPlayerLife();
        }


        g2.setFont(arial_40);
        g2.setColor(Color.white);

        // ----------------------- DRAWING MESSAGE -----------------------
        if (messageOn) {

            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);

            messageCounter++;

            if (messageCounter > 120) {
                messageCounter = 0;
                messageOn = false;
            }

        }


    }

    public void drawPlayerLife() {
        int x = gp.tileSize;
        int y = gp.tileSize;
        int i = 0;
        //Displays blank hearts
        while (i < gp.player.maxLife / 2) {
            g2.drawImage(heart_empty, x, y, null);
            i++;
            x += gp.tileSize;
        }
    }
}
