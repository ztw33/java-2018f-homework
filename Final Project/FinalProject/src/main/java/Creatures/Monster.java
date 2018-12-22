package Creatures;

import javafx.scene.image.Image;

import java.net.URL;

public class Monster extends Creature {

    //MARK:Properties;
    String imageURL = "/images/monster.jpg";

    //MARK:initialize;
    public Monster() {
        name = "monster";
        URL url = getClass().getResource(imageURL);
        image = new Image(url.toString());
        isFriend = false;
    }

}
