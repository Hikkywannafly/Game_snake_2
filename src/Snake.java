import java.awt.*;

public class Snake {
    int lenghtS = 4;

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
        x[1] = 5;
        y[1] = 3;
        x[2] = 5;
        y[2] = 2;
        x[3] = 5;
        y[3] = 1;
    }
    public void setVector(int v){
        if(vector != -v){
            vector = v;
        }

    }
    public void move(){

        if(System.currentTimeMillis() - t1 >500){
            for(int i = lenghtS - 1 ; i>0; i--){
                x[i] = x[i-1];
                y[i] = y[i-1];
            }
//            for(int i = 1 ; i <= lenghtS; i++){
//                x[i] = x[i-2];
//                y[i] = y[i-2];
//            }
           if( vector == Snake.GO_UP) y[0]--;
            if( vector == Snake.GO_DOWN) y[0]++;
            if( vector == Snake.GO_LEFT) x[0]--;
            if( vector == Snake.GO_RIGHT) x[0]++;
            t1 = System.currentTimeMillis();
        }

    }
    public void paintSnake(Graphics g){

        for(int i = 0; i<lenghtS; i++){
            if( i == 0) g.setColor(new Color(0 ,205 ,0));
            else g.setColor(new Color(0, 255, 127));

                g.fillRect(x[i]*20 +2 ,y[i]*20 +2,20,20);

        }
    }
}
