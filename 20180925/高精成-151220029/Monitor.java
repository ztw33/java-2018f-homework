public class Monitor {//监视器，类似于上帝的角色，控制整个战场
    //实例化各种对象
    BattleField battle;
    Formation formation;
    GrandfatherOfCalabash grandpa;
    Snake snake;
    Scorpion scorpion;
    Underling underling;
    CalabashBrothers calabashBrothers;

    Monitor () {

        battle = new BattleField();
        grandpa = new GrandfatherOfCalabash();
        snake = new Snake();
        scorpion = new Scorpion();
        underling = new Underling();
        calabashBrothers = new CalabashBrothers();
        formation = new Formation();

    }

    void set () {//清扫战场并安排老爷爷、蛇精和蝎子精进入战场
        battle.cleanUpTheBattleFiled();
        formation.setBooster(snake,battle);
        formation.setBooster(grandpa,battle);
        formation.setScorpion(scorpion,battle);
    }

    void start () {
        System.out.println("注:葫芦娃(1-7) 爷爷(@) 蝎子精(%) 喽啰(<) 蛇精($)\n");
        this.set();
        Sort sort = new Sort();
        System.out.println("葫芦娃随机站队结果：");
        calabashBrothers.reportTheSortOfCalabashBrothers();
        System.out.println("\n葫芦娃有序站队后的结果：");
        sort.BubbleSort(calabashBrothers.getCalabashes());
        calabashBrothers.reportTheSortOfCalabashBrothers();

        formation.setSingleLineBattleArray(calabashBrothers.getCalabashes(),battle);
        formation.setFrontalSagittalBattleArray(underling,battle);
        System.out.println("\n------锋矢阵------");
        battle.printTheBattle();

        this.set();

        formation.setSingleLineBattleArray(calabashBrothers.getCalabashes(),battle);
        formation.setCraneShapeBattleArray(underling,battle);
        System.out.println("\n------鹤翼阵------");
        battle.printTheBattle();

        this.set();

        formation.setSingleLineBattleArray(calabashBrothers.getCalabashes(),battle);
        formation.setGooseShapeBattleArray(underling,battle);
        System.out.println("\n------雁行阵------");
        battle.printTheBattle();

        this.set();

        formation.setSingleLineBattleArray(calabashBrothers.getCalabashes(),battle);
        formation.setCrescentMoonShapeBattleArray(underling,battle);
        System.out.println("\n------偃月阵------");
        battle.printTheBattle();
    }

}
