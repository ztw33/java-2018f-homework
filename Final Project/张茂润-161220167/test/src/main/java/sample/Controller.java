package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.util.ResourceBundle;
import java.io.*;

public class Controller implements Initializable {
    @FXML
    private Button myButtonStart;
    @FXML
    private Button myButtonStop;
    @FXML
    private Button myButtonDisplay;
    @FXML
    private TextArea myTextArea;
    @FXML
    private GridPane myGridPane;
    @FXML
    private MenuItem menuItem1;
    @FXML
    private MenuItem menuItem2;
    @FXML
    private MenuItem menuItem3;
    @FXML
    private MenuItem menuItem4;
    @FXML
    private MenuItem menuItem5;
    @FXML
    private MenuItem menuItem6;
    @FXML
    private MenuItem menuItem7;
    @FXML
    private MenuItem menuItem8;
    @FXML
    private MenuButton myMenuButton;

    private ImageView imageViewHL1;
    private ImageView imageViewHL2;
    private ImageView imageViewHL3;
    private ImageView imageViewHL4;
    private ImageView imageViewHL5;
    private ImageView imageViewHL6;
    private ImageView imageViewHL7;
    private ImageView imageViewGp;
    private ImageView imageViewSn;
    private ImageView imageViewSc;
    private ImageView imageViewLo[];
    private ImageView imageViewGrave;
    private Field field;
    private Image imageHL1;
    private Image imageHL2;
    private Image imageHL3;
    private Image imageHL4;
    private Image imageHL5;
    private Image imageHL6;
    private Image imageHL7;
    private Image imageGp;
    private Image imageSn;
    private Image imageSc;
    private Image imageLo;
    private Image imageGrave;

    File file;
    FileOutputStream output ;
    private KeyEvent event;

    public Controller(){
        //Image image = new Image("file:C:/user/50437/IdeaProjects/test1/resource/test.png") ;
        //ImageView imageView = new ImageView();
        //imageView.setImage(image);
       // myPane.setCenter(imageView);
    }

