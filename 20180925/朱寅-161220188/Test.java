public class Test {
    public static void main(String[] args) {
        Battlefield battlefield = new Battlefield();

        Calabash[] calabashbrothers = {new Calabash(CalabashBrother.BLU), new Calabash(CalabashBrother.PPL), new Calabash(CalabashBrother.YLW),
                new Calabash(CalabashBrother.ORG), new Calabash(CalabashBrother.GRN), new Calabash(CalabashBrother.RED),
                new Calabash(CalabashBrother.CYN)};
        calabashbrothers = bubbleSort(calabashbrothers);
        Grandpa grandpa = new Grandpa();
        Goblin[] goblins = new Goblin[15];
        for(int i = 0; i < 15; i ++)
            goblins[i] = new Goblin();
        Scorpion scorpion = new Scorpion();
        Snake snake = new Snake();

        putCalabashOnBattle(calabashbrothers, battlefield);
        battlefield.addIndividual(grandpa, new Coordinate(0,0));
        battlefield.addIndividual(snake, new Coordinate(0,9));
        putMonsterOnBattle(goblins, scorpion, battlefield, Formation.Crescent);
        battlefield.outPutBattlefield();

        for(int change = 0; change < 5; change ++) {
            battlefield.clearBattlefield();
            putCalabashOnBattle(calabashbrothers, battlefield);
            battlefield.addIndividual(grandpa, new Coordinate(0,0));
            battlefield.addIndividual(snake, new Coordinate(0,9));
            putMonsterOnBattle(goblins, scorpion, battlefield, Formation.values()[change+1]);
            battlefield.outPutBattlefield();
        }


    }

    public static void putCalabashOnBattle(Calabash[] calabashbrothers, Battlefield battlefield) {
        for(int i = 0; i < 7; i ++) {
            Coordinate pos = new  Coordinate(i + 3, 1);
            calabashbrothers[i].pos = pos;
            battlefield.addIndividual(calabashbrothers[i], pos);
        }
    }

    public static void putMonsterOnBattle(Goblin[] goblins, Scorpion scorpion, Battlefield battlefield, Formation formation) {
        switch (formation) {
            case Crane: {
                battlefield.addIndividual(scorpion, new Coordinate(8,7));
                battlefield.addIndividual(goblins[0], new Coordinate(7,6));
                battlefield.addIndividual(goblins[1], new Coordinate(6,5));
                battlefield.addIndividual(goblins[2], new Coordinate(7,8));
                battlefield.addIndividual(goblins[3], new Coordinate(6,9));
                break;
            }
            case Echelon: {
                battlefield.addIndividual(scorpion, new Coordinate(7,4));
                battlefield.addIndividual(goblins[0], new Coordinate(6,5));
                battlefield.addIndividual(goblins[1], new Coordinate(5,6));
                battlefield.addIndividual(goblins[2], new Coordinate(4,7));
                battlefield.addIndividual(goblins[3], new Coordinate(3,8));
                break;
            }
            case Yoke: {
                battlefield.addIndividual(scorpion, new Coordinate(3,9));
                battlefield.addIndividual(goblins[0], new Coordinate(4,10));
                battlefield.addIndividual(goblins[1], new Coordinate(5,9));
                battlefield.addIndividual(goblins[2], new Coordinate(6,10));
                battlefield.addIndividual(goblins[3], new Coordinate(7,9));
                battlefield.addIndividual(goblins[4], new Coordinate(8,10));
                break;
            }
            case Scale: {
                battlefield.addIndividual(scorpion, new Coordinate(7,6));
                battlefield.addIndividual(goblins[0], new Coordinate(7,7));
                battlefield.addIndividual(goblins[1], new Coordinate(7,8));
                battlefield.addIndividual(goblins[2], new Coordinate(7,9));
                battlefield.addIndividual(goblins[3], new Coordinate(8,7));
                battlefield.addIndividual(goblins[4], new Coordinate(6,7));
                battlefield.addIndividual(goblins[5], new Coordinate(6,8));
                battlefield.addIndividual(goblins[6], new Coordinate(5,7));
                break;
            }
            case Square: {
                battlefield.addIndividual(scorpion, new Coordinate(6,5));
                battlefield.addIndividual(goblins[0], new Coordinate(5,6));
                battlefield.addIndividual(goblins[1], new Coordinate(4,7));
                battlefield.addIndividual(goblins[2], new Coordinate(5,8));
                battlefield.addIndividual(goblins[3], new Coordinate(6,9));
                battlefield.addIndividual(goblins[4], new Coordinate(7,8));
                battlefield.addIndividual(goblins[5], new Coordinate(8,7));
                battlefield.addIndividual(goblins[6], new Coordinate(7,6));
                break;
            }
            case Crescent: {
                battlefield.addIndividual(scorpion, new Coordinate(5,5));
                battlefield.addIndividual(goblins[0], new Coordinate(6,5));
                battlefield.addIndividual(goblins[1], new Coordinate(4,6));
                battlefield.addIndividual(goblins[2], new Coordinate(5,6));
                battlefield.addIndividual(goblins[3], new Coordinate(6,6));
                battlefield.addIndividual(goblins[4], new Coordinate(7,6));
                battlefield.addIndividual(goblins[5], new Coordinate(4,7));
                battlefield.addIndividual(goblins[6], new Coordinate(5,7));
                battlefield.addIndividual(goblins[7], new Coordinate(6,7));
                battlefield.addIndividual(goblins[8], new Coordinate(7,7));
                battlefield.addIndividual(goblins[9], new Coordinate(3,8));
                battlefield.addIndividual(goblins[10], new Coordinate(8,8));
                break;
            }
            case Spearhead: {
                battlefield.addIndividual(scorpion, new Coordinate(5,4));
                battlefield.addIndividual(goblins[0], new Coordinate(4,5));
                battlefield.addIndividual(goblins[1], new Coordinate(5,5));
                battlefield.addIndividual(goblins[2], new Coordinate(6,5));
                battlefield.addIndividual(goblins[3], new Coordinate(3,6));
                battlefield.addIndividual(goblins[4], new Coordinate(5,6));
                battlefield.addIndividual(goblins[5], new Coordinate(7,6));
                battlefield.addIndividual(goblins[6], new Coordinate(5,7));
                battlefield.addIndividual(goblins[7], new Coordinate(5,8));
                battlefield.addIndividual(goblins[8], new Coordinate(5,9));
                break;
            }

        }
    }

    public enum Formation {
        LongSnake, Crane, Echelon, Yoke, Scale, Square, Crescent, Spearhead
    }

    public static Calabash[] bubbleSort(Calabash[] calabashBrothers) {
        for(int round = 0; round < 7; round ++) {
                for(int bubble = 6; bubble > round; bubble --) {
                if(calabashBrothers[bubble].calabashCategory.brotherRank < calabashBrothers[bubble - 1].calabashCategory.brotherRank) {
                    Calabash temp = calabashBrothers[bubble];
                    calabashBrothers[bubble] = calabashBrothers[bubble - 1];
                    calabashBrothers[bubble - 1] = temp;
                }

            }
        }
        return calabashBrothers;
    }
}



