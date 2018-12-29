package creature;

import javafx.scene.image.*;
import java.io.File;
import java.io.IOException;

public class Scorpion extends Demon {
    public Scorpion() {
        name = "蝎子精";
        coordinateX = -1;
        coordinateY = -1;
        imgPath = "src\\image\\scorpion.jpg";
        image = new Image("image/scorpion.jpg");
    }
}
