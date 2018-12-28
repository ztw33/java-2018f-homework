enum LeftRightEnum{ LEFT, RIGHT };

public class BattleBlock {
    private String[][] battleBlock;

    public BattleBlock(){
        battleBlock = new String[10][21];
        for(int i = 0; i < 10; ++i)
            for(int j = 0; j < 21; ++j)
                if(j == 10)
                    battleBlock[i][j] = "| ";
                else
                    battleBlock[i][j] = "。。 ";
    }

    public void printBattleBlock(){
        System.out.println("对峙局面如下：");
        for(int i = 0; i < 10; ++i) {
            for (int j = 0; j < 21; ++j)
                System.out.print(battleBlock[i][j]);
            System.out.println();
        }
    }

    public void creatureStand(Creature[] creatures, LeftRightEnum LR){
        if(LR == LeftRightEnum.LEFT){
            System.out.println("葫芦兄弟进入战场");
            Formation formation = new Formation();
            //formation1.printFormation(1);
            formation.setPosition(creatures, 0);
            for(Creature creature : creatures){
                battleBlock[creature.position.getY()][creature.position.getX()] = creature.getName() + " ";
            }
        }
        else{
            System.out.println("怪物们进入战场");
            Formation formation = new Formation();
            formation.setPosition(creatures, 1);
            for(Creature creature : creatures){
                battleBlock[creature.position.getY()][creature.position.getX()] = creature.getName() + " ";
            }
        }

        try{
            Thread.sleep(500);
        }catch(InterruptedException exception){
            System.out.println("InterruptedException");
        }
    }

    public void leaderStand(Creature creature, LeftRightEnum LR){
        if(LR == LeftRightEnum.LEFT){
            System.out.println(creature.getName() + "进入战场");
            creature.setPosition(new Tuple(0, 4));
            battleBlock[4][0] = creature.getName() + " ";
        } else{
            System.out.println(creature.getName() + "进入战场");
            creature.setPosition(new Tuple(20, 4));
            battleBlock[4][20] = creature.getName() + " ";
        }

        try{
            Thread.sleep(500);
        }catch(InterruptedException exception){
            System.out.println("InterruptedException");
        }
    }

    public void clearBattleBlock(LeftRightEnum LR){
        int x = 0, y = 0;
        if(LR == LeftRightEnum.RIGHT)   y = y + 11;
        for(int i = x; i < 10; ++i)
            for(int j = y; j - y < 10; ++j)
                battleBlock[i][j] = "。。 ";
    }

    public void change(Creature[] creatures, Creature leader, int i){
        clearBattleBlock(LeftRightEnum.RIGHT);
        System.out.println("怪物们切换阵型");
        leaderStand(leader, LeftRightEnum.RIGHT );
        Formation formation = new Formation();
        formation.setPosition(creatures, i);
        for(Creature creature : creatures){
            battleBlock[creature.position.getY()][creature.position.getX()] = creature.getName() + " ";
        }

        try{
            Thread.sleep(500);
        }catch(InterruptedException exception){
            System.out.println("InterruptedException");
        }
    }
}
