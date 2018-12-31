package Main;

import Frame.GameApplication;
import javafx.stage.Stage;


public class Main extends GameApplication {

    private static final int mainWindowWidth = 1100, mainWindowHeight = 600;

    @Override
    protected void loadBefore() {

    }

    @Override
    protected void loadAfter() {
        //创建屏幕, 并设置位置、长和宽
        GameAdmin screen = new GameAdmin(0,0,mainWindowWidth,mainWindowHeight);
        getRoot().getChildren().add(screen);

        screen.start();
        screen.initEvents();
    }
    @Override
    protected void showStage(Stage stage){
        super.showStage(stage);                 
        stage.setTitle("Java Final Project");   
    }

    public static void main(String[] args){
        launch();
    }


}
