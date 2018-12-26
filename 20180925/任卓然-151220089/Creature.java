package cre_define;
class outlineException extends Exception{}

public class Creature {
    public String name;
    protected int x;
    protected int y;
    Creature(String str)
    {
        name = str;
    }

    void setxy(int x1,int y1) throws outlineException
    {
        if(x1 > 16 || y1 > 10)
            throw new outlineException();
        this.x = x1;
        this.y = y1;
    }
}

class Huluwa extends Creature
{
    Huluwa(String str)
    {
        super(str);
    }


}

class Oldman extends Creature
{
    Oldman(String str)
    {
        super(str);
    }


}

class Xiezi extends Creature
{
    Xiezi(String str)
    {
        super(str);
    }


}

class Snake extends Creature
{
    Snake(String str)
    {
        super(str);
    }


}

class Luoluo extends Creature
{
    Luoluo(String str)
    {
        super(str);
    }


}
