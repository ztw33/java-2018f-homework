package formations;

import beings.Being;
import beings.Creature;
import gui.OutputAdapter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Battlefield {
    public Battlefield(OutputAdapter adapter) {
        this.adapter = adapter;
        field = new Being[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                field[i][j] = null;
            }
        }
        for(int i = 0; i < WIDTH; i++){
            for(int j = 0; j < HEIGHT; j++){
                lockList[i][j] = new ReentrantLock(true);
            }
        }
    }
    public void printFieldText(){
        for (int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                if(field[i][j] != null)
                    field[i][j].toldname();
                else{
                    System.out.print("|      ");
                }
            }
            System.out.print("|\n");
        }
        System.out.print('\n');
    }
    public void printField(){
        for (int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                if(field[i][j] != null)
                    field[i][j].toldname();
                else{
                    System.out.print("|      ");
                }
            }
            System.out.print("|\n");
        }
        System.out.print('\n');
        for(int i = 0; i < HEIGHT; i++) {
            for(int j = 0; j <WIDTH; j++){
                if(field[i][j] != null)
                    adapter.output(field[i][j]);
                else{
                    //adapter.output(field[i][j]);
                }
            }
        }
    }

    public boolean setCreature(int x, int y, Creature creature){
        if(y >= HEIGHT || x >= WIDTH || x < 0 || y < 0)
            return false;
        synchronized (this){
            int oldPositionx = creature.getPositionx();
            int oldPositiony = creature.getPositiony();
            if (field[oldPositiony][oldPositionx] == creature) {
                field[oldPositiony][oldPositionx] = null;
            }
            field[y][x] = creature;
            creature.setPosition(x, y);
            return true;
        }
        //adapter.move(creature, x, y);
    }
    public boolean moveCreature(int x, int y, Creature creature){
        if(y >= HEIGHT || x >= WIDTH || x < 0 || y < 0)
            return false;
        int oldPositionx = creature.getPositionx();
        int oldPositiony = creature.getPositiony();
        boolean flag = false;
        if(lockList[oldPositionx][oldPositiony].tryLock()){
            try{
                if(lockList[x][y].tryLock()) {
                    try {
                        if (field[y][x] == null) {
                            if (field[oldPositiony][oldPositionx] == creature) {
                                field[oldPositiony][oldPositionx] = null;
                            }
                            field[y][x] = creature;
                            creature.setPosition(x, y);
                            flag = true;
                        } else {
                            flag = false;
                        }
                        if (flag) {
                            adapter.move(creature, x, y, oldPositionx, oldPositiony);
                            //System.out.println("move from"+oldPositionx+","+oldPositiony+"to"+x+","+y);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lockList[x][y].unlock();
                        return flag;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                lockList[oldPositionx][oldPositiony].unlock();
            }
        }
        return flag;
    }
    private static final int WIDTH = 16;
    private static final int HEIGHT = 8;
    private Being[][] field;
    private Lock[][] lockList = new Lock[WIDTH][HEIGHT];
    private OutputAdapter adapter;
    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }
}

