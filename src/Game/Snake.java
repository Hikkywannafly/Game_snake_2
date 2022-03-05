package Game;

import java.awt.*;
import java.util.Random;

public class Snake {
    int lenghtS = 3;

    int x[];
    int y[];
    public static int GO_UP = 1;
    public static int GO_DOWN = -1;
    public static int GO_LEFT = 2;
    public static int GO_RIGHT = -2;
    int vector = Snake.GO_DOWN;

    long t1 = 0;
    long t2 = 0;
    int speed = 200;
    int maxLen = 10;
    boolean udAfterChangeVt = true;
    public Snake() {
        x = new int[20];
        y = new int[20];

        x[0] = 2;
        y[0] = 3;
        x[1] = 2;
        y[1] = 2;
        x[2] = 2;
        y[2] = 1;
    }
    public void resetGame() {
        x = new int[20];
        y = new int[20];

        x[0] = 5;
        y[0] = 4;
        x[1] = 5;
        y[1] = 4;
        x[2] = 5;
        y[2] = 2;
        int lenghtS = 3;
        int vector = Snake.GO_DOWN;
    }
    public void setVector(int v) {
        if (vector != -v && udAfterChangeVt) {
            vector = v;
            udAfterChangeVt = false;
        }

    }

    public boolean locationSnake(int x, int y) {
        for (int i = 0; i < lenghtS; i++) {
            if (this.x[i] == x && this.y[i] == y) return true;
        }
        return false;
    }

    //toa do moi ngau nhien
    public Point getLocationFood() {
        Random random = new Random();
        int x;
        int y;
        do {
            x = random.nextInt(19);
            y = random.nextInt(19);
        }
        while (locationSnake(x, y));


        return new Point(x, y);
    }
    public int getCurrentSpeed() {
        int speed = 200;
        for(int i = 0; i<GameFrame.currenLevel; i++)
            speed -= 50;
            return speed;
    }

    //ham ran di chuyen
    public void move() {
        if(lenghtS == maxLen){
           GameFrame.isplaying = false;
            resetGame();
           GameFrame.currenLevel ++;
            maxLen += 5;
           speed = getCurrentSpeed();
        }

        for(int i = 1; i< lenghtS; i++ ){
            if(x[0]==x[i]&&y[0]==y[i]){


             GameFrame.isplaying = false;
             GameFrame.isGameOver = true;




            }
        }

        if (System.currentTimeMillis() - t1 > speed ) {
            if (GameFrame.bg[x[0]][y[0]] == 2) {
                lenghtS++;
                GameFrame.bg[x[0]][y[0]] = 0;
                GameFrame.bg[getLocationFood().x][getLocationFood().y] = 2;

            }
            for (int i = lenghtS - 1; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }

            if (vector == Snake.GO_UP) y[0]--;
            if (vector == Snake.GO_DOWN) y[0]++;
            if (vector == Snake.GO_LEFT) x[0]--;
            if (vector == Snake.GO_RIGHT) x[0]++;
            t1 = System.currentTimeMillis();
            if (x[0] < 0) x[0] = 19;
            if (x[0] > 19) x[0] = 0;
            if (y[0] < 0) y[0] = 19;
            if (y[0] > 19) y[0] = 0;
        }

    }

    //        }
    //ve ran
    public void paintSnake(Graphics g) {

        for (int i = 1; i <=  lenghtS - 1; i++) {
            if (i == 0) g.setColor(new Color(0, 205, 0));
            else g.setColor(new Color(0, 255, 127));

            g.drawImage(Data.imageBody,x[i]*20 -7 + GameFrame.padding ,y[i]*20 -7 + GameFrame.padding,null);
            ///Data.loadImage(); không de o day cham chuong trinh
            if (vector == Snake.GO_RIGHT) {
                g.drawImage(Data.imageHeadRight, x[0] * 20 -7 + GameFrame.padding , y[0] * 20 -7 + GameFrame.padding, null);
            } else if (vector == Snake.GO_LEFT) {
                g.drawImage(Data.imageHeadLeft, x[0] * 20 -7 + GameFrame.padding , y[0] * 20 -7 + GameFrame.padding, null);
            } else if (vector == Snake.GO_DOWN) {
                g.drawImage(Data.imageHeadDown, x[0] * 20 -7 + GameFrame.padding, y[0] * 20 -7 + GameFrame.padding, null);
            } else if (vector == Snake.GO_UP) {
                g.drawImage(Data.imageHeadUp, x[0] * 20 -7 + GameFrame.padding, y[0] * 20 -7 + GameFrame.padding, null);
            }
            udAfterChangeVt = true;

        }
    }
}

