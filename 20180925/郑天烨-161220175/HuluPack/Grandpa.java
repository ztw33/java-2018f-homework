package HuluPack;

import MotherEarthPack.Entity.Battlefield;
import MotherEarthPack.Scientific.Coordinate;
import MotherEarthPack.Scientific.Creature;
import MotherEarthPack.Scientific.FriendlyForces;

public class Grandpa extends Creature implements FriendlyForces
{
    private static final String name = "爷爷";

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void Locating(Coordinate huluCenter, Battlefield battlefield) {
        for (int i = 0; i < battlefield.getN(); i++) {
            for (int j = 0; j < battlefield.getN(); j++) {
                if((!battlefield.haveCreature(new Coordinate(i,j))) &&
                        (huluCenter.getManhattanDistance(new Coordinate(i,j)) <= safeDistance)) {
                    battlefield.placeACreature(this,new Coordinate(i,j));
                    return;
                }
            }
        }
    }

    @Override
    public void LoudlySupport() {
        System.out.println("\n\n爷爷大喊： 葫芦娃加油 ！！！！！！！！！\n\n");
    }

}
