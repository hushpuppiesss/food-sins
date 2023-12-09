// ==========================================
//               TileManager Class
//  Author: Rachel Quedding
//  Purpose: handles the loading  and drawing of tiles...
// ==========================================

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
    public Tile[] tile;
    public int[][] mapTileNum;

    // tile manager constructor
    public TileManager(GamePanel gp)
    {
        this.gp = gp;

        tile = new Tile[40]; // creating n number of tiles
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/res/maps/map.txt");
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
        try {
            // loads the 9 green carpet sprites
            for (int i = 1; i < 10; i++)
            {
                tile[i - 1] = new Tile();
                tile[i - 1].image = loadImage("/res/tiles/carpet_green" + i + ".png");
            }

            // loads the 9 red carpet sprites
            for (int i = 1; i < 10; i++)
            {
                tile[i + 8] = new Tile();
                tile[i + 8].image = loadImage("/res/tiles/carpet_red" + i + ".png");
            }

            // loads the 9 yellow carpet sprites
            for (int i = 1; i < 10; i++)
            {
                tile[i + 17] = new Tile();
                tile[i + 17].image = loadImage("/res/tiles/carpet_yellow" + i + ".png");
            }

            tile[27] = new Tile();
            tile[27].image = loadImage("/res/tiles/cheese bowl.png");
            tile[27].collision = true;

            tile[28] = new Tile();
            tile[28].image = loadImage("/res/tiles/crate apples.png");
            tile[28].collision = true;

            tile[29] = new Tile();
            tile[29].image = loadImage("/res/tiles/crate blueberries.png");
            tile[29].collision = true;

            tile[30] = new Tile();
            tile[30].image = loadImage("/res/tiles/crate empty.png");
            tile[30].collision = true;

            tile[31] = new Tile();
            tile[31].image = loadImage("/res/tiles/crate herb.png");
            tile[31].collision = true;

            tile[32] = new Tile();
            tile[32].image = loadImage("/res/tiles/crate oranges.png");
            tile[32].collision = true;

            tile[33] = new Tile();
            tile[33].image = loadImage("/res/tiles/empty bowl.png");
            tile[33].collision = true;

            tile[34] = new Tile();
            tile[34].image = loadImage("/res/tiles/flour bag.png");
            tile[34].collision = true;

            tile[35] = new Tile();
            tile[35].image = loadImage("/res/tiles/flour spill.png");


            tile[36] = new Tile();
            tile[36].image = loadImage("/res/tiles/tomato sauce.png");
            tile[36].collision = true;

            tile[37] = new Tile();
            tile[37].image = loadImage("/res/tiles/wood floor.png");



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

             while (col < gp.maxWorldCol && row < gp.maxWorldRow)
             {
                 String line = br.readLine();

                 while (col < gp.maxWorldCol)
                 {
                     String[] numbers = line.split(" ");

                     int num = Integer.parseInt(numbers[col]);

                     mapTileNum[col][row] = num;
                     col++;
                 }

                 if (col == gp.maxWorldCol)
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
        int worldCol = 0; // column
        int worldRow = 0; // row

        /*
        This while loop while keep drawing a tile as long as we haven't met the max world column and row.
        It will add column by one, then move the x coordinate by the tile size. if we have met the max column number,
        we will reset and move on to the next column, starting a new row by way of moving a y value
         */
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow)
        {
            int tileNum = mapTileNum[worldCol][worldRow];

            /* check the tile's worldX/Y to know where to draw it ON THE WORLD
            by calculating what row/column we're on and multiplying it by the tilesize.
            ex. worldCol = 0 and worldRow = 0 multiplied by tileSize will draw the first tile at (0,0).
            worldCol = 1 and worldRow = 0 multiplied by tileSize will draw the next tile at (64, 0).
             */
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;

            // WHERE ON THE SCREEN we need to draw it by calculating the distance
            // relative to the player
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            // improving rendering efficiency to only draw tiles that are within our game window (with margin area_
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
            {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

}
