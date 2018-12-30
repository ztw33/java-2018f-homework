package creature.BadCreature;

import creature.Creature;
import javafx.scene.image.Image;

public class ScorpionEssence extends Creature {
    private boolean isGoodCreature = false;

    @Override
    public String toString(){
        return "蝎子精";
    }

    @Override
    public Image getImage() {
        super.getImage();
        String url = "pic/" + "蝎子精" + ".png";
        return new Image(url);
    }

    @Override
    protected void fight() {

    }
}
