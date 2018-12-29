package World;

import Creature.Creature;

public class Space {
    protected Contain[][] map=new Contain[9][];//一个50x50的地图，记录每一个位置所放置的内容
    public Space(){
        for(int i=0;i<9;i++)
            map[i]=new Contain[25];
        for(int i=0;i<9;i++)
            for(int j=0;j<25;j++)
                map[i][j]=new Contain();
    }
    public void setMap(Creature charaters[]) {
        for(int i=0;i<16;i++){
            Position p=new Position();
            p=charaters[i].getposition();//获得人物的位置 并放置在地图上
            this.map[p.x][p.y].character=charaters[i];
            this.map[p.x][p.y].exist=true;
        }
    }
    public void clearMap(){
        for(int i=0;i<9;i++)
            for(int j=0;j<25;j++)
                map[i][j].exist=false;
    }


    public Contain[][] getMap() {
        return map;
    }
    public  void printMap(){
        for(int i=0;i<9;i++){
            for(int j=0;j<25;j++){
                if(!map[i][j].exist){
                    System.out.print("   ");
                }
                else{
                    System.out.print(map[i][j].character.image);
                }
            }
            System.out.println();
        }
    }//打印地图
}
