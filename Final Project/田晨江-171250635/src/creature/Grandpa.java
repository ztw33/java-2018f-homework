package creature;

import javafx.scene.image.Image;

public class Grandpa extends Creature{

    @Override
    public String toString() {
        return "老爷爷";
    }

    @Override
    public Image getImage() {
        String url = "resources/pic/" + "grandpa" + ".png";
        return new Image(url);
    }
}
