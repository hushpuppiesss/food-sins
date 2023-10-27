package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Player extends Entity {

  GamePanel gp;
  KeyHandler keyH;

  public Player(GamePanel gp, KeyHandler keyH) 
  {
    // 
    this.gp = gp;
    this.keyH = keyH;

    setDefaultValues();
    getPlayerImage();
  }

  public void setDefaultValues() 
  {
    x = 100;
    y = 100;
    speed = 4;
    direction = "down";
  }

  private BufferedImage loadImage(String path) throws IOException {
    InputStream stream = Objects.requireNonNull(getClass().getResourceAsStream(path));
    /*
    objects.requirenonnull(), checks if something is null and throws an exception instead
    getclass() gets the player class
    getresource as stream(path) obtains smth at the specified path
     */
    return ImageIO.read(stream);
    // imageio.read() reads the image
  }

  public void getPlayerImage() {

    try
    {
      //up
      up0 = loadImage("/res/player/gooseback_walk0.png");
      up1 = loadImage("/res/player/gooseback_walk1.png");
      up2 = loadImage("/res/player/gooseback_walk2.png");
      up3 = loadImage("/res/player/gooseback_walk3.png");
      up4 = loadImage("/res/player/gooseback_walk4.png");
      up5 = loadImage("/res/player/gooseback_walk5.png");
      //down
      down0 = loadImage("/res/player/goosefront_walk0.png");
      down1 = loadImage("/res/player/goosefront_walk1.png");
      down2 = loadImage("/res/player/goosefront_walk2.png");
      down3 = loadImage("/res/player/goosefront_walk3.png");
      down4 = loadImage("/res/player/goosefront_walk4.png");
      down5 = loadImage("/res/player/goosefront_walk5.png");
      //left
      left0 = loadImage("/res/player/gooseleft_walk0.png");
      left1 = loadImage("/res/player/gooseleft_walk1.png");
      left2 = loadImage("/res/player/gooseleft_walk2.png");
      left3 = loadImage("/res/player/gooseleft_walk3.png");
      left4 = loadImage("/res/player/gooseleft_walk4.png");
      left5 = loadImage("/res/player/gooseleft_walk5.png");
      //right
      right0 = loadImage("/res/player/gooseright_walk0.png");
      right1 = loadImage("/res/player/gooseright_walk1.png");
      right2 = loadImage("/res/player/gooseright_walk2.png");
      right3 = loadImage("/res/player/gooseright_walk3.png");
      right4 = loadImage("/res/player/gooseright_walk4.png");
      right5 = loadImage("/res/player/gooseright_walk5.png");

      //up idle
      up0_idle = loadImage("/res/player/gooseback_idle0.png");
      up1_idle = loadImage("/res/player/gooseback_idle1.png");
      up2_idle = loadImage("/res/player/gooseback_idle2.png");
      up3_idle = loadImage("/res/player/gooseback_idle3.png");
      //down idle
      down0_idle = loadImage("/res/player/goosefront_idle0.png");
      down1_idle = loadImage("/res/player/goosefront_idle1.png");
      down2_idle = loadImage("/res/player/goosefront_idle2.png");
      down3_idle = loadImage("/res/player/goosefront_idle3.png");
      //left idle
      left0_idle = loadImage("/res/player/gooseleft_idle0.png");
      left1_idle = loadImage("/res/player/gooseleft_idle1.png");
      left2_idle = loadImage("/res/player/gooseleft_idle2.png");
      left3_idle = loadImage("/res/player/gooseleft_idle3.png");
      //right idle
      right0_idle = loadImage("/res/player/gooseright_idle0.png");
      right1_idle = loadImage("/res/player/gooseright_idle1.png");
      right2_idle = loadImage("/res/player/gooseright_idle2.png");
      right3_idle = loadImage("/res/player/gooseright_idle3.png");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void update() {

    if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)
    {
      // MOVING ANIMATION
      if (keyH.upPressed) { // shorthand for keyH.upPressed being true
        direction = "up";
        y -= speed;
      } else if (keyH.leftPressed) {
        direction = "left";
        x -= speed;
      } else if (keyH.downPressed) {
        direction = "down";
        y += speed;
      } else if (keyH.rightPressed) {
        direction = "right";
        x += speed;
      }

      spriteCounter++;

      if (spriteCounter > 10)
      {
        if (spriteNum == 0)
        {
          spriteNum = 1;
        }
        if (spriteNum == 1)
        {
          spriteNum = 2;
        }
        else if (spriteNum == 2)
        {
          spriteNum = 3;
        }
        else if (spriteNum == 3)
        {
          spriteNum = 4;
        }
        else if (spriteNum == 4)
        {
          spriteNum = 5;
        }
        else if (spriteNum == 5)
        {
          spriteNum = 0;
        }

        spriteCounter = 0;
      }
    }
    else // IDLE ANIMATION
    {
      if (Objects.equals(direction, "up"))
      {
        direction = "up_idle";
      }
      else if (Objects.equals(direction, "left"))
      {
        direction = "left_idle";
      }
      else if (Objects.equals(direction, "down"))
      {
        direction = "down_idle";
      }
      else if (Objects.equals(direction, "right"))
      {
        direction = "right_idle";
      }

      spriteCounter++;

      if (spriteCounter > 10)
      {
        if (spriteNum == 0)
        {
          spriteNum = 1;
        }
        if (spriteNum == 1)
        {
          spriteNum = 2;
        }
        else if (spriteNum == 2)
        {
          spriteNum = 3;
        }
        else if (spriteNum == 3)
        {
          spriteNum = 0;
        }

        spriteCounter = 0;
      }
    }
  }

  public void draw(Graphics2D g2)
  {
    BufferedImage image = null;

    switch (direction) 
    {
      case "up":
        if (spriteNum == 0) {
          image = up0;
        }
        if (spriteNum == 1) {
          image = up1;
        }
        if (spriteNum == 2) {
          image = up2;
        }
        if (spriteNum == 3) {
          image = up3;
        }
        if (spriteNum == 4) {
          image = up4;
        }
        if (spriteNum == 5) {
          image = up5;
        }
        break;
      case "down":
        if (spriteNum == 0) {
          image = down0;
        }
        if (spriteNum == 1) {
          image = down1;
        }
        if (spriteNum == 2) {
          image = down2;
        }
        if (spriteNum == 3) {
          image = down3;
        }
        if (spriteNum == 4) {
          image = down4;
        }
        if (spriteNum == 5) {
          image = down5;
        }
        break;
      case "left":
        if (spriteNum==0) {
          image = left0;
        }
        if (spriteNum == 1) {
          image = left1;
        }
        if (spriteNum == 2) {
          image = left2;
        }
        if (spriteNum == 3) {
          image = left3;
        }
        if (spriteNum == 4) {
          image = left4;
        }
        if (spriteNum == 5) {
          image = left5;
        }
        break;
      case "right":
        if(spriteNum == 0) {
          image = right0;
        }
        if(spriteNum == 1) {
          image = right1;
        }
        if(spriteNum == 2) {
          image = right2;
        }
        if(spriteNum == 3) {
          image = right3;
        }
        if(spriteNum == 4) {
          image = right4;
        }
        if(spriteNum == 5) {
          image = right5;
        }
        break;
      case "up_idle":
        if (spriteNum == 0) {
          image = up0_idle;
        }
        if (spriteNum == 1) {
          image = up1_idle;
        }
        if (spriteNum == 2) {
          image = up2_idle;
        }
        if (spriteNum == 3) {
          image = up3_idle;
        }
        break;
      case "down_idle":
        if (spriteNum == 0) {
          image = down0_idle;
        }
        if (spriteNum == 1) {
          image = down1_idle;
        }
        if (spriteNum == 2) {
          image = down2_idle;
        }
        if (spriteNum == 3) {
          image = down3_idle;
        }
        break;
      case "left_idle":
        if (spriteNum==0) {
          image = left0_idle;
        }
        if (spriteNum == 1) {
          image = left1_idle;
        }
        if (spriteNum == 2) {
          image = left2_idle;
        }
        if (spriteNum == 3) {
          image = left3_idle;
        }
        break;
      case "right_idle":
        if(spriteNum == 0) {
          image = right0_idle;
        }
        if(spriteNum == 1) {
          image = right1_idle;
        }
        if(spriteNum == 2) {
          image = right2_idle;
        }
        if(spriteNum == 3) {
          image = right3_idle;
        }
        break;
      }

      g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
  }
