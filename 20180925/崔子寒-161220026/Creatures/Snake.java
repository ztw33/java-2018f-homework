package Creatures;

import javafx.scene.image.Image;

public class Snake extends Creature implements Cheer {
    public Snake() {
        image = new Image("resourceFiles/snake.jpg");
    }
    public void outputInfo() {
        System.out.print("蛇精");
    }

    public void cheer(){}

    public String toString() {
        return "蛇精";
    }

    @Override
    public Image getImage() {
        return image;
    }
}
