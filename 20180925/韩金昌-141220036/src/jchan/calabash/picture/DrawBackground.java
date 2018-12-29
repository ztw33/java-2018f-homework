package jchan.calabash.picture;

import jchan.calabash.calabashworld.Field;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawBackground {
    public static BufferedImage drawBackground(Field field,int x, int y, int m, int n){
        BufferedImage[][] backimages= new BufferedImage[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                backimages[i][j] = GetPic.getPic(field.cells[i][j][0].whoami());
            }
        }
        return(MergeImage.mergeImage(backimages,m,n));
    }
}
