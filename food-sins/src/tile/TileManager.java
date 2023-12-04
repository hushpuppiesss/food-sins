package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int[][] mapTileNum;

    // tile manager constructor
    public TileManager(GamePanel gp)
    {
        this.gp = gp;

        tile = new Tile[15]; // creating n number of tiles
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("/res/maps/map2.txt");
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
            tile[0].image = loadImage("/res/tiles/carpet.png");

            tile[1] = new Tile();
            tile[1].image = loadImage("/res/tiles/cheese bowl.png");

            tile[2] = new Tile();
            tile[2].image = loadImage("/res/tiles/crate apples.png");

            tile[3] = new Tile();
            tile[3].image = loadImage("/res/tiles/crate blueberries.png");

            tile[4] = new Tile();
            tile[4].image = loadImage("/res/tiles/crate empty.png");

            tile[5] = new Tile();
            tile[5].image = loadImage("/res/tiles/crate herb.png");

            tile[6] = new Tile();
            tile[6].image = loadImage("/res/tiles/crate oranges.png");

            tile[7] = new Tile();
            tile[7].image = loadImage("/res/tiles/flour bag.png");

            tile[8] = new Tile();
            tile[8].image = loadImage("/res/tiles/flour spill.png");

            tile[9] = new Tile();
            tile[9].image = loadImage("/res/tiles/tomato sauce.png");

            tile[10] = new Tile();
            tile[10].image = loadImage("/res/tiles/wood floor.png");

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    // ----------------------- LOADING THE MAP -----------------------
    public void loadMap(String filePath)
    {
         try
         {
             // importing the map from the text file
             InputStream is = getClass().getResourceAsStream(filePath);

             // reading the contents of the text file
             BufferedReader br = new BufferedReader(new InputStreamReader(is));

             // initializing column and row variables
             int col = 0;
             int row = 0;

             while (col < gp.maxScreenCol && row < gp.maxScreenRow)
             {
                 String line = br.readLine();

                 while (col < gp.maxScreenCol)
                 {
                     String[] numbers = line.split(" ");

                     int num = Integer.parseInt(numbers[col]);

                     mapTileNum[col][row] = num;
                     col++;
                 }

                 if (col == gp.maxScreenCol)
                 {
                     col = 0;
                     row++;
                 }
             }

             // closing the reader
             br.close();
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
        we will reset and move on to the next column, starting a new row by way of moving a y value
         */
        while (col < gp.maxScreenCol && row < gp.maxScreenRow)
        {
            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
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
