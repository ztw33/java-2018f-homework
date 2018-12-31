package creature;
import java.io.*;
import javafx.scene.image.*;
public class Demon extends Creature {
    public Demon() {
        name = "小喽喽";
        coordinateX = -1;
        coordinateY = -1;
        imgPath = "src\\image\\loulou.jpg";
        image = new Image("image/loulou.jpg");


    }
    public Demon (String name) {
        this.name = name;
        coordinateX = -1;
        coordinateY = -1;
        imgPath = "src\\image\\loulou.jpg";
        image = new Image("image/loulou.jpg");
    }
}
