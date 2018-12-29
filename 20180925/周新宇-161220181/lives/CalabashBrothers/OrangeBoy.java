package lives.CalabashBrothers;

import environment.Land;
import info.Camp;
import lives.Creature;

public class OrangeBoy extends Creature {
    //extra attributes
    //...

    public OrangeBoy(Land<Creature> land)
    {
        super("二娃",Camp.CB,2,2,0,land);
    }

    //override functions...
    @Override
    public void ShowMyName()
    {
        System.out.print("o");
    }
}
