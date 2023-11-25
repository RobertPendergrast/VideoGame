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
        Block[][] World = Map.getBlockMap();
        if(leftPressed){
            camdX -= 5;
            dir = 1;
        } if(rightPressed){
            camdX += 5;
            dir = 0;
        }
        camX += camdX;
        camdX = (int)(0.9*camdX);
        for(int i = 0; i<Map.getWidth();i++){
            for(int j = 0; j<Map.getHeight(); j++){
                World[i][j].update(camX,camY);
            }
        }
        for(int i = 0; i< World.length; i++) {
            for (int j = 0; j < Map.getHeight(); j++) {
                if(World[i][j].getx()>(camX-100)&&World[i][j].getx()<camX+1750) {
                    if(!World[i][j].getId().equals("AIR")) {
                        checkCollisionX(World[i][j]);
                    }
                }
            }
        }
        if(upPressed){
            camdY -= 5;
        } if(downPressed){
            camdY += 5;
        }
        camY += camdY;
        camdY = (int)(camdY*0.9);
        for(int i = 0; i<Map.getWidth();i++){
            for(int j = 0; j<Map.getHeight(); j++){
                World[i][j].update(camX,camY);
            }
        }
        for(int i = 0; i< World.length; i++) {
            for (int j = 0; j < Map.getHeight(); j++) {if(World[i][j].getx()>(camX-100)&&World[i][j].getx()<camX+1750) {
                    if(!World[i][j].getId().equals("AIR")) {
                        checkCollisionY(World[i][j]);
                    }
                }
            }
        }
        repaint();
    }

    //I feel like the checkCollision methods should be in a different class...
    //Ideally the player should be what's checking the collisions with terrain, but since the
    //terrain is moving and not the player, the terrain check collisions with the player.
    //For enemies and other objects, they would check collisions with the terrain since the
    //terrain does not move around them.
    public void checkCollisionX(Block block){
        //we need the boundries around the player
        int playerLeft = Player.getX();
        int playerRight = playerLeft+50;
        int playerUp = Player.getY();
        int playerDown = playerUp + 50;
        //we also need the boundies of the block
        int blockLeft = block.getX();
        int blockRight = blockLeft + 50;
        int blockUp = block.getY();
        int blockDown = blockUp + 50;
        //two if statements: 1 if the player is on the same horizontal level as the block.
        //2 if the player is inside the block
        if(((playerDown>=blockUp)&&(playerDown<=blockDown))||((playerUp<=blockDown)&&(playerUp>=blockUp))){
            if(playerLeft<blockRight&&playerRight>blockRight){
                camX = block.getx()-800;
                camdX = 0;
            } if(playerRight>blockLeft&&playerLeft<blockLeft){
                camX = block.getx()-910;
                camdX = 0;
            }
        }
        //System.out.println("miss");
    }

    public void checkCollisionY(Block block){
        int playerLeft = Player.getX();
        int playerRight = playerLeft+50;
        int playerUp = Player.getY();
        int playerDown = playerUp + 50;
        //we also need the boundies of the block
        int blockLeft = block.getX();
        int blockRight = blockLeft + 50;
        int blockUp = block.getY();
        int blockDown = blockUp + 50;
        //two if statements: 1 if the player is on the same horizontal level as the block.
        //2 if the player is inside the block
        if(((playerLeft<=blockRight)&&(playerLeft>=blockLeft))||((playerRight>=blockLeft)&&(playerRight<=blockRight))){
            if(playerDown>blockUp&&playerUp<blockUp){
                camY -= camdY;
                camY = block.gety()-610;
                camdY = 0;
//                if(upPressed){
//                    camdY = -15;
//                }
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
        for(int i = 0; i< world.length; i++) {
            for (int j = 0; j < Map.getHeight(); j++) {
                if(world[i][j].getx()>(camX-100)&&world[i][j].getx()<camX+1750) {
                    world[i][j].paint(g);
                }
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
