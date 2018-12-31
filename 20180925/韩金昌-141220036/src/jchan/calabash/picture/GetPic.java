package jchan.calabash.picture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GetPic {
    public static BufferedImage getPic(char i){
        switch (i){
            case ' ':
                return PicPath.blank;
            case 'm':
                return PicPath.mountain;
            case '~':
                return PicPath.valley;
            case '*':
                return PicPath.oldman;
            case 'S':
                return PicPath.snake;
            case '0':
                return PicPath.dawa;
            case '1':
                return PicPath.erwa;
            case '2':
                return PicPath.sanwa;
            case '3':
                return PicPath.siwa;
            case '4':
                return PicPath.wuwa;
            case '5':
                return PicPath.liuwa;
            case '6':
                return PicPath.qiwa;
            case 'Y':
                return PicPath.scorpion;
            case 'z':
                return PicPath.toad;
            default:
                return PicPath.blank;
        }
    }
    public static final int PICSIZE = 40;
}