    //@Override
    public void initialize(URL location, ResourceBundle resuorce){
        //URL url = Controller.class.getClassLoader().getResource("");
        //System.out.print(url.toString());
        Image imageBgd = new Image("/background2.jpg");
        field = new Field(1, this, file, output);
        //System.out.println(image.getHeight() + " " + image.getWidth());
        imageViewHL1 = new ImageView();
        imageViewHL2 = new ImageView();
        imageViewHL3 = new ImageView();
        imageViewHL4 = new ImageView();
        imageViewHL5 = new ImageView();
        imageViewHL6 = new ImageView();
        imageViewHL7 = new ImageView();
        imageViewGp = new ImageView();
        imageViewSn = new ImageView();
        imageViewSc = new ImageView();
        imageViewLo = new ImageView[field.numLoLo];
        imageViewGrave = new ImageView();

        imageHL1 = new Image("/Hulu1s.jpg");
        imageHL2 = new Image("/Hulu2s.jpg");
        imageHL3 = new Image("/Hulu3s.jpg");
        imageHL4 = new Image("/Hulu4s.jpg");
        imageHL5 = new Image("/Hulu5s.jpg");
        imageHL6 = new Image("/Hulu6s.jpg");
        imageHL7 = new Image("/Hulu7s.jpg");
        imageGp = new Image("/Grandpa.jpg");
        imageSn = new Image("/Snake.jpg");
        imageSc = new Image("/Scropion.jpg");
        imageLo = new Image("/LoLo.jpg");
        imageGrave = new Image("/grave.jpg");

        imageViewHL1.setImage(imageHL1);
        imageViewHL2.setImage(imageHL2);
        imageViewHL3.setImage(imageHL3);
        imageViewHL4.setImage(imageHL4);
        imageViewHL5.setImage(imageHL5);
        imageViewHL6.setImage(imageHL6);
        imageViewHL7.setImage(imageHL7);
        imageViewGp.setImage(imageGp);
        imageViewSn.setImage(imageSn);
        imageViewSc.setImage(imageSc);
        for(int i = 0; i < field.numLoLo; i++) {
            ImageView tmp = new ImageView();
            tmp.setImage(imageLo);
            imageViewLo[i] = tmp;
            //imageViewLo.setImage(imageLo);
        }
        imageViewGrave.setImage(imageGrave);

        BackgroundImage myBI =  new BackgroundImage(imageBgd,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        myGridPane.setBackground(new Background(myBI));
        menuItem1 = new MenuItem("鹤翼");
        menuItem2 = new MenuItem("雁行");
        menuItem3 = new MenuItem("衡轭");
        menuItem4 = new MenuItem("长蛇");
        menuItem5 = new MenuItem("鱼鳞");
        menuItem6 = new MenuItem("方块");
        menuItem7 = new MenuItem("偃月");
        menuItem8 = new MenuItem("锋矢");

        menuItem1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                field.changeFormation(1);
                refresh();
            }
        });
        menuItem2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                field.changeFormation(2);
                refresh();
            }
        });
        menuItem3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                field.changeFormation(3);
                refresh();
            }
        });
        menuItem4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                field.changeFormation(4);
                refresh();
            }
        });
        menuItem5.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                field.changeFormation(5);
                refresh();
            }
        });
        menuItem6.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                field.changeFormation(6);
                refresh();
            }
        });
        menuItem7.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                field.changeFormation(7);
                refresh();
            }
        });
        menuItem8.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                field.changeFormation(8);
                refresh();
            }
        });
        //myMenuButton = new MenuButton("Formation", null, menuItem1);
        myMenuButton.getItems().add(menuItem1);
        myMenuButton.getItems().add(menuItem2);
        myMenuButton.getItems().add(menuItem3);
        myMenuButton.getItems().add(menuItem4);
        myMenuButton.getItems().add(menuItem5);
        myMenuButton.getItems().add(menuItem6);
        myMenuButton.getItems().add(menuItem7);
        myMenuButton.getItems().add(menuItem8);
        showField();

    }


    public void startNewGame(ActionEvent event) {
        printMessage("Game Starts!\r\n");
        for(int i = 0; i < 7; i++)
            field.brothers[i].start();
        field.grandpa.start();
        field.snake.start();
        field.scropion.start();
        for(int i = 0; i < field.numLoLo; i++)
            field.LoLo[i].start();
    }

    public void stopThisGame(ActionEvent event){
        System.out.println("StopAll");
        //assert (false);
        for(int i = 0; i < 7; i++)
            field.brothers[i].stop();
        field.grandpa.stop();
        field.snake.stop();
        field.scropion.stop();
        for(int i = 0; i < field.numLoLo; i++)
            field.LoLo[i].stop();
    }

    public void printMessage(String str){
        //myTextField.setText(str);
        //Platform.runLater( () -> myTextArea.appendText(str) );
        Platform.runLater(new Runnable() {
            public void run() {
                //field.controller.refresh();
                myTextArea.appendText(str);
            }
        });
        //myTextArea.appendText(str);
    }

    public void showField(){
        myGridPane.add(imageViewHL1, field.brothers[0].cor_x, field.brothers[0].cor_y, 1, 1);
        myGridPane.add(imageViewHL2, field.brothers[1].cor_x, field.brothers[1].cor_y, 1, 1);
        myGridPane.add(imageViewHL3, field.brothers[2].cor_x, field.brothers[2].cor_y, 1, 1);
        myGridPane.add(imageViewHL4, field.brothers[3].cor_x, field.brothers[3].cor_y, 1, 1);
        myGridPane.add(imageViewHL5, field.brothers[4].cor_x, field.brothers[4].cor_y, 1, 1);
        myGridPane.add(imageViewHL6, field.brothers[5].cor_x, field.brothers[5].cor_y, 1, 1);
        myGridPane.add(imageViewHL7, field.brothers[6].cor_x, field.brothers[6].cor_y, 1, 1);
        myGridPane.add(imageViewGp, field.grandpa.cor_x, field.grandpa.cor_y, 1, 1);
        myGridPane.add(imageViewSn, field.snake.cor_x, field.snake.cor_y,1,1);
        myGridPane.add(imageViewSc, field.scropion.cor_x, field.scropion.cor_y, 1,1);
        for(int i = 0; i < field.numLoLo; i++)
            myGridPane.add(imageViewLo[i], field.LoLo[i].cor_x, field.LoLo[i].cor_y, 1,1);
    }

    public void clearAll(){
        myGridPane.getChildren().remove(imageViewHL1);
        myGridPane.getChildren().remove(imageViewHL2);
        myGridPane.getChildren().remove(imageViewHL3);
        myGridPane.getChildren().remove(imageViewHL4);
        myGridPane.getChildren().remove(imageViewHL5);
        myGridPane.getChildren().remove(imageViewHL6);
        myGridPane.getChildren().remove(imageViewHL7);
        myGridPane.getChildren().remove(imageViewGp);
        myGridPane.getChildren().remove(imageViewSn);
        myGridPane.getChildren().remove(imageViewSc);
        for(int i = 0; i < field.numLoLo; i++)
            myGridPane.getChildren().remove(imageViewLo[i]);
    }

    public void refresh(){
        changeIcon();
        clearAll();
        showField();
    }

    public void changeIcon(){
        if(!field.brothers[0].getAlive())
            imageViewHL1.setImage(imageGrave);
        if(!field.brothers[1].getAlive())
            imageViewHL2.setImage(imageGrave);
        if(!field.brothers[2].getAlive())
            imageViewHL3.setImage(imageGrave);
        if(!field.brothers[3].getAlive())
            imageViewHL4.setImage(imageGrave);
        if(!field.brothers[4].getAlive())
            imageViewHL5.setImage(imageGrave);
        if(!field.brothers[5].getAlive())
            imageViewHL6.setImage(imageGrave);
        if(!field.brothers[6].getAlive())
            imageViewHL7.setImage(imageGrave);
        if(!field.grandpa.getAlive())
            imageViewGp.setImage(imageGrave);
        if(!field.snake.getAlive())
            imageViewSn.setImage(imageGrave);
        if(!field.scropion.getAlive())
            imageViewSc.setImage(imageGrave);
        for(int i = 0; i < field.numLoLo; i++){
            if(!field.LoLo[i].getAlive())
                imageViewLo[i].setImage(imageGrave);
        }
    }

    public void displayRecord(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Record File");
        Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);
        //System.out.print(file.getPath());
        field.display(file);
    }
}
