package cre_define;

public class TwoLineRank {
    TwoLineRank(Creature []c1,Board b1)
    {
        try
        {
            int i = 0;
            for(Creature temp:c1) {
                temp.setxy(7-i, 3+i%2);
                i++;
                b1.set(temp);
            }

        }
        catch (outlineException e) {
            System.out.println(e.getMessage());
        }

    }
}
