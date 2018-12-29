package lives.Monsters;

import environment.Land;
import info.Camp;
import info.Constants;
import lives.Creature;

public class Snake extends Creature {
    //extra attributes
    //...

    public Snake(Land<Creature> land)
    {
        super("蛇精",Camp.MO,0,0,Constants.battleFieldColumn-1,land);
    }

    //override functions...
    @Override
    public void ShowMyName()
    {
        System.out.print("S");
    }
}
