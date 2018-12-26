package lives.CalabashBrothers;

import environment.Land;
import info.Camp;
import lives.Creature;

public class CyanBoy extends Creature {
    //extra attributes
    //...

    public CyanBoy(Land<Creature> land)
    {
        super("五娃",Camp.CB,5,5,0,land);
    }

    //override functions...
    @Override
    public void ShowMyName()
    {
        System.out.print("c");
    }
}
