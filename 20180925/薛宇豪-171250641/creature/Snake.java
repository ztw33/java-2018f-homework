package creature;

import javafx.scene.image.Image;

public class Snake extends Demon implements Cheer {
    public Snake(){
        super("蛇精",new Image("/images/蛇精.png"));
    }

    @Override
    public void cheer() {

    }
}
