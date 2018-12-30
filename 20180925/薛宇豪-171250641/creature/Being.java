package creature;

import javafx.scene.image.Image;

public class Being {
    private String name;
    private Image image;
    public Being(String name,Image image){
        this.name=name;
        this.image=image;
    }
    public String getName(){
        return this.name;
    }
    public Image getImage(){
        return this.image;
    }
}
