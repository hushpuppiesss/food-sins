//jennie 
package object;

import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

public class Boba extends SuperObject{
    //constructor
    public Boba(){
        name = "Speedy Boba";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/buffs/boba.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //add to game panel SuperObject obj[]=new SuperObject[10];//prepares a maximum 10 objects on display


    }
    
}
