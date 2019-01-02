package cre_define;

public class FishRank {
    FishRank(Creature c1,Creature []c2,Board b1)
    {
        try {
            c1.setxy(10, 3);
            c2[0].setxy(11, 3);
            for (int i = 0; i < 3; ++i)
                c2[i + 1].setxy(12, i + 2);
            for (int i = 0; i < 5; ++i)
                c2[i + 4].setxy(13, i + 1);
            c2[9].setxy(14, 3);
            b1.set(c1);
            for(Creature temp:c2)
                b1.set(temp);
        }
        catch (outlineException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
