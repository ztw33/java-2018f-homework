package World;

import Creature.*;
import Formation.Changshe;
import Formation.Heyi;
import Formation.Yanxing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class World {
    public static void bubbleSort(Huluwa BrothersArray[]){
        Huluwa temp=new Huluwa(8);
        for(int i=0;i<7;i++) {
            for(int j=i+1;j<7;j++) {
                if(BrothersArray[i].order>BrothersArray[j].order){
                    temp=BrothersArray[i];
                    BrothersArray[i]=BrothersArray[j];
                    BrothersArray[j]=temp;
                }
            }
        }
    }
    public static void main(String[] args){
        Huluwa[] HuluBrothers=new Huluwa[7];
        Lackeys[] LackeysCrowds=new Lackeys[7];//创建小喽啰群和葫芦娃群
        Creature[] characters=new Creature[16];
        Snake snake=new Snake();
        Grandfather grandfather=new Grandfather();//人物构建已完成
        grandfather.setImage("(G)");
        snake.setImage("(S)");
        List list=new ArrayList<Huluwa>();
        for(int i=0;i<7;i++){
            Huluwa hulu=new Huluwa(i+1);//产生老大-老7
            int help=i+1;
            hulu.setImage("("+help+")");
            HuluBrothers[i]=hulu;
            list.add(HuluBrothers[i]);
            Lackeys lackeys=new Lackeys();
            lackeys.setImage("(*)");
            LackeysCrowds[i]=lackeys;
        }
        Collections.shuffle(list);//利用java中的shuffle初始化乱序葫芦兄弟
        //第一次布阵
        list.toArray(HuluBrothers);
        Changshe changshe=new Changshe();
        Heyi heyi=new Heyi();
        Yanxing yanxing=new Yanxing();
        changshe.setChangshe(HuluBrothers);
      //  changshe.setChangshe(LackeysCrowds);//布阵
        //Round 1
        System.out.println("---------------------------Round 1-----------------------------");

        heyi.setHeyi(LackeysCrowds);
        int huluxpos=4;
        int huluypos=3;
        int lackeysxpos=1;//确定其放置的位置
        int lackeysypos=13;
        for(int i=0;i<7;i++){
            HuluBrothers[i].move(huluxpos,huluypos);
            LackeysCrowds[i].move(lackeysxpos,lackeysypos);
        }
        grandfather.moveto(huluxpos-1,huluypos);
        snake.moveto(lackeysxpos,lackeysypos);
        for(int i=0;i<7;i++){
            characters[i]=HuluBrothers[i];
        }
        for(int i=7;i<14;i++){
            characters[i]=LackeysCrowds[i-7];
        }
        characters[14]=grandfather;
        characters[15]=snake;
        Space space=new Space();
        space.setMap(characters);
        space.printMap();
        System.out.println("---------------------------Round 2-----------------------------");
        bubbleSort(HuluBrothers);
        changshe.setChangshe(HuluBrothers);
        yanxing.setYanxing(LackeysCrowds);
        huluxpos=4;
        huluypos=3;
        lackeysxpos=1;//确定其放置的位置
        lackeysypos=13;
        for(int i=0;i<7;i++){
            HuluBrothers[i].move(huluxpos,huluypos);
            LackeysCrowds[i].move(lackeysxpos,lackeysypos);
        }
        grandfather.moveto(huluxpos-1,huluypos);
        snake.moveto(lackeysxpos+4,lackeysypos+5);
        for(int i=0;i<7;i++){
            characters[i]=HuluBrothers[i];
        }
        for(int i=7;i<14;i++){
            characters[i]=LackeysCrowds[i-7];
        }
        characters[14]=grandfather;
        characters[15]=snake;
        space.clearMap();
        space.setMap(characters);
        space.printMap();
    }//世界的入口
}
