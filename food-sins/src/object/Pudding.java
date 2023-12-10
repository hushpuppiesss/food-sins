//jennie 
package object;

import java.io.IOException;
import java.util.Objects;
import object.SuperObject;

import javax.imageio.ImageIO;

public class Pudding extends SuperObject{
    //constructor
    public Pudding(){
        name = "defense pudding";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/buffs/pudding1.png")));
           image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/buffs/pudding2.png")));
            image3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/buffs/pudding3.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //add to game panel SuperObject obj[]=new SuperObject[10];//prepares a maximum 10 objects on display


    }
    
}
