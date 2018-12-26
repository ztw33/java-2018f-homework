package HuluPack;

class HuluBrothers
{
    private SingleHuluBrother[] Brothers;
    public static final int broNum = 7;

    HuluBrothers()
    {
        Brothers = new SingleHuluBrother[broNum];
        Brothers[0] = new SingleHuluBrother(1);
        Brothers[1] = new SingleHuluBrother(2);
        Brothers[2] = new SingleHuluBrother(3);
        Brothers[3] = new SingleHuluBrother(4);
        Brothers[4] = new SingleHuluBrother(5);
        Brothers[5] = new SingleHuluBrother(6);
        Brothers[6] = new SingleHuluBrother(7);
    }

    public SingleHuluBrother[] getBrothersByArray() {
        return Brothers;
    }

    public SingleHuluBrother getBrother(int i)
    {
        return Brothers[i];
    }

    public void setBrother(SingleHuluBrother bro, int i)
    {
        Brothers[i] = bro;
    }

    public String getIthName(int i)
    {
        return Brothers[i].getName();
    }

    public String getIthColor(int i)
    {
        return Brothers[i].getColor();
    }

    public int getIthRank(int i)
    {
        return Brothers[i].getRank();
    }

    public void NumberOffbyName()
    {
        System.out.print("报数:\n");
        for (int i = 0; i < broNum; i++) {
            Brothers[i].SayName();
        }
        System.out.print('\n');
    }

    public void NumberOffbyColor()
    {
        System.out.print("报数:\n");
        for (int i = 0; i < broNum; i++) {
            Brothers[i].SayColor();
        }
        System.out.print('\n');
    }

    public void Swap(int i, int j)
    {
        SingleHuluBrother tempBro = Brothers[i];
        Brothers[i] = Brothers[j];
        Brothers[j] = tempBro;
    }
}