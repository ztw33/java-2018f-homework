package creature;

import javafx.scene.image.Image;

import java.net.URL;

public class Grandpa extends Creature {
    public Grandpa(){
        this.name = "爷爷";
        URL url = getClass().getResource("/image/grandpa.jpg");
        this.image = new Image(url.toString());
        this.camp=true;
    }
}
