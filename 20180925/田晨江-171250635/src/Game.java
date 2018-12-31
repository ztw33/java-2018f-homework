import world.BattleField;
import creature.CalabashBrothers;
import creature.*;
import creature.LittleGuys;
import creature.ScorpionEssence;
import world.*;
import formation.*;

import java.util.Scanner;

public class Game {


    public static void main(String[] args){

        //GeneralCoordinator coordinator = new GeneralCoordinator();
        BattleField battleField = new BattleField(15,15);

        /*打印初始阵型*/
        System.out.println("初始化");
        battleField.print();

        /*各生物初始化*/
        CalabashBrothers cbQueue = new CalabashBrothers();
        CalabashBrothers[] cb = cbQueue.createCalabashBrothers();

        /*老爷爷和蛇精初始化*/
        Grandpa grandpa = new Grandpa();
        SnakeSpirit snakeSpirit = new SnakeSpirit();

        /*葫芦娃乱序*/
        cbQueue.randomQueue();
        cbQueue.BubbleSort();
        cbQueue.setCb(cb);

        Scanner in = new Scanner(System.in);
        //System.out.println("请输入小喽啰的人数");
        //int num = in.nextInt();

        /*小喽啰初始化*/
        LittleGuys littleGuys = new LittleGuys();
        Creature[] lg = littleGuys.createLittleGuys(6);
        littleGuys.setLg(lg);


        /*各阵型初始化*/
        FormationImp changShe = new ChangShe();
        FormationImp fangYuan = new FangYuan();
        FormationImp heYi = new HeYi();
        FormationImp yanXing = new YanXing();
        FormationImp hengE = new HengE();


        /*放置葫芦娃*/
        changShe.arrange(battleField,cbQueue.getCb(),new Location(5,5));


        System.out.println("请输入小喽啰的阵型，例如hengE,heYi,yanXing");
        String formaiton = in.next();
        switch (formaiton){
            case "hengE":
                hengE.arrange(battleField,littleGuys.getLg(),new Location(5,8));
                break;
            case "heYi":
                heYi.arrange(battleField,littleGuys.getLg(),new Location(8,8));
                break;
            case "yanXing":
                yanXing.arrange(battleField,littleGuys.getLg(),new Location(8,8));
                break;
            default:
        }

        battleField.print();


        /*添加老爷爷和蛇精*/
        battleField.addCreature(grandpa,new Location(3,3));
        battleField.addCreature(snakeSpirit,new Location(2,10));
        battleField.print();

        battleField.clear();
        battleField.print();


        /*变换阵法输出*/
        System.out.println("变换阵法");

        /*放置葫芦娃*/
        changShe.arrange(battleField,cbQueue.getCb(),new Location(5,5));

        System.out.println("请输入小喽啰的阵型，例如hengE,heYi,yanXing");
        String formaiton2 = in.next();
        switch (formaiton2){
            case "hengE":
                hengE.arrange(battleField,littleGuys.getLg(),new Location(5,8));
                break;
            case "heYi":
                heYi.arrange(battleField,littleGuys.getLg(),new Location(7,7));
                break;
            case "yanXing":
                yanXing.arrange(battleField,littleGuys.getLg(),new Location(8,8));
                break;
            default:
        }

        battleField.print();


        /*添加老爷爷和蛇精*/
        battleField.addCreature(grandpa,new Location(3,3));
        battleField.addCreature(snakeSpirit,new Location(2,10));
        battleField.print();


    }


}