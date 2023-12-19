// ==========================================
//               Monster Class
//  Author: Chris Rattacasa
//  Purpose: All monster's stats, spawn
//  information, and spawn process come from
//  the Monster class
// ==========================================

package main;
//Chris
import java.awt.*;
import java.util.Random;
import entity.Entity;
import main.GamePanel;
import tile.TileManager;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class MON_placeholder extends Entity {
    public int screenX;
    public int screenY;
    GamePanel gp;
    public MON_placeholder(GamePanel gp) {
        super(gp);

        String name = "placeholder";
        speed = 1;
        maxLife = 3;
        life = maxLife;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }
    private BufferedImage loadImage(String path) throws IOException
    {
        InputStream stream = Objects.requireNonNull(getClass().getResourceAsStream(path));
        return ImageIO.read(stream);
    }
    public void getImage() {
        try {
            up0 = loadImage("res/monster/placeholder0");
            up1 = loadImage("res/monster/placeholder1");
            down0 = loadImage("res/monster/placeholder0");
            down1 = loadImage("res/monster/placeholder1");
            left0 = loadImage("res/monster/placeholder0");
            left1 = loadImage("res/monster/placeholder1");
            right0 = loadImage("res/monster/placeholder0");
            right1 = loadImage("res/monster/placeholder1");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {

        Random random = new Random();
        int i = random.nextInt(100) + 1;
        if (i <= 25) {
            direction = "up";
        }
        if (i > 25 && i <= 50) {
            direction = "down";
        }
        if (i > 50 && i <= 75) {
            direction = "left";
        }
        if (i > 75 && i <= 100) {
            direction = "right";
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
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
                if (spriteNum == 0) {
                    image = left0;
                }
                if (spriteNum == 1) {
                    image = left1;
                }
                break;
            case "right":
                if (spriteNum == 0) {
                    image = right0;
                }
                if (spriteNum == 1) {
                    image = right1;
                }
                break;
            }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }
}

