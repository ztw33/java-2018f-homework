enum Color{
    RED,Orange,Yellow,Green,Cyan,Blue,Purple
}
public class Creature {
    //生物共有的属性有名字、在世界上的坐标
    protected boolean greatMan;
    protected String name;
    protected int x,y;//坐标未用到，考虑到以后可能用到
    protected char symbol;
    protected Color color;
    Creature () {
        x = y = 0;
    }
    public char getSymbol () {
        return this.symbol;
    }
    public Color getColor () {
        return this.color;
    }

    public String getName () {
        return this.name;
    }
    public boolean isGreatMan () {
        return this.greatMan;
    }
}

class Calabash extends Creature{//葫芦娃
    private int rank;
    Calabash (int i) {
        super();
        greatMan = true;
        rank = i;
        switch (i){
            case 1:
                name = "老大"; color = Color.RED;     symbol = '1'; break;
            case 2:
                name = "老二"; color = Color.Orange;  symbol = '2'; break;
            case 3:
                name = "老三"; color = Color.Yellow;  symbol = '3'; break;
            case 4:
                name = "老四"; color = Color.Green;   symbol = '4'; break;
            case 5:
                name = "老五"; color = Color.Cyan;    symbol = '5'; break;
            case 6:
                name = "老六"; color = Color.Blue;    symbol = '6'; break;
            case 7:
                name = "老七"; color = Color.Purple;  symbol = '7'; break;
            default:
                break;
        }
    }


}

class GrandfatherOfCalabash extends Creature{//爷爷
    GrandfatherOfCalabash () {
        super();
        greatMan = true;
        name = "老爷爷";
        symbol = '@';
    }
}

class Snake extends Creature{//蛇精
    Snake () {
        super();
        greatMan = false;
        name = "蛇精";
        symbol = '$';
    }
}

class Scorpion extends Creature{//蝎子精
    Scorpion () {
        super();
        greatMan = false;
        name = "蝎子精";
        symbol = '%';
    }
}

class Underling extends Creature{//小喽啰
    Underling () {
        super();
        greatMan = false;
        name = "喽啰";
        symbol = '<';
    }
}

