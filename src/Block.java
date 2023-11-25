import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Block {
    public ImageIcon grassIcon = new ImageIcon(getClass().getResource("/images/grass.png"));
    public ImageIcon dirtIcon = new ImageIcon(getClass().getResource("/images/dirt.png"));

    public Image grassImage;
    public Image dirtImage;

    public Image scaledGrass;
    public Image scaledDirt;

    public int xPos;
    public int yPos;
    public int x;
    public int y;
    public String id;
    public int size;

    hitbox hitbox;

    public Block(int x, int y, String id, int size){
        this.x = x;
        this.y = y;
        this.id = id;
        this.size = size;

        hitbox = new hitbox(x,y,size);

        grassImage = grassIcon.getImage();
        dirtImage = dirtIcon.getImage();

        scaleImages();
    }

    public void scaleImages(){
        scaledGrass = grassImage.getScaledInstance(size,size, Image.SCALE_DEFAULT);
        scaledDirt = dirtImage.getScaledInstance(size,size, Image.SCALE_DEFAULT);
    }

    public void update(int xV, int yV){
        xPos = x - xV;
        yPos = y -yV;
        hitbox.update(xPos,yPos,size);
    }

    public void paint(Graphics g){

        if(id.equals("grass")){
            //scaledGrass.paintIcon(null, g, xPos, yPos);
            g.drawImage(scaledGrass,xPos,yPos,null);
        } else if(id.equals("dirt")){
            g.drawImage(scaledDirt,xPos,yPos,null);
            //scaledDirt.paintIcon(null, g, xPos, yPos);
        } else{
        }
    }


    public int getX(){
        return xPos;
    }

    public int getY(){
        return yPos;
    }

    public int getx(){
        return x;
    }

    public int gety(){
        return y;
    }

    public String getId(){
        return id;
    }

    public hitbox getHitbox(){
        return hitbox;
    }
    
    public int getSize(){return size;}
}
