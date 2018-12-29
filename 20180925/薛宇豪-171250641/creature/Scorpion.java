package creature;

import javafx.scene.image.Image;

public class Scorpion extends Demon implements Fight {
    public Scorpion(){
        super("蝎子精",new Image("/images/蝎子精.png"));
    }

    @Override
    public void fight() {

    }
}
