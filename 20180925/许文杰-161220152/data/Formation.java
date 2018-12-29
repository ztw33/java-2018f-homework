package data;

public class Formation {
    public static void bubble_sort(CalaBashBrother[] gourds, int n)
    {
        for(int i = 0;i < n;i++)
            for(int j = 0;j< n - 1 - i;j++)
                if(gourds[j].getNumber()>gourds[j+1].getNumber())
                {
                    CalaBashBrother temp = gourds[j];
                    gourds[j] = gourds[j+1];
                    gourds[j+1] = temp;
                }
    }

    public static void ChangShe(BattleField field,Camp<? extends Unit> camp, int start)
    {
        if(camp.getLeader().getName().equals("爷爷"))
        {
            field.setUnit(camp.getLeader(), 0,2);
            for(int i = start;i<start+camp.getList().size();i++)
                field.setUnit(camp.getList().get(i-start),i,2);
        }
        else
        {
            field.setUnit(camp.getLeader(), field.getRow()-1,field.getCol()-1);
            for(int i = start;i<start+camp.getList().size();i++)
                field.setUnit(camp.getList().get(i-start),i,field.getCol()-1);
        }
    }

    public static void YanXing(BattleField field,Camp<?> camp, int start_x, int start_y)
    {
        if(camp.getLeader().getName().equals("爷爷"))
        {
            field.setUnit(camp.getLeader(), 0,0);
            for(int i = 0;i<camp.getList().size();i++)
            {
                field.setUnit(camp.getList().get(i),start_x,start_y);
                start_x--;
                start_y++;
            }
        }
        else
        {
            field.setUnit(camp.getLeader(), field.getRow()-1,field.getCol()-1);
            field.setUnit(camp.getList().get(0),start_x,start_y);
            for(int i = 1;i<camp.getList().size();i++)
            {
                start_x--;
                start_y++;
                field.setUnit(camp.getList().get(i),start_x,start_y);
            }
        }
    }

    public static void HengE(BattleField field,Camp<?> camp, int start_x, int start_y)
    {
        if(camp.getLeader().getName().equals("爷爷"))
        {
            field.setUnit(camp.getLeader(), 0, 0);
            for(int i = 0;i<camp.getList().size();i++)
            {

                field.setUnit(camp.getList().get(i),start_x,start_y);
                start_x++;
                if(i%2 == 0)
                    start_y--;
                else
                    start_y++;
            }
        }
        else
        {
            field.setUnit(camp.getLeader(), field.getRow()-1,field.getCol()-1);
            field.setUnit(camp.getList().get(0),start_x,start_y);
            for(int i = 1;i<camp.getList().size();i++)
            {
                start_x++;
                if(i%2 == 1)
                    start_y--;
                else
                    start_y++;
                field.setUnit(camp.getList().get(i),start_x,start_y);
            }
        }
    }
}
