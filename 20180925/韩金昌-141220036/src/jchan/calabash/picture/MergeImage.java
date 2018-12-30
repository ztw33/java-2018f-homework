package jchan.calabash.picture;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MergeImage {
    public static BufferedImage mergeImagex(Image[] images,int n,int width,int height){
        BufferedImage image = new BufferedImage(width * n,height,BufferedImage.TYPE_INT_ARGB);
        Graphics graph = image.createGraphics();
        for(int i = 0;i < n;i++){
            graph.drawImage(images[i],i * width,0,width,height,null);
        }
        graph.dispose();
        return image;
    }
    public static BufferedImage mergeImagey(Image[] images,int n,int width,int height){
        BufferedImage image = new BufferedImage(width,height * n,BufferedImage.TYPE_INT_ARGB);
        Graphics graph = image.createGraphics();
        for(int i = 0;i < n;i++){
            graph.drawImage(images[i],0,i * height,width,height,null);
        }
        graph.dispose();
        return image;
    }
    public static BufferedImage mergeImage(Image[][] images,int m,int n){
        BufferedImage[] imagesx = new BufferedImage[n];
        for(int i = 0;i < m;i++){
            imagesx[i] = mergeImagex(images[i],n,GetPic.PICSIZE,GetPic.PICSIZE);
        }
        BufferedImage image = mergeImagey(imagesx,m,GetPic.PICSIZE * n,GetPic.PICSIZE);
        return image;
    }
}