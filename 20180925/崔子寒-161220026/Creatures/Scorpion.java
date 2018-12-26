package Creatures;

import javafx.scene.image.Image;

public class Scorpion extends Creature{
    public Scorpion() {
        image = new Image("resourceFiles/scorpion.png");
    }
    public void outputInfo() {
        System.out.print("蝎子");
    }
    public String toString() {
        return "蝎子";
    }

    @Override
    public Image getImage() {
        return image;
    }
}
