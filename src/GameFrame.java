import javax.swing.*;
import java.awt.*;

public class GameFrame extends JPanel implements Runnable {
    int score;
    static int [] [] bg = new int[20][20];
    Thread thread;
    Snake snake;
    public GameFrame() {
        snake = new Snake();
        bg [10] [10] =2;
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
        g.setColor(Color.white); // luoi
        for(int i =0; i<20; i++){
            for(int j = 0; j<20; j++){
                g.fillRect(i*20+2  ,j*20+2,20,20);
                if(bg[i][j] == 2){
                    g.setColor(Color.RED);
                    g.fillOval(i*20+2  ,j*20+2,20,20);
                    g.setColor(Color.white);
                }
            }
        }
    }
    @Override
    public void run(){
        while(true){
            snake.move();
            repaint();
            try {
                thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
