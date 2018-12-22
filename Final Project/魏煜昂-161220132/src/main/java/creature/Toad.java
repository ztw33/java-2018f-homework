package creature;

import javafx.scene.image.Image;

import java.net.URL;

public class Toad extends Creature {
    public Toad(){
        this.name = "蛤蟆";
        URL url = getClass().getResource("/image/toad.jpg");
        this.image = new Image(url.toString());
        this.camp=false;
    }
}
