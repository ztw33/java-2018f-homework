import java.util.Random;
import java.util.Scanner;

public class Battle {
    public static void main(String[] args){
        BattleBlock oneBlock = new BattleBlock();
        //初始化葫芦兄弟列表
        GourdDollEnum[] gourdDollList = GourdDollEnum.values();
        GourdDoll[] gourdDolls = new GourdDoll[7];
        for(int i = 0; i < 7; ++i)
            gourdDolls[i] = new GourdDoll(gourdDollList[i]);
        GourdDolls temp = new GourdDolls();
        // 乱序排队
        temp.disorder(gourdDolls);
        //temp.printGourdDolls(gourdDolls);
        // 排好顺序
        temp.orderThem(gourdDolls);
        //temp.printGourdDolls(gourdDolls);
        //初始化爷爷
        Grandpa grandpa = new Grandpa();
        //爷爷进入战场
        oneBlock.leaderStand(grandpa, LeftRightEnum.LEFT);
        //初始化蛇精
        MonsterEnum[] monsterList = MonsterEnum.values();
        Monster snake = new Monster(monsterList[0]);
        //蛇精进入战场
        oneBlock.leaderStand(snake, LeftRightEnum.RIGHT);
        //初始化怪物列表
        Monster[] monsters = new Monster[9];
        monsters[0] = new Monster(monsterList[1]);
        for(int i = 1; i < monsters.length; ++i)
            monsters[i] = new Monster(monsterList[2]);
        // 进入战场
        oneBlock.creatureStand(gourdDolls, LeftRightEnum.LEFT);
        oneBlock.creatureStand(monsters, LeftRightEnum.RIGHT);
        oneBlock.printBattleBlock();

        while(true){
            System.out.print("如果想要更改蛇精阵营的阵型，请输入阵型名称前面的序号：1、蜂矢，2、雁行，3、横轭，4、鹤翼，5、偃月，6、退出并清理战场\n所以你的选择是：");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if(choice == 6) break;
            oneBlock.change(monsters, snake, choice);
            oneBlock.printBattleBlock();
        }

        oneBlock.clearBattleBlock(LeftRightEnum.LEFT);
        oneBlock.clearBattleBlock(LeftRightEnum.RIGHT);
        try{
            Thread.sleep(500);
        }catch(InterruptedException exception){
            System.out.println("InterruptedException");
        }
        System.out.println("战场打扫完毕");
        oneBlock.printBattleBlock();

    }
}
