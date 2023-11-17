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

  private BufferedImage loadImage(String path) throws IOException
  {
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
      //down
      down0 = loadImage("/res/player/goosefront_walk0.png");
      down1 = loadImage("/res/player/goosefront_walk1.png");
      //left
      left0 = loadImage("/res/player/gooseleft_walk0.png");
      left1 = loadImage("/res/player/gooseleft_walk1.png");
      //right
      right0 = loadImage("/res/player/gooseright_walk0.png");
      right1 = loadImage("/res/player/gooseright_walk1.png");
      //up idle
      up0_idle = loadImage("/res/player/gooseback_idle0.png");
      up1_idle = loadImage("/res/player/gooseback_idle1.png");
      //down idle
      down0_idle = loadImage("/res/player/goosefront_idle0.png");
      down1_idle = loadImage("/res/player/goosefront_idle1.png");
      //left idle
      left0_idle = loadImage("/res/player/gooseleft_idle0.png");
      left1_idle = loadImage("/res/player/gooseleft_idle1.png");
      //right idle
      right0_idle = loadImage("/res/player/gooseright_idle0.png");
      right1_idle = loadImage("/res/player/gooseright_idle1.png");
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
        else if (spriteNum == 1)
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
        else if (spriteNum == 1)
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
        break;
      case "down":
        if (spriteNum == 0) {
          image = down0;
        }
        if (spriteNum == 1) {
          image = down1;
        }
        break;
      case "left":
        if (spriteNum==0) {
          image = left0;
        }
        if (spriteNum == 1) {
          image = left1;
        }
        break;
      case "right":
        if(spriteNum == 0) {
          image = right0;
        }
        if(spriteNum == 1) {
          image = right1;
        }
        break;
      case "up_idle":
        if (spriteNum == 0) {
          image = up0_idle;
        }
        if (spriteNum == 1) {
          image = up1_idle;
        }
        break;
      case "down_idle":
        if (spriteNum == 0) {
          image = down0_idle;
        }
        if (spriteNum == 1) {
          image = down1_idle;
        }
        break;
      case "left_idle":
        if (spriteNum==0) {
          image = left0_idle;
        }
        if (spriteNum == 1) {
          image = left1_idle;
        }
        break;
      case "right_idle":
        if(spriteNum == 0) {
          image = right0_idle;
        }
        if(spriteNum == 1) {
          image = right1_idle;
        }
        break;
      }

      g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
  }
