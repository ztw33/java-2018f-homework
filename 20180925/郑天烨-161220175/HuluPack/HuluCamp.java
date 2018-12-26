package HuluPack;

import MotherEarthPack.Entity.Battlefield;
import MotherEarthPack.Scientific.*;


public class HuluCamp implements Camp   // 葫芦兄弟阵营
{
    private Grandpa grandpa;            // 爷爷
    private HuluBrothers brothers;      // 葫芦兄弟
    private Formation huluFormation;    // 采取的阵型
    private Coordinate huluCenter;      // 队伍的中心位置

    public HuluCamp() {
        grandpa = new Grandpa();
        brothers = new HuluBrothers();
        huluFormation = null;
        huluCenter = new Coordinate();
    }

    @Override
    public void setFormation(Formation huluFormation) {
        this.huluFormation = huluFormation;
    }

    @Override
    public Formation getFormation() {
        return huluFormation;
    }

    @Override
    public void setCenter(Battlefield battlefield) {      // 确定队伍的阵型中心位置
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
            huluCenter.setR(fieldN/2);
            huluCenter.setC(fieldN/4);
            return;
        }
        if(haveEnemy.getR() >= fieldN/2)
        {
            huluCenter.setR(fieldN/4);
        }
        else
        {
            huluCenter.setR(3*fieldN/4);
        }
        if(haveEnemy.getC() >= fieldN/2)
        {
            huluCenter.setC(fieldN/4);
        }
        else
        {
            huluCenter.setC(3*fieldN/4);
        }
    }

    @Override
    public void PlaceTheTroops(Battlefield battlefield) {
        while(!FormationSettle.Settle(battlefield, battlefield.getN(), brothers.getBrothersByArray(),
                brothers.getBrothersByArray().length, huluCenter, huluFormation))
        {
            setCenter(battlefield);
        }
    }

    @Override
    public void FriendlyForcesComeOn(Battlefield battlefield) {
        grandpa.Locating(huluCenter,battlefield);
    }

    @Override
    public void LoudlySupport() {
        grandpa.LoudlySupport();
    }

}
