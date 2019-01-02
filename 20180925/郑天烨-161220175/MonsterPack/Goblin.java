package MonsterPack;

import MotherEarthPack.Scientific.Creature;

public class Goblin extends Creature
{
    private static final String name = "小喽啰";
    private static int count = 0;

    Goblin(){
        count++;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
