package Formations;


import Creatures.Creature;
import GUI.GUIWindow;
import Source.Global;
import javafx.scene.image.Image;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Map {

    //MARK:Properties;
    Position[][] positions;
    int rows = Global.rowCount;
    int cols = Global.colCount;
    private Lock[][] locks  = new Lock[cols][rows];

    //MARK:initialize
    public Map(){

        positions = new Position[cols][rows];
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                positions[i][j] = new Position(i,j);
                locks[i][j] = new ReentrantLock(true);
            }
        }

    }

    //MARK:function
    public boolean setPosition(int x, int y, Creature creature){
        int pos_x = creature.getPos_x();
        int pos_y = creature.getPos_y();
        if(positions[x][y].setCreature(creature)){
            positions[pos_x][pos_y].reSetCreature();
            return true;
        }
        return false;
    }

    public void clearMap(){
        for(int x = 0; x < cols; x++){
            for(int y = 0; y < rows; y++){
                positions[x][y].reSetCreature();
            }
        }
    }

    public boolean isEmpty(int x,int y){
        return positions[x][y].isEmpty();
    }

    public void clearCalabash(){
        for (int x = 0; x < cols/2; x++){
            for(int y = 0; y < rows; y++){
                positions[x][y].reSetCreature();
            }
        }
    }

    public void clearMonster(){
        for (int x = cols/2; x < cols; x++){
            for(int y = 0; y < rows; y++){
                positions[x][y].reSetCreature();
            }
        }
    }

    public Image getCreatureImage(int x, int y){
        if(positions[x][y].isEmpty())
            return null;
        return positions[x][y].getCreature().getImage();
    }

    public boolean moveCreature(int oldX, int oldY, int newX, int newY){
        if(oldX < 0 || oldX >= cols || oldY < 0 || oldY >= rows || newX < 0 || newX >= cols || newY < 0 || newY >= rows)
            return false;
        boolean flag = false;
        //尝试获取生物当前位置锁，并在移动过程中保证对该位置的锁定；
        if(locks[oldX][oldY].tryLock()){
            try{
                //尝试获取生物将要前往的位置的锁，并在移动过程中保证对该锁的锁定；
                if(locks[newX][newY].tryLock()){
                    try{
                        if (!positions[oldX][oldY].getCreature().isBlank()) {
                            Creature creature = positions[oldX][oldY].getCreature();
                            if(positions[newX][newY].isEmpty()) {
                                positions[oldX][oldY].reSetCreature();
                                positions[newX][newY].setCreature(creature);
                                System.out.println("move creature from"+oldX+","+oldY+"to"+newX+","+newY);
                                //GUIWindow.moveCreature(creature,oldX,oldY,newX,newY);
                                flag = true;
                            }else{
                                if(!positions[newX][newY].getCreature().isAlive()){
                                    positions[oldX][oldY].reSetCreature();
                                    positions[newX][newY].setCreature(creature);
                                    flag = true;
                                }
                                else if(positions[newX][newY].getCreatureCamp() != creature.isFriend()){
                                    positions[newX][newY].getCreature().setDead();
                                    //positions[oldX][oldY].reSetCreature();
                                    //positions[newX][newY].setCreature(creature);
                                    System.out.println("move creature from"+oldX+","+oldY+"to"+newX+","+newY);
                                    flag = false;
                                }
                                else {flag = false;}
                            }
                        }else{flag = false;}
                    }finally {
                        locks[newX][newY].unlock();
                    }
                }
            }finally {
                locks[oldX][oldY].unlock();
            }
        }
        return flag;
    }

}
