package Character;

import Frame.GameApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main extends GameApplication {

    private static final String wd = System.getProperty("user.dir");
    private static Image bkp = null;
    //创建Layout和Scene之前的准备工作
    @Override
    protected void loadBefore() {
        try {
            bkp = new Image(new FileInputStream(wd + "\\resources\\background1.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //创建Layout和Scene之后、显示屏幕之前的工作
    @Override
    protected void loadAfter() {
        //创建屏幕, 并设置位置、长和宽
        GameAdmin screen = new GameAdmin(50,50,1200,600);
        ImageView iv = new ImageView(bkp);
        getRoot().getChildren().addAll(iv,screen);

        //启动屏幕重画timeline
        screen.start();
        //设置屏幕时间监听
        screen.initEvents();

    }
    @Override
    protected void showStage(Stage stage){
        super.showStage(stage);                 //显示主界面
        stage.setTitle("Java Final Project");   //设置标题
    }

    public static void main(String[] args){
        launch();
    }


}
