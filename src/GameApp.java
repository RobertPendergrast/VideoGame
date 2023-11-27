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
    public int dir;

    public int left;
    public int right;

    TerrainGen Map;
    Player Player;
    public ImageIcon backIcon = new ImageIcon(this.getClass().getResource("/images/background.png"));
    public Image backgroundImage;

    public ImageIcon playerRIcon = new ImageIcon(this.getClass().getResource("/images/PlayerRight.png"));
    public Image playerRImage;
    public ImageIcon playerLIcon = new ImageIcon(this.getClass().getResource("/images/PlayerLeft.png"));
    public Image playerLImage;
    public GameApp(){
            Color background = new Color(77,166,255);
            setBackground(background);
        Map = new TerrainGen(200,60);
        camX = Map.getSpawn()*50;
        camY = 20;
        middleIndex = 200/2;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Player = new Player(50,screenSize.width/2, (int)(screenSize.height/2),0,0);
        int originalWidth = backIcon.getIconWidth();
        int originalHeight = backIcon.getIconHeight();
        int playerWidth = playerLIcon.getIconWidth();
        int playerHeight = playerLIcon.getIconHeight();
        dir = 0;
        backgroundImage = backIcon.getImage().getScaledInstance(originalWidth * 4, originalHeight * 4, Image.SCALE_DEFAULT);
        playerRImage = playerRIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        playerLImage = playerLIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        //backgroundImage = backIcon.getImage().getScaledInstance(X,X, Image.SCALE_DEFAULT);
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
        if(leftPressed){    //move camera left
            camdX = -5;
            dir = 1;
        } if(rightPressed){ //move camera right
            camdX = 5;
            dir = 0;
        }
        camdX = (int)(0.9*camdX);
        camdY += 1;
        camX += camdX;
        camY += camdY;

        Block[][] World = Map.getBlockMap(); //save copy of the terrain
        checkcollision();

        left = camX/50;
        right = left+36;

        for(int i = 0; i<Map.getWidth();i++){
            for(int j = 0; j<Map.getHeight(); j++){
                World[i][j].update(camX,camY);
            }
        }

        repaint();
    }

    public void checkcollision(){
        Block[][] World = Map.getBlockMap();
        int xLeft = Player.getX();
        int xRight = xLeft+50;
        int yTop = Player.getY();
        int yBottom = yTop + 50;

        for(int i = left; i<right; i++){
            for(int j = 0; j<Map.getHeight(); j++){
                int x = World[i][j].getX();
                int y = World[i][j].getY();
                int xR = x+World[i][j].getSize();
                int yB = y+World[i][j].getSize();

                if(!World[i][j].getId().equals("AIR")){
                    if((yBottom+camdY>=y)&&(yBottom+camdY<=yB)&&(xRight>=x)&&(xLeft<=xR)){
                        if(upPressed){
                            camY += 1;
                            camdY -=15;
                        } else{
                            camY = camY - (camdY+0);
                            camdY = 0;
                        }
                    } else if((yTop>=yB)&&(yTop<=y)&&(xRight>=x)&&(xLeft<=xR)){
                        camY = camY - camdY;
                        camdY = 0;
                    }
                    if((xRight+camdX>=x)&&(xRight+camdX<=xR)&&(yBottom>=y)&&(yTop<=yB)){
                        camX = camX-camdX;
                        camdX = 0;
                    } else if((xLeft+camdX>=x)&&(xLeft+camdX<=xR)&&(yBottom>=y)&&(yTop<=yB)){
                        camX = camX-camdX;
                        camdX = 0;
                    }
                }
            }
        }
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backgroundImage,0,200,null);
        g.drawImage(backgroundImage,800,200,null);
        g.drawImage(backgroundImage,1600,200,null);

        g.setColor(Color.BLACK);
        g.fillRect(Player.getX(), Player.getY(), 50,50);

        if(dir == 0) {
            g.drawImage(playerRImage, Player.getX(), Player.getY(), null);
        } else{
            g.drawImage(playerLImage, Player.getX(), Player.getY(), null);
        }
        //paints the terrain
        Block[][] world = Map.getBlockMap();
        for(int i = left; i< right; i++) {
            for (int j = 0; j < Map.getHeight(); j++) {
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
