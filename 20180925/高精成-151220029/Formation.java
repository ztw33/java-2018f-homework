public class Formation {//阵法类

    public void setSingleLineBattleArray (Creature []cre,BattleField battle) {
        int j = battle.getBattleField().length/4;
        for(int i=0;i<7;i++){
            battle.getBattleField()[i+j+1][j] =cre[i].getSymbol();
        }
    }
    public void setScorpion (Creature cre,BattleField battle) {
        battle.getBattleField()[2][11] = cre.getSymbol();
    }
    public void setBooster (Creature cre,BattleField battle) {
        if(cre.isGreatMan()) {
            battle.getBattleField()[battle.getBattleField().length-2][battle.getBattleField().length/4] = cre.getSymbol();
        } else {
            battle.getBattleField()[battle.getBattleField().length-2][battle.getBattleField().length-1-battle.getBattleField().length/4] = cre.getSymbol();
        }
    }

    public void setCraneShapeBattleArray (Creature cre,BattleField battle) {//鹤翼阵
        char sym = cre.getSymbol();
        battle.getBattleField()[7][8] = sym;
        battle.getBattleField()[6][9] = sym;
        battle.getBattleField()[5][10] = sym;
        battle.getBattleField()[4][11] = sym;
        battle.getBattleField()[8][9] = sym;
        battle.getBattleField()[9][10] = sym;
        battle.getBattleField()[10][11] = sym;

    }

    public void setGooseShapeBattleArray (Creature cre,BattleField battle) {//雁行阵
        char sym = cre.getSymbol();
        battle.getBattleField()[10][9] = sym;
        battle.getBattleField()[9][10] = sym;
        battle.getBattleField()[8][11] = sym;
        battle.getBattleField()[7][12] = sym;
        battle.getBattleField()[6][13] = sym;
        battle.getBattleField()[5][14] = sym;
    }

    public void setFrontalSagittalBattleArray (Creature cre,BattleField battle) {//锋矢阵
        char sym = cre.getSymbol();
        for(int i=8;i<15;i++)
            battle.getBattleField()[7][i] = sym;
        battle.getBattleField()[6][9] = sym;
        battle.getBattleField()[5][10] = sym;
        battle.getBattleField()[4][11] = sym;
        battle.getBattleField()[8][9] = sym;
        battle.getBattleField()[9][10] = sym;
        battle.getBattleField()[10][11] = sym;

    }

    public void setCrescentMoonShapeBattleArray (Creature cre,BattleField battle) {//偃月阵
        char sym = cre.getSymbol();
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                battle.getBattleField()[6 + i][8 + j] = sym;
            }
        }
        battle.getBattleField()[5][10] = sym;
        battle.getBattleField()[5][11] = sym;
        battle.getBattleField()[4][11] = sym;
        battle.getBattleField()[4][12] = sym;
        battle.getBattleField()[9][10] = sym;
        battle.getBattleField()[9][11] = sym;
        battle.getBattleField()[10][11] = sym;
        battle.getBattleField()[10][12] = sym;
    }


}
