package qx3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入战场的大小N（N>10）:");
        int N=sc.nextInt();
        while(N<=10)
        {
            System.out.print("战场太小了，请重新输入：");
            N=sc.nextInt();
        }
        System.out.print("请选择怪物方的阵型（输入阵型的编号）：\n");
        System.out.print("1、鹤翼\n");
        System.out.print("2、雁行\n");
        System.out.print("3、衡轨\n");
        System.out.print("4、长蛇\n");
        System.out.print("5、鱼鳞\n");
        System.out.print("6、方円\n");
        System.out.print("7、偃月\n");
        System.out.print("8、锋矢\n");
        int no=sc.nextInt();
        while(no>=1&&no<=8)
        {
            Battlefield battlefield=new Battlefield(N);
            Warrior warrior=new Warrior();
            WarriorFormation warriorFormation=new WarriorFormation();
            warriorFormation.formation(warrior,battlefield);
            Monster monster=new Monster();
            MonsterFormation formation=new HYFormation();
            switch (no)
            {
                case 1:formation=new HYFormation();break;
                case 2:formation=new YXFormation();break;
                case 3:formation=new HGFormation();break;
                case 4:formation=new CSFormation();break;
                case 5:formation=new YLFormation();break;
                case 6:formation=new FYFormation();break;
                case 7:formation=new YYFormation();break;
                case 8:formation=new FSFormation();break;
            }
            formation.formation(monster,battlefield);
            battlefield.printBattlefield();
            System.out.print("可以变换阵型，请选择编号（若输入编号不在1到8之间，则退出）：");
            no=sc.nextInt();
        }
    }
}
