package beings;

import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public enum BeingImage {
    Snake("/snake.jpg"), Scorpion("/scorpion.jpg"), LittleMonster("/littlemonster.jpg"), RedOne("/redone.jpg"),
    OrangeOne("/orangeone.jpg"), YellowOne("/yellowone.jpg"), GreenOne("/greenone.jpg"), CyanOne("/cyanone.jpg"),
    BlueOne("/blueone.jpg"), PurpleOne("/purpleone.jpg"), Grandfather("/grandfather.jpg");
    private final String imageURL;
    private final Image image;
    BeingImage(String imageURL) {
        this.imageURL = imageURL;
        this.image = new Image(this.getClass().getResource(imageURL).toString());
    }
    @Deprecated
    public String getImageURL(){
        return imageURL;
    }

    public Image getImage(){
        return image;
    }
}
//RED("老大","红色"),ORANGE("老二","橙色"),YELLOW("老三","黄色"),GREEN("老四","绿色"),
//    CYAN("老五","青色"),BLUE("老六","蓝色"),PURPLE("老七","紫色");