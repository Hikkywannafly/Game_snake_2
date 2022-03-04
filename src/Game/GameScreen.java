package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JFrame {
    GameFrame gameFrame;

    public GameScreen()  {
        setSize(420,440);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame = new GameFrame();
        add(gameFrame);
        this.addKeyListener(new handler());
        setVisible(true);
    }

    public static void main(String[] args) {
        GameScreen gs = new GameScreen();
    }
    private class handler implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Da Nhan");

            if(e.getKeyCode() == KeyEvent.VK_UP){
                gameFrame.snake.setVector(Snake.GO_UP);
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                gameFrame.snake.setVector(Snake.GO_DOWN);
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                gameFrame.snake.setVector(Snake.GO_LEFT);
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                gameFrame.snake.setVector(Snake.GO_RIGHT);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
