package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {
  public Tile[] tile;
  GamePanel gp;
  String filePath = new File("").getAbsolutePath();

  public TileManager(GamePanel gp) {
    this.gp = gp;
    tile = new Tile[10];

    getTileImage();

  }

  public void getTileImage() {
    String filePath = new File("").getAbsolutePath();

    try {
      tile[0] = new Tile();
      tile[0].img = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
      tile[1] = new Tile();
      tile[1].img = ImageIO.read(getClass().getResourceAsStream("/tiles/grass1.png"));

      tile[2] = new Tile();
      tile[2].img = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
      tile[3] = new Tile();
      tile[3].img = ImageIO.read(getClass().getResourceAsStream("/tiles/sand1.png"));

      tile[4] = new Tile();
      tile[4].img = ImageIO.read(getClass().getResourceAsStream("/tiles/northpath.png"));

      tile[5] = new Tile();
      tile[5].img = ImageIO.read(getClass().getResourceAsStream("/tiles/southpath.png"));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void draw(Graphics2D g2) {
    int x, y;
    int xMax = 24;
    int yMax = 6;
    Scanner scr = null;

    try {
      scr = new Scanner(new FileReader(filePath + "\\assests\\maps\\testmap1.txt"));
    } catch (Exception e) {
      e.printStackTrace();
    }

    for (y = 0; y < yMax; ++y) {
      for (x = 0; x < xMax; ++x) {
        int tileNum = scr.nextInt();
        g2.drawImage(tile[tileNum].img, x * gp.tileSize - gp.player.xPos,
            y * gp.tileSize - gp.player.yPos, gp.tileSize, gp.tileSize, null);
      }
    }

  }
}
