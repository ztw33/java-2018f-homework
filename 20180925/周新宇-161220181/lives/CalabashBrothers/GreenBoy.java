package lives.CalabashBrothers;

import environment.Land;
import info.Camp;
import lives.Creature;

public class GreenBoy extends Creature {
    //extra attributes
    //...

    public GreenBoy(Land<Creature> land)
    {
        super("四娃",Camp.CB,4,4,0,land);
    }

    //override functions...
    @Override
    public void ShowMyName()
    {
        System.out.print("g");
    }
}
