package jchan.calabash.picture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PicPath{
    public static final String BLANK = "pic/blank.jpg";
    public static final String MOUNTAIN = "pic/mountain.jpg";
    public static final String VALLEY = "pic/valley.jpg";
    public static final String OLDMAN = "pic/oldman.jpg";
    public static final String SNAKE = "pic/snake.jpg";
    public static final String SCORPION = "pic/scorpion.jpg";
    public static final String TOAD = "pic/toad.jpg";
    public static final String DAWA = "pic/dawa.png";
    public static final String ERWA = "pic/erwa.png";
    public static final String SANWA = "pic/sanwa.png";
    public static final String SIWA = "pic/siwa.png";
    public static final String WUWA = "pic/wuwa.png";
    public static final String LIUWA = "pic/liuwa.png";
    public static final String QIWA = "pic/qiwa.png";
    public static BufferedImage blank;
    public static BufferedImage mountain;
    public static BufferedImage valley;
    public static BufferedImage oldman;
    public static BufferedImage snake;
    public static BufferedImage scorpion;
    public static BufferedImage toad;
    public static BufferedImage dawa;
    public static BufferedImage erwa;
    public static BufferedImage sanwa;
    public static BufferedImage siwa;
    public static BufferedImage wuwa;
    public static BufferedImage liuwa;
    public static BufferedImage qiwa;
    public static void initialImage(){
        try {
            blank = ImageIO.read(new File(BLANK));
            mountain = ImageIO.read(new File(MOUNTAIN));
            valley = ImageIO.read(new File(VALLEY));
            oldman = ImageIO.read(new File(OLDMAN));
            snake = ImageIO.read(new File(SNAKE));
            scorpion = ImageIO.read(new File(SCORPION));
            toad = ImageIO.read(new File(TOAD));
            dawa = ImageIO.read(new File(DAWA));
            erwa = ImageIO.read(new File(ERWA));
            sanwa = ImageIO.read(new File(SANWA));
            siwa = ImageIO.read(new File(SIWA));
            wuwa = ImageIO.read(new File(WUWA));
            liuwa = ImageIO.read(new File(LIUWA));
            qiwa = ImageIO.read(new File(QIWA));
        } catch(IOException e){
            System.out.println(e);
        }
    }

}