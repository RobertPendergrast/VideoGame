import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Engine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        GameApp app = new GameApp();
        frame.add(app, BorderLayout.CENTER);
        frame.setSize(screenSize.width, screenSize.height);
        frame.setVisible(true);
    }
}