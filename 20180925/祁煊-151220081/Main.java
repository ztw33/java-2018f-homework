public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        // 鹤翼
        System.out.println("\n----------鹤翼----------\n");
        battle.huluwaRandom();
        battle.heyi();
        battle.print();

        // 雁行
        System.out.println("\n----------雁行----------\n");
        battle.huluwaRandom();
        battle.yanxing();
        battle.print();

        // 衡轭
        System.out.println("\n----------衡轭----------\n");
        battle.huluwaRandom();
        battle.henge();
        battle.print();

        // 长蛇
        System.out.println("\n----------长蛇----------\n");
        battle.huluwaRandom();
        battle.changshe();
        battle.print();

        // 鱼鳞
        System.out.println("\n----------鱼鳞----------\n");
        battle.huluwaRandom();
        battle.yulin();
        battle.print();

        // 方円
        System.out.println("\n----------方円----------\n");
        battle.huluwaRandom();
        battle.fangyuan();
        battle.print();

        // 偃月
        System.out.println("\n----------偃月----------\n");
        battle.huluwaRandom();
        battle.yanyue();
        battle.print();

        // 锋矢
        System.out.println("\n----------锋矢----------\n");
        battle.huluwaRandom();
        battle.fengshi();
        battle.print();
    }
}
