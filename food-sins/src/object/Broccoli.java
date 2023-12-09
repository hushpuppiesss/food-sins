//jennie 
package object;

import java.io.IOException;
import java.util.Objects;
import object.SuperObject;

import javax.imageio.ImageIO;

public class Broccoli extends SuperObject{
    //constructor
    public Broccoli(){
        name = "atk broco";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/buffs/broccoli.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //add to game panel SuperObject obj[]=new SuperObject[10];//prepares a maximum 10 objects on display


    }
    
}
