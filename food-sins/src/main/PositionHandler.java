//jennie
package main;

import monster.MON_placeholder;
import object.Boba;

public class PositionHandler {
    GamePanel gp;
//recieve game pannel
    public PositionHandler(GamePanel gp){
        this.gp = gp;
    }

    // in game panel also initiate this class
    // public PositionHandler PosH = new PositionHandler(this)
    public void setObject(){
        //pulling it from the subclass into an array
        gp.obj[0]=new Boba();
        //placing it in the coordinates on the map
        //maybe change to random in the future?
        gp.obj[0].worldX = 20*gp.tileSize;
        gp.obj[0].worldY= 20*gp.tileSize;
        //a second boba
        gp.obj[1]=new Boba();
        gp.obj[1].worldX = 10*gp.tileSize;
        gp.obj[1].worldY = 10*gp.tileSize;
    }
    public void setMonster()  {
        gp.monster[0] = new MON_placeholder(gp);
        gp.monster[0].worldX = gp.tileSize*26;
        gp.monster[0].worldY = gp.tileSize*26;
    }
}