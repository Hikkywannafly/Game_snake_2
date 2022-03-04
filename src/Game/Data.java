package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Data {
    public static Animation animation;
    public static BufferedImage sprite; // cat hinh


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

    public static Image imageWorm;

    public static Image imageWorm2;
    public static Image imageWorm3;
    public static Animation Worm;
    public static void loadImage(){
        try{
            sprite = ImageIO.read(new File("src/res/sprite1.png"));
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
            //moi

            imageWorm = sprite.getSubimage(2,40,30,30);
            imageWorm2 = sprite.getSubimage(32,40,30,30);
            imageWorm3 = sprite.getSubimage(63,40,30,30);
           // imageWorm = sprite.getSubimage(2,40,30,30);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void loadAllAnim(){
        Worm = new Animation();
        Worm.addImage(imageWorm);
        Worm.addImage(imageWorm2);
        Worm.addImage(imageWorm3);
        Worm.addImage(imageWorm2);

    }
}
