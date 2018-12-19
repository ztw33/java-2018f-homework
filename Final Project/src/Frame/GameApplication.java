package Frame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

//应用程序启动类, 程序主类的父类
public abstract class GameApplication extends Application {
    private Group group;
    private Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        loadBefore();
        group = new Group();
        scene = new Scene(group);
        loadAfter();
        showStage(primaryStage);
    }

    //显示前和显示后
    protected abstract void loadBefore();
    protected abstract void loadAfter();

    protected void showStage(Stage stage){
        stage.setScene(scene);
        stage.show();
    }

    protected Scene getScene(){
        return scene;
    }

    protected Group getRoot(){
        return group;
    }


}
