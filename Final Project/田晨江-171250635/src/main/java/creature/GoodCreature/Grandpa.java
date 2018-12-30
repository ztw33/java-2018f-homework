package creature.GoodCreature;

import creature.Creature;
import javafx.scene.image.Image;

public class Grandpa extends Creature {

    private boolean isGoodCreature = true;

    @Override
    public String toString() {
        return "老爷爷";
    }

    @Override
    public Image getImage() {
        super.getImage();
        String url = "pic/" + "grandpa" + ".png";
        return new Image(url);
    }
}
