package main;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.io.IOException;

import game.*;

/**
 * @author 单明慧
 * @version 1.0
 */

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    int formation = 0;
    boolean isStart = false;
    boolean isReplay = false;
    Game newGame;
    File file;
    Stage tmpStage;
    public void formationAdd() {
        formation++;
    }
    public void createGame() {
        newGame = new Game(formation);
    }
    public void threadStart() {
        isStart = true;
        isReplay = false;
        for(Thread t : newGame.allthreads) {
            t.start();
        }
    }
    public void loadFile() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("huluwa files (*.huluwa)","*.huluwa");
        fileChooser.getExtensionFilters().add(extFilter);
        file = fileChooser.showOpenDialog(tmpStage);
        if(file != null) {
            isReplay = true;
            isStart = false;
            newGame = new Game(file);
            newGame.tl.start();
        }
    }
    @SuppressWarnings("deprecation")
    public void restart() {
        for(Thread t: newGame.allthreads)
            t.stop();
        isStart = false;
        isReplay = false;
        formation = 0;
        newGame = new Game(formation);
    }
    @Override
    public void start(Stage theStage) {
        tmpStage = theStage;
        theStage.setTitle("葫芦娃vs妖怪：正义之战:SPACE开始，L加载，A切换妖怪阵型, R重新开始");
        theStage.setResizable(false);
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(1309,850);
        root.getChildren().add(canvas);

        newGame = new Game(formation);

        final GraphicsContext gc = canvas.getGraphicsContext2D();
        final Pane p = new Pane();//用来控制Creature
        root.getChildren().add(p);

        newGame.show(gc, p);

        final long startNanoTime = System.nanoTime();
        new AnimationTimer()
        {
            long lastTime = startNanoTime;
            public void handle(long currentNanoTime)
            {
                if(currentNanoTime - lastTime >= 100000000 &&!isReplay) {//10帧
                    p.getChildren().clear();
                    newGame.show(gc, p);
                    if(isStart) {
                        try {
                            newGame.saveNow();
                        }catch(IOException e) {
                            e.printStackTrace();
                        }
                    }
                    lastTime = currentNanoTime;
                }
                if(isReplay) {
                    p.getChildren().clear();
                    newGame.showReload(gc, p);
                }
            }
        }.start();
        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        if (e.getCode() == KeyCode.SPACE) {
                            System.out.println("SPACE PRESSED.");
                        }
                        if (e.getCode() == KeyCode.A) {
                            System.out.println("A PRESSED.");
                        }
                        if (e.getCode() == KeyCode.R) {
                            System.out.println("A PRESSED.");
                        }
                        if (e.getCode() == KeyCode.L) {
                            System.out.println("L PRESSED.");
                        }
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        if (e.getCode() == KeyCode.SPACE && !isStart) {
                            threadStart();
                        }
                        if (e.getCode() == KeyCode.A && !isStart) {
                            formationAdd();
                            createGame();
                        }
                        if (e.getCode() == KeyCode.R) {
                            restart();
                        }
                        if (e.getCode() == KeyCode.L && !isStart) {
                            loadFile();
                        }
                    }
                });

        theStage.show();
    }
}
