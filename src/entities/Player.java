package entities;

import main.KeyHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Player {
  int speed = 8;
  public int xPos;
  public int yPos = 0;
  KeyHandler keyH;
  boolean isWalkingUp, isWalkingDown, isWalkingLeft, isWalkingRight;
  boolean upUnpassable, downUnpassable, leftUnpassable, rightUnpassable;
  BufferedImage img;
  GamePanel gp;

  public Player(KeyHandler keyH, GamePanel gp) {
    this.keyH = keyH;
    this.gp = gp;
    xPos = 1 * gp.tileSize;
    setImg("/character/south.png");
  }

  public void setImg(String str) {
    try {
      img = ImageIO.read(getClass().getResourceAsStream(str));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void draw(Graphics2D g2) {

    g2.drawImage(img, gp.scrnWidth / 2 - gp.tileSize / 2, gp.scrnHeight / 2, gp.tileSize, gp.tileSize, null);
  }

  public void updatePlayer() {
    if ((keyH.upPressed || isWalkingUp) && !isWalkingDown && !isWalkingLeft && !isWalkingRight) {
      yPos -= speed;
      setImg("/character/north.png");
      if (yPos % 64 == 0) {
        isWalkingUp = false;
      } else {
        isWalkingUp = true;
      }

    } else if ((keyH.downPressed || isWalkingDown) && !isWalkingUp && !isWalkingLeft && !isWalkingRight) {
      yPos += speed;
      setImg("/character/south.png");
      if (yPos % 64 == 0) {
        isWalkingDown = false;
      } else {
        isWalkingDown = true;
      }

    } else if ((keyH.leftPressed || isWalkingLeft) && !isWalkingDown && !isWalkingUp && !isWalkingRight) {
      xPos -= speed;
      setImg("/character/west.png");
      if (xPos % 64 == 0) {
        isWalkingLeft = false;
      } else {
        isWalkingLeft = true;
      }

    } else if ((keyH.rightPressed || isWalkingRight) && !isWalkingDown && !isWalkingLeft && !isWalkingUp) {
      xPos += speed;
      setImg("/character/east.png");
      if (xPos % 64 == 0) {
        isWalkingRight = false;
      } else {
        isWalkingRight = true;
      }
    }
  }
}
