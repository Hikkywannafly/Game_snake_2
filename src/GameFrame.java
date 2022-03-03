import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class GameFrame extends JPanel implements Runnable {
    int [] [] bg = new int[20][20];
    Thread thread;
    Snake snake;
    public GameFrame() {
        snake = new Snake();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
       // super.paintComponents(g);
        paintBg(g);
        snake.paintSnake(g);
    }
    public void paintBg(Graphics g){

        for(int i =0; i<20; i++){
            for(int j = 0; j<20; j++){
                if(bg[i][j] == 0) g.setColor(Color.gray);
                if(bg[i][j] == 1) g.setColor(Color.GREEN);
                if(bg[i][j] == 2) g.setColor(Color.RED);
                g.fillRect(i*20 +2 ,j*20 +2,18,18);
            }
        }
    }
    @Override
    public void run(){
        while(true){

            snake.update();
            repaint();
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
