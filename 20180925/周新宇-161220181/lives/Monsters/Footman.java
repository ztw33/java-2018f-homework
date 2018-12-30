package lives.Monsters;

import environment.Land;
import info.Camp;
import info.Constants;
import lives.Creature;

public class Footman extends Creature {
    //extra attributes
    //...

    public Footman(int rank, Land<Creature> land)
    {
        super("小喽啰",Camp.MO,rank,rank,Constants.battleFieldColumn-1,land);
    }

    //override functions...
    @Override
    public void ShowMyName()
    {
        System.out.print("f");
    }
}
