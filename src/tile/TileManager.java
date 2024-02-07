package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {
  public Tile[] tile;
  GamePanel gp;
  
  public TileManager(GamePanel gp) {
    this.gp = gp;
    tile = new Tile[10];
    
    getTileImage();
    
  }
  
  public void getTileImage() {
    try {
      tile[0] = new Tile();
      tile[0].img = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
      
      tile[1] = new Tile();
      tile[1].img = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
      
      tile[2] = new Tile();
      tile[2].img = ImageIO.read(getClass().getResourceAsStream("/tiles/stone.png"));
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void draw(Graphics2D g2) {
    int x, y;
    int xMax = 9;
    int yMax = 9;
    Scanner scr = null;
    
    try {
      scr = new Scanner(new FileReader("C:\\Users\\noahr\\eclipse-workspace\\My2DGame\\assests\\maps\\testmap1.txt"));
    }catch(Exception e) {
      e.printStackTrace();
    }
    
    for (y = 0; y < yMax; ++y) {
      for (x=0; x < xMax; ++x) {
        int tileNum = scr.nextInt();
        g2.drawImage(tile[tileNum].img, x*gp.tileSize-gp.player.xPos, y*gp.tileSize-gp.player.yPos, gp.tileSize, gp.tileSize, null);
      }
    }

  }
}
