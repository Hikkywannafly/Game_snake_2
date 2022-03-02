import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {
    GameFrame gameFrame;
    public GameScreen()  {
        setVisible(true);
        setSize(420,440);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame = new GameFrame();
        add(gameFrame);

    }

    public static void main(String[] args) {
        GameScreen gs = new GameScreen();
    }
}
