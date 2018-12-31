package calabashBrothers;

import calabashBrothers.beings.Creature;

import javax.swing.*;

/**
 * @ Author     ：Young
 * @ Description：战场的地图，二维平面，每个点是一个Unit
 */
public class Maps {
    private int rows;
    private int cols;
    private unit[][] maps;

    public Maps(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        maps = new unit[rows][cols];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                maps[i][j]=new unit(i,j);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

        public unit[][] getMaps() {
        return maps;
    }

    public void showMaps(){
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(maps[i][j].getCreature()!=null){
                    Creature tmp = maps[i][j].getCreature();
                    switch (tmp.getType()){
                        case CALABASH_BOY:{
                            System.out.print("C");
                        }break;

                        case HUMAN_BEING:{
                            System.out.print("G");
                        }break;

                        case MONSTER:{
                            System.out.print("M");
                        }break;

                        case MONSTER_LEADER:{
                            if(tmp.getName().equals("蛇精")){
                                System.out.print("S");
                            }else{
                                System.out.print("L");
                            }
                        }break;
                        default:{
                            System.out.println("类型出错");
                        }

                    }
                }else{
                    System.out.print("-");
                }
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public void removeMaps(){
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                maps[i][j].removeCreature();
            }
        }
    }
}
