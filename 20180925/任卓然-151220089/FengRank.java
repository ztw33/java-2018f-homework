package cre_define;

public class FengRank {
    FengRank(Creature c1,Creature []c2, Board b1)
    {
        try
        {
            c1.setxy(10,3);
            c2[0].setxy(11,2);
            c2[1].setxy(11,3);
            c2[2].setxy(11,4);
            c2[3].setxy(12,1);
            c2[4].setxy(12,3);
            c2[5].setxy(12,5);
            c2[6].setxy(13,3);
            c2[7].setxy(14,3);
            c2[8].setxy(15,3);
            c2[9].setxy(16,3);
            b1.set(c1);
            for(Creature temp:c2)
                b1.set(temp);
        }
        catch (outlineException e) {
            System.out.println(e.getMessage());
        }

    }
}
