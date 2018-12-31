package HuluPack;

import MotherEarthPack.Scientific.Creature;

public class SingleHuluBrother extends Creature
{
    private HuluBrotherType aBro;

    SingleHuluBrother(int i)
    {
        switch (i)
        {
            case 1: aBro = HuluBrotherType.TypeOne;break;
            case 2: aBro = HuluBrotherType.TypeTwo;break;
            case 3: aBro = HuluBrotherType.TypeThree;break;
            case 4: aBro = HuluBrotherType.TypeFour;break;
            case 5: aBro = HuluBrotherType.TypeFive;break;
            case 6: aBro = HuluBrotherType.TypeSix;break;
            case 7: aBro = HuluBrotherType.TypeSeven;break;
            default:
                System.out.println("葫芦娃类型初始化错误\n");
        }
    }

    @Override
    public String getName()
    {
        return aBro.getName();
    }

    public String getColor()
    {
        return aBro.getColor();
    }

    public int getRank()
    {
        return aBro.getRank();
    }

    public void SayName()
    {
        System.out.println(aBro.getName() + " ");
    }
    public void SayColor()
    {
        System.out.println(aBro.getColor() + " ");
    }
}