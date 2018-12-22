package Creatures;

import javafx.scene.image.Image;

import java.net.URL;

public class Snake extends Creature{

    //MARK:Properties;
    String imageURL = "/images/snake.jpg";

    //MARK:Initialize;
    public Snake(){
        name = "snake";
        URL url = getClass().getResource(imageURL);
        image = new Image(url.toString());
        isFriend = false;
    }

}
