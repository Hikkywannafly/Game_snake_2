package Game;

import java.awt.*;
import java.util.Random;

public class Snake {
    int lenghtS = 3;

    int x [];
    int y [];
    public static int GO_UP = 1;
    public static int GO_DOWN = -1;
    public static int GO_LEFT = 2;
    public static int GO_RIGHT = -2;
    int vector = Snake.GO_DOWN;

    long t1 = 0;
    public Snake() {
        x = new int[20];
        y = new int[20];

        x[0] = 5;
        y[0] = 4;
    }
    public void setVector(int v){
        if(vector != -v){
            vector = v;
        }

    }
    public boolean locationSnake( int x , int y){
        for(int i =0 ; i<lenghtS; i++){
            if( this.x[i] == x && this.y[i] == y) return true;
        }
        return false;
    }
    //toa do moi ngau nhien
    public Point getLocationFood(){
        Random random  = new Random();
        int x;
        int y;
        do{
             x = random.nextInt(19);
             y = random.nextInt(19);
        }
        while(locationSnake(x,y));


        return new Point(x,y);
    }
    //ham ran di chuyen
    public void move(){
        int counter = 0;
        if(System.currentTimeMillis() - t1 >100){
            if(GameFrame.bg [x[0]] [y[0]] == 2){
                lenghtS++;
                counter ++ ;
               GameFrame.bg [x[0]] [y[0]] = 0;
               GameFrame.bg[getLocationFood().x] [getLocationFood().y] = 2;

            }
            for(int i = lenghtS - 1 ; i>0; i--){
                x[i] = x[i-1];
                y[i] = y[i-1];
            }

            if( vector == Snake.GO_UP) y[0]--;
            if( vector == Snake.GO_DOWN) y[0]++;
            if( vector == Snake.GO_LEFT) x[0]--;
            if( vector == Snake.GO_RIGHT) x[0]++;
            t1 = System.currentTimeMillis();
            if (x[0] < 0) x[0] =19;
            if (x[0] > 19) x[0] =0;
            if (y[0] < 0) y[0] =19;
            if (y[0] > 19) y[0] =0;
            System.out.println(counter);
        }

    }
    //        }
    //ve ran
    public void paintSnake(Graphics g){

        for(int i = 1; i<lenghtS-1; i++){
            if( i == 0) g.setColor(new Color(0 ,205 ,0));
            else g.setColor(new Color(0, 255, 127));

                //g.fillRect(x[i]*20 +2 ,y[i]*20 +2,20,20);
                ///Data.loadImage(); không de o day cham chuong trinh
                g.drawImage(Data.imageBody,x[i]*20 +2,y[i]*20 +2,null);
                g.drawImage(Data.imageHead,x[0]*20 +2,y[0]*20 +2,null);
                g.drawImage(Data.imageTail,x[lenghtS-1]*20 +2,y[lenghtS-1]*20 +2,null);


        }
    }
}
