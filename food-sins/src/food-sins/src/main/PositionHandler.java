//jennie
package main;

import object.Boba;

public class PositionHandler {
    GamePanel gp;
//recieve game pannel
    public PositionHandler(GamePanel gp){
        this.gp = gp;
    }
    //in game pannel also initiate this class
    //public PositionHandler PosH = new PositionHandler(this)
    public void setObject(){
        //pulling it from the subclass into an array
        gp.obj[0]= new entity.Entity();
        //placing it in the coordinates on the map
        //maybe change to random in the future?
        gp.obj[0].worldX = 10*gp.tileSize;
        gp.obj[0].worldY= 10*gp.tileSize;
        //a second boba
        gp.obj[1]= new entity.Entity();
        gp.obj[1].worldX = 8*gp.tileSize;
        gp.obj[1].worldY = 8*gp.tileSize;
    }
    /*Call setObject in game panel
    //public void setupGame(){
  //      PosH.PositionHandler()；
    }
    run  gamePanel.setupGame() in main method before the panel
    */

}
