package creature;

import javafx.scene.image.Image;

public class Minions extends Demon implements Fight {
    public Minions(){
        super("小喽啰",new Image("/images/小喽啰.png"));
    }

    @Override
    public void fight() {
        //nothing to do
    }
}
