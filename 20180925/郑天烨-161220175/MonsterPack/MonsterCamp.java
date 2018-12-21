package MonsterPack;

import MotherEarthPack.Entity.Battlefield;
import MotherEarthPack.Scientific.*;

public class MonsterCamp implements Camp // 妖怪阵营
{
    private Serpent serpent;             // 蛇精
    private Scorpion scorpion;           // 蝎子精
    private Goblin[] goblins;            // 小喽啰
    private Formation monsterFormation;  // 妖怪们采取的阵型
    private Coordinate monsterCenter;    // 队伍的中心位置

    public MonsterCamp() {
        serpent = new Serpent();
        scorpion = new Scorpion();
        goblins = null;
        monsterFormation = null;
        monsterCenter = new Coordinate();
    }

    public void recruitGoblins(int goblinNum) {
        goblins = new Goblin[goblinNum];
        for (int i = 0; i < goblinNum; i++) {
            goblins[i] = new Goblin();
        }
    }

    @Override
    public void setFormation(Formation monsterFormation) {
        this.monsterFormation = monsterFormation;
    }

    @Override
    public Formation getFormation() {
        return monsterFormation;
    }

    @Override
    public void setCenter(Battlefield battlefield) {
        int fieldN = battlefield.getN();
        Coordinate haveEnemy = new Coordinate();
        outer:
        for (int i = 0; i < fieldN; i++) {
            for (int j = 0; j < fieldN; j++) {
                if(battlefield.haveCreature(new Coordinate(i,j))) {
                    haveEnemy = new Coordinate(i,j);
                    break outer;
                }
            }
        }
        if(!haveEnemy.haveSet())
        {
            monsterCenter.setR(fieldN/2);
            monsterCenter.setC(fieldN/4);
            return;
        }
        if(haveEnemy.getR() >= fieldN/2)
        {
            monsterCenter.setR(fieldN/4);
        }
        else
        {
            monsterCenter.setR(3*fieldN/4);
        }
        if(haveEnemy.getC() >= fieldN/2)
        {
            monsterCenter.setC(fieldN/4);
        }
        else
        {
            monsterCenter.setC(3*fieldN/4);
        }
    }

    @Override
    public void PlaceTheTroops(Battlefield battlefield) {
        Creature[] monsters = new Creature[1+goblins.length];
        monsters[0] = scorpion;
        int i = 1;
        for (int j = 0; j < goblins.length; j++) {
            monsters[i] = goblins[j];
            i++;
        }
        while(!FormationSettle.Settle(battlefield, battlefield.getN(), monsters,
               monsters.length, monsterCenter, monsterFormation))
        {
            setCenter(battlefield);
        }
    }

    @Override
    public void FriendlyForcesComeOn(Battlefield battlefield) {
        serpent.Locating(monsterCenter, battlefield);
    }

    @Override
    public void LoudlySupport() {
        serpent.LoudlySupport();
    }

}
