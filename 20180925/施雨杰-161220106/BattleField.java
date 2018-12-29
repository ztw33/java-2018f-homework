public class BattleField {
    private static void showBattleField(Ground space) {
        int bound = space.showBound();
        for(int i = 0; i < bound; i++) {
            for(int j = 0; j < bound; j++) {
                if(space.isEmpty(i,j))
                    System.out.print("----");
                else
                    space.showCreature(i,j);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        Ground space = new Ground(12);
        Grandpa grandpa = new Grandpa();
        HuluWa[] brothers = new HuluWa[7];
        brothers[0] = new HuluWa(1);
        brothers[1] = new HuluWa(2);
        brothers[2] = new HuluWa(3);
        brothers[3] = new HuluWa(4);
        brothers[4] = new HuluWa(5);
        brothers[5] = new HuluWa(6);
        brothers[6] = new HuluWa(7);
        Snake snake = new Snake();
        Monster[] monsters = new Monster[20];
        monsters[0] = new Scorpio();
        for(int i = 1; i < 20; i++)
            monsters[i] = new LittleMonster();

        grandpa.initializeFormation(-1, space, brothers);
        snake.initializeFormation(1, space, monsters);
        grandpa.standInLine(brothers);
        grandpa.standByOrder(brothers);
        grandpa.setMidPoint(2,2);
        snake.setMidPoint(5,5);

        grandpa.commandHuluWa(FormationType.ChangShe);
        grandpa.chooseUnit(space);
        snake.commandMonsters(FormationType.HeYi);
        snake.chooseUnit(space);
        showBattleField(space);

        snake.waitNewLocation(monsters, space);
        snake.commandMonsters(FormationType.YanXing);
        snake.chooseUnit(space);
        showBattleField(space);

        snake.waitNewLocation(monsters, space);
        snake.commandMonsters(FormationType.HengE);
        snake.chooseUnit(space);
        showBattleField(space);

        snake.waitNewLocation(monsters, space);
        snake.commandMonsters(FormationType.YuLin);
        snake.chooseUnit(space);
        showBattleField(space);

        snake.waitNewLocation(monsters, space);
        snake.commandMonsters(FormationType.FangMen);
        snake.chooseUnit(space);
        showBattleField(space);

        snake.waitNewLocation(monsters, space);
        snake.commandMonsters(FormationType.YanYue);
        snake.chooseUnit(space);
        showBattleField(space);

        snake.waitNewLocation(monsters, space);
        snake.commandMonsters(FormationType.FengShi);
        snake.chooseUnit(space);
        showBattleField(space);
    }
}
