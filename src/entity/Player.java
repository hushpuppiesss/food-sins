package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

  GamePanel gp;
  KeyHandler keyH;

  public Player(GamePanel gp, KeyHandler keyH) {

    // 
    this.gp = gp;
    this.keyH = keyH;


    setDefaultValues();
    getPlayerImage();
    direction = "up";
  }

  public void setDefaultValues() {

    x = 100;
    y = 100;
    speed = 4;
  }

  public void getPlayerImage() {

    try {
      //up
      up0 = ImageIO.read(getClass().getResourceAsStream("/goosefront_walk0.png"));
      up1 = ImageIO.read(getClass().getResourceAsStream("/goosefront_walk1.png"));
      up2 = ImageIO.read(getClass().getResourceAsStream("/goosefront_walk2.png"));
      up3 = ImageIO.read(getClass().getResourceAsStream("/goosefront_walk3.png"));
      up4 = ImageIO.read(getClass().getResourceAsStream("/goosefront_walk4.png"));
      up5 = ImageIO.read(getClass().getResourceAsStream("/goosefront_walk5.png"));
      //down
      down0 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk0.png"));
      down1 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk1.png"));
      down2 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk2.png"));
      down3 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk3.png"));
      down4 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk4.png"));
      down5 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk5.png"));
      down0 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk0.png"));
      down1 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk1.png"));
      down2 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk2.png"));
      down3 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk3.png"));
      down4 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk4.png"));
      down5 = ImageIO.read(getClass().getResourceAsStream("/gooseback_walk5.png"));
      //left
      left0 = ImageIO.read(getClass().getResourceAsStream("/gooseleft_walk0.png"));
      left1 = ImageIO.read(getClass().getResourceAsStream("/gooseleft_walk1.png"));
      left2 = ImageIO.read(getClass().getResourceAsStream("/gooseleft_walk2.png"));
      left3= ImageIO.read(getClass().getResourceAsStream("/gooseleft_walk3.png"));
      left4= ImageIO.read(getClass().getResourceAsStream("/gooseleft_walk4.png"));
      left5 = ImageIO.read(getClass().getResourceAsStream("/gooseleft_walk5.png"));
      //right
      right0 = ImageIO.read(getClass().getResourceAsStream("/gooseright_walk0.png"));
      right1 = ImageIO.read(getClass().getResourceAsStream("/gooseright_walk1.png"));
      right2 = ImageIO.read(getClass().getResourceAsStream("/gooseright_walk2.png"));
      right3 = ImageIO.read(getClass().getResourceAsStream("/gooseright_walk3.png"));
      right4 = ImageIO.read(getClass().getResourceAsStream("/gooseright_walk4.png"));
      right5 = ImageIO.read(getClass().getResourceAsStream("/gooseright_walk5.png"));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void update() {
    // player movement
    if (keyH.upPressed) { // shorthand for keyH.upPressed being true
      direction = "down";
      y -= speed;
    }
    if (keyH.leftPressed) {
      direction = "left";
      x -= speed;
    }
    if (keyH.downPressed) {
      direction = "up";
      y += speed;
    }

    if (keyH.rightPressed) {
      direction = "right";
      x += speed;
    }

  }

  public void draw(Graphics2D g2) {

    //g2.setColor(Color.white);
    //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

    BufferedImage image = null;

    switch (direction) {
      case "up":
        if (spriteNum ==0) {
          image = up0;
        }
        if (spriteNum ==1) {
          image = up1;
        }
        if (spriteNum ==1) {
          image = up2;
        }
        if (spriteNum ==1) {
          image = up3;
        }
        if (spriteNum ==1) {
          image = up4;
        }
        if (spriteNum ==1) {
          image = up5;
        }
        break;
      case "down": {
        if (spriteNum == 0)
          image = down0;
      }
        if (spriteNum==1) {
          image = down1;
        }
        if (spriteNum==2) {
          image = down2;
        }
        if (spriteNum==3) {
          image = down3;
        }
        if (spriteNum==4) {
          image = down4;
        }
        if (spriteNum==5) {
          image = down5;
        }
        break;
      case "left":
        if (spriteNum==0) {
          image = left0;
        }
        if (spriteNum==1) {
          image = left1;
        }
        if (spriteNum==2) {
          image = left2;
        }
        if (spriteNum==3) {
          image = left3;
        }
        if (spriteNum==4) {
          image = left4;
        }
        if (spriteNum==5) {
          image = left5;
        }
        break;
      case "right":
        if(spriteNum==0) {
          image = right0;
        }
        if(spriteNum==1) {
          image = right1;
        }
        if(spriteNum==2) {
          image = right2;
        }
        if(spriteNum==3) {
          image = right3;
        }
        if(spriteNum==4) {
          image = right4;
        }
        if(spriteNum==5) {
          image = right5;
        }
        break;
        }


      spriteCounter++;
      if(spriteCounter >10 ){
        if(spriteNum ==1){
          spriteNum = 2;
        }
        else if(spriteNum == 2){
          spriteNum =1;
        }
        spriteCounter = 0;
      }
    }
    g2.drawImage(image, x, y ,gp.tileSize, gp.tileSize, null);
  }
}
