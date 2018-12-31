package map;

import creature.Creature;

public class Map {
    //固定的地图大小（20*10）
    private static int rows,cols;
    static{
        rows = 10;  cols = 20;
    }
    private Creature[][] creatures;

    public Map(){
        creatures = new Creature[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                creatures[i][j] = new Creature();
            }
        }
    }

    //初始化葫芦娃阵营一侧的地图；
    public void initHuluwa(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < 10; j++){
                creatures[i][j] = new Creature();
            }
        }
    }

    //初始化妖怪阵营一侧的地图
    public void initMonster(){
        for(int i = 0; i < rows; i++){
            for(int j = 10; j < cols; j++){
                creatures[i][j] = new Creature();
            }
        }
    }

    public boolean isStand(int x, int y){
        return !creatures[x][y].getName().equals("NULL");
    }

    public void setCreatures(Creature creature, int x, int y){
        if((x>=0 && x < rows) &&(y >=0 && y < cols))
            creatures[x][y] = creature;
    }
    /*
    public void deleCreatures(int x, int y){
        if((x>=0 && x < rows) &&(y >=0 && y < cols))
            creatures[x][y] = new Creature();
    }
    */

    //打印地图；
    public void printMap(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < 10; j++){
                if(this.isStand(i,j)){
                    System.out.print(creatures[i][j].getName()+"\t");
                }
                else {
                    System.out.print("* *\t");
                }
            }
            System.out.print("| |\t");
            for(int j = 10; j < cols; j++){
                if(this.isStand(i,j)){
                    System.out.print(creatures[i][j].getName()+"\t");
                }
                else {
                    System.out.print("* *\t");
                }
            }
            System.out.println();
        }
        for(int i = 0; i <= cols; i++){
            System.out.print("- -\t");
        }
        System.out.println();
    }

}
