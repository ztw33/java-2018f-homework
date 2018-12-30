package Creatures;

import javafx.scene.image.Image;

public class Grandfather extends Creature implements Cheer {
    public Grandfather() {
        image = new Image("resourceFiles/grandfather.jpg");
    }
    public void outputInfo() {
        System.out.print("爷爷");
    }

    public void cheer(){}
    public String toString() {
        return "爷爷";
    }

    @Override
    public Image getImage() {
        return image;
    }
}
