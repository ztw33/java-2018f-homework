package world;

import creature.*;
import formation.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sort.BubbleSort;
import sort.RandomSort;

import java.util.Scanner;


public class BattleField {


    private int row;
    private int column;
    private BattleField battleField;
    public Location[][] arr;


    public BattleField(int row, int column){
        arr = new Location[row][column];
        for(int i=0; i<row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = new Location(i,j);
                arr[i][j].setLocation_creature(new Space());
            }
        }
        this.row = row;
        this.column = column;
    }

    /**
     * 增加棋盘上的生物种类
     * 在开始游戏后用于添加生物
     * */

    public void addCreature(Creature creature, Location location){
        int x = location.getX();
        int y = location.getY();
        this.arr[x][y].setLocation_creature(creature);

    }

    /** 增加棋盘上的队伍 */
    public void addQueue(Queue queue, Location startLocation, FormationImp formation){
        formation.arrange(this.battleField, queue, startLocation);
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


    /*清除battlefield*/
    public void clear(){
        for(int i=0; i<row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = new Location(i,j);
                arr[i][j].setLocation_creature(new Space());
            }
        }
    }

    /* 打印棋盘*/
    public void print(){
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                System.out.print(this.arr[i][j].getLocation_creature().toString() + "      ");
            }
            System.out.println("\t");
        }
        System.out.println("\t");
    }


    public void loadImage(GraphicsContext graphicsContext) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!arr[i][j].getLocation_creature().getClass().equals(new Space().getClass())) { //不是空地
                    Image image = arr[i][j].getLocation_creature().getImage();
                    graphicsContext.drawImage(image,  j*70, i*52, 60, 60);
                }
            }
        }
    }
}