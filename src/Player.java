import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class Player{
    public int health;
    public int xV;
    public int yV;
    public int xPos;
    public int yPos;

    hitbox hitbox;

    public Player(int maxHealth, int X, int Y, int xV, int yV){
        health = maxHealth;
        this.xV = xV;
        xPos = X;
        yPos = Y;
        this.yV = yV;
        hitbox = new hitbox(xPos,yPos,50);
    }
    public hitbox getHitbox(){
        return hitbox;
    }

    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }

    public int getxV(){
        return xV;
    }

    public int getyV(){
        return xV;
    }

}
