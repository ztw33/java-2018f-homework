package lives.CalabashBrothers;

import environment.Land;
import info.Camp;
import lives.Creature;

public class BlueBoy extends Creature {
    //extra attributes
    //...

    public BlueBoy(Land<Creature> land)
    {
        super("六娃",Camp.CB,6,6,0,land);
    }

    //override functions...
    @Override
    public void ShowMyName()
    {
        System.out.print("b");
    }
}
