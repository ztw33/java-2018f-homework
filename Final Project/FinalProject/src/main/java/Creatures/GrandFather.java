package Creatures;

import javafx.scene.image.Image;

import java.net.MalformedURLException;
import java.net.URL;

public class GrandFather extends Creature{

    //MARK:Properties;
    String imageURL = "/images/grandfather.jpg";

    //MARK:initialize;
    public GrandFather(){
        name = "grandFather";
        URL url = getClass().getResource(imageURL);
        image = new Image(url.toString());
        isFriend = true;
    }
}
