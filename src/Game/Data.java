package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Data {
    public static Image imageHead;
    public static Image imageTail;
    public static Image imageBody;
    public static Image imageFood;
    public static void loadImage(){
        try{
            File f = new File("src/res/head_down.png");
            imageHead = ImageIO.read(f);
            imageTail = ImageIO.read(new File("src/res/tail_up.png"));
            imageBody = ImageIO.read(new File("src/res/body_horizontal.png"));
            imageFood = ImageIO.read(new File("src/res/eimi.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
