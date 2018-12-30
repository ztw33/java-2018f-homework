package cre_define;

public class YanRank {
    YanRank(Creature []c1,Board b1)
    {
        try
        {
            int i = 0;
            for(Creature temp:c1) {
                temp.setxy(8-i, 1+i);
                i++;
                b1.set(temp);
            }

        }
        catch (outlineException e) {
            System.out.println(e.getMessage());
        }

    }
}
