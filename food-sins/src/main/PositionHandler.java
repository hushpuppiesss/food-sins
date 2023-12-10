// ==========================================
//          Position Handler Class
//  Author: Liyuan Hu
//  Purpose:
// ==========================================

package main;

import object.Boba;
import object.Broccoli;
import object.Pudding;

public class PositionHandler {
    GamePanel gp;
// receive game panel
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
        gp.obj[0].worldX = 10*gp.tileSize;
        gp.obj[0].worldY= 20*gp.tileSize;
        //a pudding
        gp.obj[2]=new Pudding();
        gp.obj[2].worldX = 20*gp.tileSize;
        gp.obj[2].worldY = 20*gp.tileSize;
        // a broccoli
        gp.obj[1]=new Broccoli();
        gp.obj[1].worldX = 5*gp.tileSize;
        gp.obj[1].worldY = 5*gp.tileSize;
    }
}


    /*Call setObject in game pannel
    public void setupGame(){
        PosH.PositionHandler()；
    }
    run  gamePanel.setupGame() in main method before the panel
    */


