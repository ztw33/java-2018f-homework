package renyi2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Field f = new Field();
        //System.out.println("是否需要助阵Y/N");
        System.out.println("请选择喽啰阵型：\n"
                + "1鹤翼\n"
                + "2雁行\n"
                + "3衝軛\n"
                + "4长蛇\n"
                + "5鱼鳞\n"
                + "6方円\n"
                + "7偃月\n"
                + "8锋矢");
        Scanner in = new Scanner(System.in);
        Battlearray a;
        switch (in.nextInt()) {
            case 1:
                a = new FirstBattlearray();
                a.createbattlearray(f, false);
                break;
            case 2:
                a=new SecondBattlearray();
                a.createbattlearray(f,false);
                break;
            case 3:
                a=new ThirdBattlearray();
                a.createbattlearray(f,false);
                break;
            case 4:
                a=new ForthBattlearray();
                a.createbattlearray(f,false);
                break;
            case 5:
                a=new FifthBattlearray();
                a.createbattlearray(f,false);
                break;
            case 6:
                a=new SixthBattlearray();
                a.createbattlearray(f,false);
                break;
            case 7:
                a=new SeventhBattlearray();
                a.createbattlearray(f,false);
                break;
            case 8:
                a=new eighthBattlearray();
                a.createbattlearray(f,true);
                break;
            default:
                return;
        }
        f.show();
    }
}
