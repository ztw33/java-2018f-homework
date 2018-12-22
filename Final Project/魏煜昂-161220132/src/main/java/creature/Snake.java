package creature;

import javafx.scene.image.Image;

import java.net.URL;

public class Snake extends Creature {
    public Snake(){
        this.name = "蛇精";
        URL url = getClass().getResource("/image/snake.jpg");
        this.image = new Image(url.toString());
        this.camp=false;
    }
}
