import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public enum CreaturePictures {
    Calabash1("file:///../src/pictures/red.jpg"),
    Calabash2("file:///../src/pictures/orange.jpg"),
    Calabash3("file:///../src/pictures/yellow.jpg"),
    Calabash4("file:///../src/pictures/green.jpg"),
    Calabash5("file:///../src/pictures/cyan.jpg"),
    Calabash6("file:///../src/pictures/blue.jpg"),
    Calabash7("file:///../src/pictures/purple.jpg"),
    GrandFather("file:///../src/pictures/grandfather.jpg"),
    Scorpion("file:///../src/pictures/scorpion.jpg"),
    Snake("file:///../src/pictures/snake.jpg"),
    Underling1("file:///../src/pictures/underling.jpg"),
    Underling2("file:///../src/pictures/underling.jpg"),
    Underling3("file:///../src/pictures/underling.jpg"),
    Underling4("file:///../src/pictures/underling.jpg"),
    Underling5("file:///../src/pictures/underling.jpg"),
    Underling6("file:///../src/pictures/underling.jpg"),
    Underling7("file:///../src/pictures/underling.jpg"),
    Underling8("file:///../src/pictures/underling.jpg"),
    Undefined("file:///./");
    CreaturePictures(String filePath){
        Image image = new Image(filePath);
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(40);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
    }
    public ImageView imageView;
}
