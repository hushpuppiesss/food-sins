package entity;

import java.awt.image.BufferedImage;

// will store variables that will be used in player, enemy, turret, and npc classes

public class Entity {

  // X and Y of the characters position
  public int x, y;
  // speed of the player
  public int speed;
  // used for player direction in player.java
  public BufferedImage up0, up1, down0, down1, left0, left1, right0, right1,
          up0_idle, up1_idle,down0_idle, down1_idle, left0_idle, left1_idle, right0_idle, right1_idle;

  public String direction;

  public int spriteCounter = 0;
  public int spriteNum = 0;

}
