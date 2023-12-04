//jennie 
package object;

import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

import object.SuperObject;

public class Boba extends SuperObject{
    //constructor
    public Boba(){
        name = "speedy boba";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/buffs/boba.png")));
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        //add to game panel SuperObject obj[]=new SuperObject[10];//prepares a maximum 10 objects on display

    }
    
}
