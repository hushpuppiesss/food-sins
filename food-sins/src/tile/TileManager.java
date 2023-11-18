package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    Tile[] tile;

    // tile manager constructor
    public TileManager(GamePanel gp)
    {
        this.gp = gp;

        tile = new Tile[5]; // creating n number of tiles

        getTileImage();
    }

    // ----------------------- LOADING IMAGE METHOD -----------------------
    private BufferedImage loadImage(String path) throws IOException
    {
        InputStream stream = Objects.requireNonNull(getClass().getResourceAsStream(path));
    /*
    objects.requirenonnull(), checks if something is null and throws an exception instead
    getclass() gets the player class
    getresource as stream(path) obtains smth at the specified path
     */
        return ImageIO.read(stream);
        // imageio.read() reads the image
    }

    // ----------------------- GETTING TILE IMAGES -----------------------
    public void getTileImage()
    {
        try
        {

            tile[0] = new Tile();
            tile[0].image = loadImage("/res/tiles/wood floor.png");

            tile[1] = new Tile();
            tile[1].image = loadImage("/res/tiles/carpet.png");

            tile[2] = new Tile();
            tile[2].image = loadImage("/res/tiles/crate empty.png");

            tile[3] = new Tile();
            tile[3].image = loadImage("/res/tiles/crate apples.png");

            tile[4] = new Tile();
            tile[4].image = loadImage("/res/tiles/crate oranges.png");

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // ----------------------- DRAWING METHOD -----------------------

    public void draw(Graphics2D g2)
    {
        int col = 0; // column
        int row = 0; // row
        int x = 0; // x coordinate
        int y = 0; // y coordinate

        /*
        This while loop while keep drawing a tile as long as we haven't met the max screen column and row.
        It will add column by one, then move the x coordinate by the tile size. if we have met the max column number,
        we will reset and move on to the next column, starting a new row by way of moving a y value.
         */
        while (col < gp.maxScreenCol && row < gp.maxScreenRow)
        {
            g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }

}
