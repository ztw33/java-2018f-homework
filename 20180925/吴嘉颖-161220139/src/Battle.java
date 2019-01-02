public class Battle {
    private static final int N = 20;
    private static BattleField field;

    public static void main(String[] args) {
        field = new BattleField(N,N);
        CBQueue cbqueue = new CBQueue();
        VillainQueue vlQueue = new VillainQueue(20);
        Creature grandpa = new Creature("爷爷", Factions.JUSTICE, 'T');
        Creature snake = new Creature("蛇精", Factions.EVIL, 'S');

        Sorter sorter = new Sorter();
        System.out.println("CalabashBro queuing...");
        cbqueue.randomQueue();
        System.out.println("Before sorting by name:");
        cbqueue.countOffAcName();
        sorter.SortByName(cbqueue);
        System.out.println("After sorting by name:");
        cbqueue.countOffAcName();
        System.out.println();
        cbqueue.JumpOntoField(field, Formation.HYDRA);

        System.out.println("符号说明：");
        System.out.println("葫芦娃：1-7，爷爷：T（拐杖嘛）");
        System.out.println("小喽啰：v（一把钢叉），蝎子精：w（两把钢叉），蛇精：S（魔鬼身材）");
        System.out.println();

        vlQueue.JumpOntoField(field, Formation.HOOKEDSPEAR);
        grandpa.stepOn(field, 15, 4);
        snake.stepOn(field, 15, 16);
        System.out.println("长蛇阵 vs 偃月阵！ 激战！（最后一句好中二……");
        //field.ShowField();
        System.out.println(field);
        System.out.println();

        vlQueue.leaveField(field);
        vlQueue.JumpOntoField(field, Formation.ARROW);
        System.out.println("长蛇阵 vs 锋矢阵！ 激战！（最后一句真的中二……");
        //field.ShowField();
        System.out.println(field);
    }
}