package controllers;/*
 * @author:Wu Gang
 * @create: 2018-11-21 20:05
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    private GameModel<Image> gameModel = new GameModel<>(Image.class);

    @FXML
    public AnchorPane myPane;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        gameModel.getJustSide().changeFormation("snake");
        gameModel.getEvilSide().changeFormation("flank");
        int size = 50;
        int jiange = 60;
        for(int i = 0;i < gameModel.getBoard().getSIZE();i++){
            for(int j = 0;j < gameModel.getBoard().getSIZE();j++){
                ImageView imageView = new ImageView();
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                imageView.setImage((Image) gameModel.getBoard().getImage(j, i));
                imageView.setLayoutX(i * jiange + (jiange - size) / 2);
                imageView.setLayoutY(j * jiange + (jiange - size) / 2);
                imageView.setScaleX(-1);
                myPane.getChildren().add(imageView);
            }
        }
    }
}
