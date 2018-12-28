package backstage.creature;

import annotation.AuthorAnno;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@AuthorAnno(time = "2018.12.20",version = "2.0")
public abstract class Creature{
    protected ImageView imageView;
    protected String name;
    protected String imageUrl;
    protected int locationX;
    protected int locationY;

    public void setImageViewLocation(){
        imageView.setLayoutX(locationY*30);
        imageView.setLayoutY(locationX*30);
    }
    public void setImageView() {
        imageView = new ImageView(new Image(imageUrl));
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
    }

    public String getImageUrl(){
        return imageUrl;
    }
    public int getLocationX() {
        return locationX;
    }
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }
    public int getLocationY() {
        return locationY;
    }
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
    public ImageView getImageView() {
        return imageView;
    }
    public String getName() {
        return name;
    }
}
