package cre_define;

public class SnakeRank {
    SnakeRank(Creature []c1,Board b1)
    {
        int i = 0;
        for(Creature temp:c1)
        {
            try {
                temp.setxy(8 - i++, 3);
                b1.set(temp);
            }
            catch (outlineException e)
            {
                System.out.println(e.getMessage());
            }

        }

    }
}
