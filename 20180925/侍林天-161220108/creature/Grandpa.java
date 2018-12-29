package creature;

import javafx.scene.image.*;
import java.io.File;
import java.io.IOException;

public class Grandpa extends Creature {
    public Grandpa() {
        name = "爷爷";
        coordinateX = -1;
        coordinateY = -1;
        imgPath = "src\\image\\grandpa.jpg";
        image = new Image("image/grandpa.jpg");
    }
}
