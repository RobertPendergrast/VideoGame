import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Block {
    private ImageIcon grass = new ImageIcon(getClass().getResource("/images/Grass.png"));
    private ImageIcon dirt = new ImageIcon(getClass().getResource("/images/Dirt.png"));
    public int x;
    public int y;
    public String id;
    public int size;

    public Block(int x, int y, String id, int size){
        this.x = x;
        this.y = y;
        this.id = id;
        this.size = size;
    }

    public void update(int xV, int yV){
        x = x + xV;
        y = y + yV;
    }

    public void paint(Graphics g){
        if(id.equals("grass")){
            g.drawImage(grass.getImage(),x,y,null);
        } else if(id.equals("dirt")){
            g.drawImage(dirt.getImage(),x,y,null);
        } else{
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getId(){
        return id;
    }
}
