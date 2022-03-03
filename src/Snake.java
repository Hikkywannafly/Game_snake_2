import java.awt.*;

public class Snake {
    int lenghtS = 1;

    int x [];
    int y [];
    public static int GO_UP = 0;
    public static int GO_DOWN = 1;
    public static int GO_LEFT = 2;
    public static int GO_RIGHT = 3;
    int vector = Snake.GO_DOWN;

    long t1 = 0;
    public Snake() {
        x = new int[20];
        y = new int[20];

        x[0] = 5;
        y[0] = 4;

    }
    public void setVector(int v){
        vector = v;
    }
    public void update(){
        if(System.currentTimeMillis() - t1 >500){
           if( vector == Snake.GO_UP) y[0]--;
            if( vector == Snake.GO_DOWN) y[0]++;
            if( vector == Snake.GO_LEFT) x[0]--;
            if( vector == Snake.GO_RIGHT) x[0]++;
            t1 = System.currentTimeMillis();
        }

    }
    public void paintSnake(Graphics g){
        g.setColor(Color.GREEN);
        for(int i = 0; i<lenghtS; i++){
            g.fillRect(x[i]*20 +2 ,y[i]*20 +2,18,18);
        }
    }
}
