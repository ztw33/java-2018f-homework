package JavaFx;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;

public class BattleFXield{
    private static Image imagecb1 = new Image("file:src/JavaFx/Pictures/cb1.jpg");
    private static Image imagecb2 = new Image("file:src/JavaFx/Pictures/cb2.jpg");
    private static Image imagecb3 = new Image("file:src/JavaFx/Pictures/cb3.jpg");
    private static Image imagecb4 = new Image("file:src/JavaFx/Pictures/cb4.jpg");
    private static Image imagecb5 = new Image("file:src/JavaFx/Pictures/cb5.jpg");
    private static Image imagecb6 = new Image("file:src/JavaFx/Pictures/cb6.jpg");
    private static Image imagecb7 = new Image("file:src/JavaFx/Pictures/cb7.jpg");
    private static Image imagescorpion = new Image("file:src/JavaFx/Pictures/scorpion.jpg");
    private static Image imagesnake = new Image("file:src/JavaFx/Pictures/snake.jpg");
    private static Image imagepapa = new Image("file:src/JavaFx/Pictures/papa.jpg");
    private static Image imagegoblin = new Image("file:src/JavaFx/Pictures/goblin.png");

    ImageView[][] ImagesOnBattleField = new ImageView[20][20];

    BattleFXield(){
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                ImagesOnBattleField[i][j] = new ImageView();
                ImagesOnBattleField[i][j].setFitWidth(30);
                ImagesOnBattleField[i][j].setFitHeight(30);
                GridPane.setRowIndex(ImagesOnBattleField[i][j], i);
                GridPane.setColumnIndex(ImagesOnBattleField[i][j], j);
            }
        }
    }

    static void switchIdentifierToImage(ImageView iv, char identifier){
        switch (identifier){
            case '1': iv.setImage(imagecb1); break;
            case '2': iv.setImage(imagecb2); break;
            case '3': iv.setImage(imagecb3); break;
            case '4': iv.setImage(imagecb4); break;
            case '5': iv.setImage(imagecb5); break;
            case '6': iv.setImage(imagecb6); break;
            case '7': iv.setImage(imagecb7); break;
            case '#': iv.setImage(imagepapa); break;
            case '+': iv.setImage(imagegoblin); break;
            case '^': iv.setImage(imagescorpion); break;
            case '~': iv.setImage(imagesnake); break;
        }
    }

}
