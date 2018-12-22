package Creatures;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

public class Scorpion extends Creature {

    //MARK:Properties;
    String imageURL = "/images/scorpion.jpg";

    //MARK:function
    public Scorpion(){
        name = "scorpion";
        URL url = getClass().getResource(imageURL);
        image = new Image(url.toString());
        isFriend = false;
    }

}
