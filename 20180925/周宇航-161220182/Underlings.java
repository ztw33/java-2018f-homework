public class Underlings {
    private int SpriteNum;
    private int FormationNum;
    private Sprite []underlings;
    public Underlings(int num)
    {
        SpriteNum = createSpriteNum(num);
        FormationNum = num;
        underlings = new Sprite[SpriteNum];
        for(int i = 0; i < SpriteNum; i++)
        {
            underlings[i] = new Sprite(i);
        }
    }
    public int createSpriteNum(int num)
    {
        int temp = 0;
        switch (num)
        {
            case 1:
                temp = 6;
                break;
            case 2:
                temp = 7;
                break;
            case 3:
                temp = 5;
                break;
            case 4:
                temp = 6;
                break;
            case 5:
                temp = 8;
                break;
            case 6:
                temp = 16;
                break;
            case 7:
                temp = 12;
                break;
            case 8:
                temp = 19;
                break;
        }
        return temp;
    }
    public int getSpriteNum() {
        return SpriteNum;
    }
    public int getSpriteAbscissa(int SpriteOrder)
    {
        return underlings[SpriteOrder].getAbscissa();
    }
    public int getSpriteOrdinate(int SpriteOrder)
    {
        return underlings[SpriteOrder].getOrdinate();
    }
    public void deploySpite(int num)
    {
        switch(num)
        {
            case 1:
                for(int i = 0; i < SpriteNum; i++)
                {
                    underlings[i].setFormation(10, 11 + i);
                }
                break;
            case 2:
                for(int i = 0; i < 3; i++)
                {
                    underlings[i].setFormation(9 - i, 12 + i);
                }
                for(int i = 3; i < 6; i++)
                {
                    underlings[i].setFormation(11 +  i - 3, 12 + i - 3);
                }
                underlings[6].setFormation(10, 11);
                break;
            case 3:
                for(int i = 0; i < 5; i++)
                {
                    underlings[i].setFormation(12 - i, 13 - i);
                }
                break;
            case 4:
                for(int i = 0; i < 3; i++)
                {
                    underlings[i].setFormation(10, 12 + 2 * i);
                }
                for(int i = 3; i < 6; i++)
                {
                    underlings[i].setFormation(9, 11 + 2 * (i - 3));
                }
                break;
            case 5:
                for(int i = 0; i < 3; i++)
                {
                    underlings[i].setFormation(10 + i, 11 + i);
                }
                for(int i = 3; i < 5; i++)
                {
                    underlings[i].setFormation(9 - (i - 3), 12 + i - 3);
                }
                underlings[5].setFormation(11, 14);
                underlings[6].setFormation(10, 15);
                underlings[7].setFormation(9, 14);
                break;
            case 6:
                for(int i = 0; i < 4; i++)
                {
                    underlings[i].setFormation(10 - i, 11 + i);
                }
                for(int i = 4; i < 6; i++)
                {
                    underlings[i].setFormation(12 + (i - 4), 13 + (i - 4));
                }
                for(int i = 6; i < 11; i++)
                {
                    underlings[i].setFormation(8 + (i - 6), 14);
                }
                for(int i = 11; i < 14; i++)
                {
                    underlings[i].setFormation(9 + (i - 11), 13);
                }
                underlings[14].setFormation(10, 12);
                underlings[15].setFormation(10, 15);
                break;
            case 7:
                for(int i = 0; i < 6; i++)
                {
                    underlings[i].setFormation(10,11 + i);
                }
                for(int i = 6; i < 9; i++)
                {
                    underlings[i].setFormation(11 + i - 6, 11 + i - 6);
                }
                for(int i = 9; i < 12; i++)
                {
                    underlings[i].setFormation(9 - (i - 9), 11 + i - 9);
                }
                break;
            case 8:
                for(int i = 0; i < 3; i++)
                {
                    underlings[i].setFormation(10, 11 + i);
                }
                for(int i = 3; i < 6; i++)
                {
                    underlings[i].setFormation(9, 11 + i - 3);
                }
                for(int i = 6; i < 9; i++)
                {
                    underlings[i].setFormation(11, 11 + i - 6);
                }
                for(int i = 9; i < 11; i++)
                {
                    underlings[i].setFormation(8 - (i - 9), 13 + (i - 9));
                }
                for(int i = 11; i < 13; i++)
                {
                    underlings[i].setFormation(12 + (i - 11), 13 + (i - 11));
                }
                for(int i = 13; i < 16; i++)
                {
                    underlings[i].setFormation(8 - (i - 13), 14 + (i - 13));
                }
                for(int i = 16; i < 19; i++)
                {
                    underlings[i].setFormation(12 + (i - 16), 14 + (i - 16));
                }
                break;
            default:
                break;
        }
    }
}
