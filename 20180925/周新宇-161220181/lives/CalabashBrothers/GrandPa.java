package lives.CalabashBrothers;

import environment.Land;
import info.Camp;
import lives.Creature;

public class GrandPa extends Creature {
    //extra attributes
    //...

    public GrandPa(Land<Creature> land)
    {
        super("爷爷",Camp.CB,0,0,0,land);
    }

    //override functions...
    @Override
    public void ShowMyName()
    {
        System.out.print("G");
    }
}
