package Creatures;

import javafx.scene.image.Image;

import java.net.URL;

public class Calabash extends Creature {
    //MARK: Properties;
    protected enum CalabashMember{

        Mem1("redOne","RED","/images/red.jpg"),
        Mem2("orangeOne","ORANGE","/images/orange.jpg"),
        Mem3("yellowOne","YELLOW","/images/yellow.jpg"),
        Mem4("greenOne","GREEN","/images/green.jpg"),
        Mem5("cyanOne","CYAN","/images/qing.jpg"),
        Mem6("blueOne","BLUE","/images/blue.jpg"),
        Mem7("purpleOne","PURPLE","/images/purple.jpg");

        public String name;
        public String color;
        public String imageUrl;
        public Image image;

        CalabashMember(String name, String color, String imageUrl){
            this.name = name;
            this.color = color;
            this.imageUrl = imageUrl;
            URL url = getClass().getResource(imageUrl);
            image = new Image(url.toString());
        }
    }

    private CalabashMember calabashMember;

    //MARK:initialize
    public Calabash(int n){
        super();
        calabashMember = CalabashMember.values()[n];
        name = calabashMember.name;
        image = calabashMember.image;
        isFriend = true;
    }

}