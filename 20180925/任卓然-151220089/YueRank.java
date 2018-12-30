package cre_define;

public class YueRank {
    YueRank(Creature c1,Creature []c2, Board b1)
    {
        try
        {
            c1.setxy(10,6);
            c2[0].setxy(11,5);
            c2[1].setxy(12,3);
            c2[2].setxy(12,4);
            c2[3].setxy(13,2);
            c2[4].setxy(13,3);
            c2[5].setxy(14,2);
            c2[6].setxy(14,3);
            c2[7].setxy(15,3);
            c2[8].setxy(15,4);
            c2[9].setxy(16,5);
            b1.set(c1);
            for(Creature temp:c2)
                b1.set(temp);
        }
        catch (outlineException e) {
            System.out.println(e.getMessage());
        }

    }
}
