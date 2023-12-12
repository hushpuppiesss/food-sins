package main;

import object.OBJ_Boba;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    // font
    Font arial_40;

    // images
    BufferedImage bobaImage;

    // whether we are showing message or not
    public boolean messageOn = false;
    public String message = "";


    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        OBJ_Boba boba = new OBJ_Boba();
        bobaImage = boba.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw (Graphics2D g2) {

        g2.setFont(arial_40);
        g2.setColor(Color.white);


    }
}
