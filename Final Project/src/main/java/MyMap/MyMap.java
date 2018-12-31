package MyMap;

import Creature.Creature;
import Instructor.Global;

import java.util.ArrayList;

public class MyMap {

    public static Creature LandCreature[][] = new Creature[20][20];
    private static Creature EmptyCreature = new Creature("none", Global.EMPTY,0,"1.jpg",0,"1.jpg");
    /*TODO:添加地形：草地，石头等 terrian*/
    /*TODO:添加可能出现的异常处理*/
    MyMap(){}

    public static void initMap(){
        for(int i = 0; i < 20; i++)
            for(int j = 0; j < 20; j++){
                LandCreature[i][j] = EmptyCreature;
            }
    }

    public static void setSite(Creature anyone,int x, int y) {
        try {
            if (anyone.getSitey() != -1 || anyone.getSitex() != -1) {
                if (LandCreature[y][x].getName() == "none")
                    LandCreature[anyone.getSitey()][anyone.getSitex()] = EmptyCreature;
                else {
                    LandCreature[anyone.getSitey()][anyone.getSitex()] = LandCreature[y][x];
                    LandCreature[y][x].setSitex(anyone.getSitex());
                    LandCreature[y][x].setSitey(anyone.getSitey());
                }
                anyone.setSitey(y);
                anyone.setSitex(x);
                LandCreature[anyone.getSitey()][anyone.getSitex()] = anyone;
            } else {
                anyone.setSitey(y);
                anyone.setSitex(x);
                LandCreature[anyone.getSitey()][anyone.getSitex()] = anyone;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("out of line");
        }
    }

    public static void printMap(){
        for(int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(LandCreature[i][j].getForce());
            }
            System.out.println("");
        }
    }
    public Creature getSiteMes(int x, int y){
        return LandCreature[x][y];
    }

    public static MyPosition getNearestEnemy(Creature anyone,Creature[][]land){
        int orix = anyone.getSitex();
        int oriy = anyone.getSitey();
        int resx = 0,resy = 0;
        int length = 10000;
        for(Creature[]x:land)
            for(Creature y:x){
                if(y.getName()!="none"&&y.getCamp()!=anyone.getCamp()&&y.getHp()>0){
                    int templen = (orix-y.getSitex())*(orix-y.getSitex()) + (oriy-y.getSitey())*(oriy-y.getSitey());
                    if(templen < length){
                        length = templen;
                        resx = y.getSitex();
                        resy = y.getSitey();
                    }
                }
            }
        MyPosition res = new MyPosition(resx,resy);
        return res;
    }

    public static void moveTo(Creature x, MyPosition pos){
        if(pos.x < x.getSitex()
            && LandCreature[x.getSitey()][x.getSitex()-1].getCamp()!=x.getCamp()
            && ((Math.abs(x.getSitey()-pos.y) >= Math.abs(x.getSitex()-pos.x))||x.getSitex()==pos.x)) {
            if (LandCreature[x.getSitey()][x.getSitex() - 1].getName() == "none")
                MyMap.setSite(x, x.getSitex()-1, x.getSitey());
            else
                battle(x, LandCreature[x.getSitey()][x.getSitex() - 1]);
        }
        else if(pos.x > x.getSitex()
                && LandCreature[x.getSitey()][x.getSitex()+1].getCamp()!=x.getCamp()
                && ((Math.abs(x.getSitey()-pos.y) >= Math.abs(x.getSitex()-pos.x))||x.getSitex()==pos.x)) {
            if (LandCreature[x.getSitey()][x.getSitex() + 1].getName() == "none")
                MyMap.setSite(x, x.getSitex()+1, x.getSitey());
            else
                battle(x, LandCreature[x.getSitey()][x.getSitex() + 1]);
        }
        else if(pos.y > x.getSitey()
                && LandCreature[x.getSitey()+1][x.getSitex()].getCamp()!=x.getCamp()
                && ((Math.abs(x.getSitey()-pos.y) <= Math.abs(x.getSitex()-pos.x))||x.getSitey()==pos.y)) {
            if (LandCreature[x.getSitey() + 1][x.getSitex()].getName() == "none")
                MyMap.setSite(x, x.getSitex(), x.getSitey()+1);
            else
                battle(x, LandCreature[x.getSitey() + 1][x.getSitex()]);
        }
        else if(pos.y < x.getSitey()
                && LandCreature[x.getSitey()-1][x.getSitex()].getCamp()!=x.getCamp()
                && ((Math.abs(x.getSitey()-pos.y) <= Math.abs(x.getSitex()-pos.x))||x.getSitey()==pos.y)) {
            if (LandCreature[x.getSitey() - 1][x.getSitex()].getName() == "none")
                MyMap.setSite(x, x.getSitex(), x.getSitey()-1);
            else
                battle(x, LandCreature[x.getSitey() - 1][x.getSitex()]);
        }
        else
            ;
    }

    public static ArrayList<Creature> getNearCreatures(int x,int y){
        ArrayList<Creature> res = new ArrayList<Creature>();
        for(int i = -1;i <= 1; i++)
            for(int j = -1;j <= 1; j++)
                if(y+i>=0&&y+i<20&&x+j>=0&&x+j<20)
                 res.add(LandCreature[y+i][x+j]);
        return res;
    }

    public static void battle(Creature x,Creature y){
        System.out.println(x.getName()+" & "+y.getName());
    }
}
