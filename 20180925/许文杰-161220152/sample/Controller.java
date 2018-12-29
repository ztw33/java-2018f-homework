package sample;

import data.BattleField;
import data.Camp;
import data.Formation;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    public ImageView[][] imageViews = new ImageView[12][18];
    public HashMap<String, Image> images= new HashMap();

    @FXML
    private MenuItem MenuItemFormation1 = new MenuItem();
    @FXML
    private MenuItem MenuItemFormation2 = new MenuItem();
    @FXML
    private MenuItem file_open = new MenuItem();
    @FXML
    private GridPane gridPane = new GridPane();

    private Main mainapp = new Main();

    public void setMainapp(Main mainapp)
    {
        this.mainapp = mainapp;
    }
    @FXML
    public void initialize()
    {
        for(int i = 0;i < 12;i++)
            for(int j = 0;j < 18; j++) {
                ImageView temp = new ImageView();
                temp.setFitWidth(1024 / 18.0);
                temp.setFitHeight(743 / 12.0);
                temp.setPreserveRatio(false);
                imageViews[i][j] = temp;
                gridPane.add(temp, j, i);
            }
        images.put("爷爷", new Image("/sample/image/爷爷.png"));
        images.put("大娃", new Image("/sample/image/rwjs1_01_1.png"));
        images.put("二娃", new Image("/sample/image/rwjs2_01_1.png"));
        images.put("三娃", new Image("/sample/image/rwjs3_01_1.png"));
        images.put("四娃", new Image("/sample/image/rwjs4_01_1.png"));
        images.put("五娃", new Image("/sample/image/rwjs5_01_1.png"));
        images.put("六娃", new Image("/sample/image/rwjs6_01_1.png"));
        images.put("七娃", new Image("/sample/image/rwjs7_01_1.png"));
        images.put("蛇精", new Image("/sample/image/蛇精.png"));
        images.put("蝎子", new Image("/sample/image/蝎子精.png"));
        images.put("喽啰", new Image("/sample/image/小喽啰.png"));
    }

    @FXML
    public void open()
    {
        /*DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Open Resourse dir");
        File file = chooser.showDialog(null);*/
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("Will be completed in FinalProject!");
        alert.showAndWait();
    }

    @FXML
    public void FormationYanXing()
    {
        Formation.YanXing(mainapp.getField(), mainapp.getCamp2(),9,10);
        print();
    }

    @FXML
    public void FormationHengE()
    {
        Formation.HengE(mainapp.getField(), mainapp.getCamp2(),2,15);
        print();
    }
    @FXML

    public void print()
    {
        for(int i = 0;i < mainapp.getField().getRow();i++)
        {
            for(int j = 0;j < mainapp.getField().getCol();j++)
            {
                if(mainapp.getField().getCells()[i][j].isEmpty())
                {
                    System.out.print("____  ");
                    imageViews[i][j].setImage(null);
                }
                else
                {
                    System.out.print(mainapp.getField().getCells()[i][j].getUnit().getName()+"  ");
                    imageViews[i][j].setImage(images.get(mainapp.getField().getCells()[i][j].getUnit().getName()));
                }
            }
            System.out.println();
        }
    }
}
