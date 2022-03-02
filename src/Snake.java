import java.awt.*;

public class Snake {
    int lenghtS = 1;

    int x [];
    int y [];

    public Snake() {
        x = new int[20];
        y = new int[20];

        x[0] = 5;
        y[0] = 4;

    }
    public void update(){
        x[0]++;
    }
    public void paintSnake(Graphics g){
        g.setColor(Color.GREEN);
        for(int i =0; i<lenghtS; i++){
            g.fillRect(i*20 +2 ,i*20 +2,18,18);
        }
    }
    public void paint (Graphics g){
        paintSnake(g);

    }
}
