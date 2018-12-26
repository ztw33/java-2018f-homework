package lives.CalabashBrothers;

import environment.Land;
import info.Camp;
import lives.Creature;

public class RedBoy extends Creature {
    //extra attributes
    //...

    public RedBoy(Land<Creature> land)
    {
        super("大娃",Camp.CB,1,1,0,land);
    }

    //override functions...
    @Override
    public void ShowMyName()
    {
        System.out.print("r");
    }
}
