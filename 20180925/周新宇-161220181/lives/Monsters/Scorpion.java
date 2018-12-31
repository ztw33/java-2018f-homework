package lives.Monsters;

import environment.Land;
import info.Camp;
import info.Constants;
import lives.Creature;

public class Scorpion extends Creature {
    //extra attributes
    //...

    public Scorpion(Land<Creature> land)
    {
        super("蝎子精",Camp.MO,1,1,Constants.battleFieldColumn-1,land);
    }

    //override functions...
    @Override
    public void ShowMyName()
    {
        System.out.print("s");
    }
}
