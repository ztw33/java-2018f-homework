package lives.CalabashBrothers;

import environment.Land;
import info.Camp;
import lives.Creature;

public class YellowBoy extends Creature {
    //extra attributes
    //...

    public YellowBoy(Land<Creature> land)
    {
        super("三娃",Camp.CB,3,3,0,land);
    }

    //override functions...
    @Override
    public void ShowMyName()
    {
        System.out.print("y");
    }
}
