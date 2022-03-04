package Game;

import java.awt.*;

public class Animation {
    public Image[] images;
    public int n;//so anh
    public int currentImage;//thoi gian chuyen anh
    public Animation() {
       n=0;
       currentImage = 0;
    }
    //lay so animation
    public void addImage(Image image){
        Image [] ar = images;
        images = new Image[n +1];
        for(int i=0; i< n; i++) images[i] = ar[i];
        images[n] = image;
        n++;
//
    }
    //thiet lap lai tt animation
    public void update(){
        currentImage ++;
        if(currentImage>= n) currentImage = 0;
    }
    //lay vi tri cua animation
    public Image getCurrentImage(){
        return images[currentImage];
    }
}
