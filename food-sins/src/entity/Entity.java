package entity;

import java.awt.image.BufferedImage;

// will store variables that will be used in player, enemy, turret, and npc classes

public class Entity {

  // X and Y of the characters position
  public int x, y;
  // speed of the player
  public int speed;
  // used for player direction in player.java
  public BufferedImage up0, up1, up2, up3, up4, up5, down0, down1, down2, down3, down4, down5,
          left0, left1, left2, left3, left4, left5, right0, right1, right2, right3, right4, right5,
          up0_idle, up1_idle, up2_idle, up3_idle, down0_idle, down1_idle, down2_idle, down3_idle,
          left0_idle, left1_idle, left2_idle, left3_idle, right0_idle, right1_idle, right2_idle, right3_idle;
  //
  public String direction;

  public int spriteCounter = 0;
  public int spriteNum = 0;

}
