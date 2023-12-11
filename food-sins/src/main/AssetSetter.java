package main;

import entity.Entity;
import monster.MON_placeholder;
public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setMonster()  {
        gp.monster[0] = new MON_placeholder(gp);
        gp.monster[0].worldX = gp.tileSize*26;
        gp.monster[0].worldY = gp.tileSize*26;
    }
}
