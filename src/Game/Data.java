package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Data {
    public static Image imageHeadDown;
    public static Image imageHeadUp;
    public static Image imageHeadLeft;
    public static Image imageHeadRight;

    public static Image imageTailDown;
    public static Image imageTailUp;
    public static Image imageTailLeft;
    public static Image imageTailRight;
    public static Image imageBody;
    public static Image imageFood;
    public static void loadImage(){
        try{

           //dau
            imageHeadDown = ImageIO.read(new File("src/res/head_down.png"));
            imageHeadUp = ImageIO.read(new File("src/res/head_up.png"));
            imageHeadLeft = ImageIO.read(new File("src/res/head_left.png"));
            imageHeadRight = ImageIO.read(new File("src/res/head_right.png"));

            //duoi
            imageTailUp = ImageIO.read(new File("src/res/tail_up.png"));
            imageTailDown = ImageIO.read(new File("src/res/tail_down.png"));
            imageTailLeft = ImageIO.read(new File("src/res/tail_left.png"));
            imageTailRight = ImageIO.read(new File("src/res/tail_right.png"));

            imageBody = ImageIO.read(new File("src/res/snakeStraightBody.png"));
            imageFood = ImageIO.read(new File("src/res/eimi.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
