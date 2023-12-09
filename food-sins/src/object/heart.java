package object;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import main.GamePanel;

public class heart extends SuperObject {
    //uses resource from SuperObject
    GamePanel gp;

    public heart(GamePanel gp) {
        this.gp = gp;
        //name of obj
        name = "Heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/hearts/heart_empty.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/hearts/heart_half.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/res/hearts/heart_full.png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
            image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
