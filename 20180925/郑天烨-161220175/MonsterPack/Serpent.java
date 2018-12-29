package MonsterPack;

import MotherEarthPack.Entity.Battlefield;
import MotherEarthPack.Scientific.Coordinate;
import MotherEarthPack.Scientific.Creature;
import MotherEarthPack.Scientific.FriendlyForces;

public class Serpent extends Creature implements FriendlyForces
{
    private static final String name = "蛇精";

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void Locating(Coordinate monsterCenter, Battlefield battlefield) {
        for (int i = 0; i < battlefield.getN(); i++) {
            for (int j = 0; j < battlefield.getN(); j++) {
                if((!battlefield.haveCreature(new Coordinate(i,j))) &&
                        (monsterCenter.getManhattanDistance(new Coordinate(i,j)) <= safeDistance)) {
                    battlefield.placeACreature(this,new Coordinate(i,j));
                    return;
                }
            }
        }
    }

    @Override
    public void LoudlySupport() {
        System.out.println("\n\n蝎子精大喊： 妖怪们加油 ！！！！！！！！！\n\n");
    }
}
