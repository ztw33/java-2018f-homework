package world;

import creature.*;
import formation.*;
import javax.swing.*;


public class BattleField{
    /**
     * Tite[][] 二维数组
    /**
     * 初始化
     * @param boardSize
     */

    private int row;
    private int column;
    private BattleField battleField;
    private Creature creature;
    private Location location;
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

    public void addQueue(Creature[] creature, Location startLocation, FormationImp formation){
        formation.arrange(this.battleField,creature,startLocation);
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


    /**
     * 打印棋盘
     */
    public void print(){
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                System.out.print(this.arr[i][j].getLocation_creature().toString() + "    ");
            }
            System.out.println();
        }
        System.out.println();
    }


}