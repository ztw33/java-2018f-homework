package Creatures;

import javafx.scene.image.Image;

public class Monster extends Creature {
    public Monster() {
        image = new Image("resourceFiles/monster.png");
    }
    public void outputInfo() {
        System.out.print("小怪");
    }
    public String toString() {
        return "小怪";
    }

    @Override
    public Image getImage() {
        return image;
    }
}
