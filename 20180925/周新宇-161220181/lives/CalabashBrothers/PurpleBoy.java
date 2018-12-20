package lives.CalabashBrothers;

import environment.Land;
import info.Camp;
import lives.Creature;

public class PurpleBoy extends Creature {
    //extra attributes
    //...

    public PurpleBoy(Land<Creature> land)
    {
        super("七娃",Camp.CB,7,7,0,land);
    }

    //override functions...
    @Override
    public void ShowMyName()
    {
        System.out.print("p");
    }
}
