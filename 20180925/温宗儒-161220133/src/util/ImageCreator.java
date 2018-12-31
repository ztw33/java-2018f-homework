package util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ImageCreator {
    public ImageView create(String url, int row, int col){
        Image image = new Image(url);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);

        imageView.setLayoutX((double)(col*30));
        imageView.setLayoutY((double)(row*30));
//        imageView.setLayoutX((double)(row*30));
//        imageView.setLayoutY((double)(col*30));

        return imageView;

    }
}
