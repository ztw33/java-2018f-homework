public class Battle {
    public static void main(String[] args){
        //Create all possible creatures
        Creature[] calabashbros={new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro(), new CalabashBro()};
        Creature[] calabashbrosexpred={calabashbros[1],calabashbros[2],calabashbros[3],calabashbros[4],calabashbros[5],calabashbros[6],};
        Creature oldpapa = new OldPapa();
        Creature snakeevil = new SnakeEvil();
        Creature scorpion = new ScorpionEvil();
        Creature[] goblins = new Goblin[20];
        for(int i=0;i<20;i++){
            goblins[i] = new Goblin();
        }
        BattleField bf = new BattleField();

        bf.deployHeYiZhen(snakeevil, goblins, true);
        bf.printBattleFieldStatus();

        bf.deployHeYiZhen(calabashbros[0], calabashbrosexpred, false);
        bf.printBattleFieldStatus();
        bf.removeCreaturesFromBattleField(goblins);
        bf.printBattleFieldStatus();
        bf.removeCreatureFromBattleField(snakeevil);
        bf.printBattleFieldStatus();
        bf.setCheeringCreatureLocation(oldpapa, false);
        bf.printBattleFieldStatus();
    }
}
