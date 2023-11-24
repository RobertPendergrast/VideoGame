import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class GameApp extends JPanel implements KeyListener, ActionListener {
    int camX;
    int camY;
    int camdX;
    int camdY;
    int size;
    double middleIndex;
    boolean upPressed;
    boolean downPressed;
    boolean leftPressed;
    boolean rightPressed;
    TerrainGen Map;
    public GameApp(){
        Color background = new Color(77,166,255);
        setBackground(background);
        Map = new TerrainGen(200,60);
        camX = Map.getSpawn()*-50;
        middleIndex = 200/2;

        setLayout(new FlowLayout());
        setFocusable(true);
        addKeyListener(this);
        Timer timer = new Timer(1000 / 60, this);
        timer.start();
    }
    public void actionPerformed(ActionEvent e) {
        update();
    }

    public void update(){
        if(upPressed){
            camdY += 5;
        } if(downPressed){
            camdY -= 5;
        } if(leftPressed){
            if(middleIndex>10) {
                camdX += 5;
                middleIndex -= 0.1;
            }
        } if(rightPressed){
            if(middleIndex<190) {
                camdX -= 5;
                middleIndex += 0.1;
            }
        }

        camX += camdX;
        camY += camdY;
        camdX = (int)0.8*camdX;
        camdY = (int)0.8*camdY;
        //System.out.println(camX);


        //updates the terrain

        Block[][] World = Map.getBlockMap();
        for(int i = 0; i<Map.getWidth();i++){
            for(int j = 0; j<Map.getHeight(); j++){
                World[i][j].update(camX,camY);
            }
        }


        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //paints the terrain
        Block[][] world = Map.getBlockMap();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int left = (int)(middleIndex-1);
        int right = (int)(middleIndex+(screenSize.getWidth()/50)+1);
        for(int i = left; i< right; i++) {
            for (int j = 0; j < Map.getHeight(); j++) {
                //if(world[i][j].getX()>-100 && world[i][j].getX()<screenSize.width+100) { //bounds help with runtime
                  //  world[i][j].paint(g);
                //}
                world[i][j].paint(g);
            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {

        } else if (e.getKeyCode() == KeyEvent.VK_A) {

        } else if (e.getKeyCode() == KeyEvent.VK_S) {

        } else if (e.getKeyCode() == KeyEvent.VK_D) {

        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {

        } else if (e.getKeyCode() == KeyEvent.VK_PLUS) {

        } else if (e.getKeyCode() == KeyEvent.VK_PLUS) {

        } else if (e.getKeyCode() == KeyEvent.VK_MINUS) {
        }

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {

        } else if (e.getKeyCode() == KeyEvent.VK_A) {

        } else if (e.getKeyCode() == KeyEvent.VK_S) {

        } else if (e.getKeyCode() == KeyEvent.VK_D) {

        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {

        } else if (e.getKeyCode() == KeyEvent.VK_PLUS) {

        } else if (e.getKeyCode() == KeyEvent.VK_MINUS) {

        }
    }
}
