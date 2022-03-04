package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JPanel implements Runnable {
    int score;
    static int [] [] bg = new int[20][20];
    static int padding = 10;
    static int WIDTH = 400;
    static int HEIGHT = 400;
    static boolean isplaying = false;
    static boolean enableTextStartGame = true ;
    Thread thread;
    Snake snake;
    public GameFrame() {
        snake = new Snake();
        Data.loadImage();
        Data.loadAllAnim();

        bg [10] [10] =2;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
       // super.paintComponents(g);
        paintBg(g);
        snake.paintSnake(g);
        drawFrame(g);
        if(!isplaying){
            if(enableTextStartGame){
                g.setColor(Color.GREEN);
                g.setFont(g.getFont().deriveFont(18.0f));
                g.drawString("PLS PRESS SPACE TO PLAY GAME", 60,150);
            }

        }
    }
    //luoi do an;
    public void paintBg(Graphics g){
        g.setColor(Color.BLACK);; // luoi
        g.fillRect(1,1,WIDTH+padding*2, HEIGHT +padding*2);
        for(int i =0; i<20; i++){
            for(int j = 0; j<20; j++){

                if(bg[i][j] == 2){
                    g.setColor(Color.RED);
                    g.drawImage(Data.Worm.getCurrentImage(), i*20-7 +padding,j*20-7 + padding,null);
                    g.setColor(Color.BLACK);
                }
            }
        }
    }

    private void drawFrame(Graphics g){
        g.setColor(Color.GREEN);
        g.drawRect(0,0,WIDTH+padding*2, HEIGHT +padding*2);
        g.drawRect(0,0,WIDTH+padding*2 -2 , HEIGHT +padding*2 -2 );
        g.drawRect(0,0,WIDTH+padding*2 -4 , HEIGHT +padding*2 - 4 );
    }
    @Override
    public void run(){
        long t =0;
        long t2 = 0;

        while(true){
            if(System.currentTimeMillis() -t2 > 200){
                enableTextStartGame =! enableTextStartGame;
                t2 = System.currentTimeMillis();
            }

            if(isplaying){
                if(System.currentTimeMillis() -t >200){
                    Data.Worm.update();
                    t= System.currentTimeMillis();
                }
                snake.move();
            }

            repaint();
            try {
                thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
