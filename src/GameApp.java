import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class GameApp extends JPanel implements KeyListener, ActionListener {
    public GameApp(){
        Color background = new Color(77,166,255);
        setBackground(background);

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
        repaint();
    }

    public void paintComponent(Graphics g){

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

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

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

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
