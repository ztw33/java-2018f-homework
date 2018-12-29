import java.util.Random;

enum GourdDollEnum{
    RED(1, "大娃"), ORINGE(2, "二娃"), YELLOW(3, "三娃"), GREEN(4, "四娃"), INDIGO(5, "五娃"), BLUE(6, "六娃"), PURPLE(7, "七娃");

    private final int rank;
    private final String name;

    private GourdDollEnum(int rank, String name){
        this.rank = rank;
        this.name = name;
    }

    public int getRank() { return this.rank; }
    public String getName() { return this.name; }
}

enum MonsterEnum{
    SNAKE(0, "蛇精"), SCORPION(1, "蝎子"), UNDER(2, "喽啰");

    private final int rank;
    private final String name;

    private MonsterEnum(int rank, String name){
        this.rank = rank;
        this.name = name;
    }

    public int getRank() { return this.rank; }
    public String getName() { return this.name; }
}

class Position{
    private int x;
    private int y;

    public Position(Tuple tuple) { this.x = tuple.x; this.y = tuple.y; }
    public void printPosition() { System.out.println("(" + this.x + "," + this.y + ")"); }
    public void changePosition(Tuple tuple) {this.x = tuple.x; this.y = tuple.y; }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }

}

public class Creature {
    protected int rank;
    protected String name;
    protected Position position;

    public boolean isBigger(Creature bro){ return this.rank < bro.rank; }

    public void printInfo(){
        System.out.println("rank:" + rank + " name:" + name);
    }

    public void setPosition(Tuple tuple){
        position = new Position(tuple);
    }

    public int getRank() { return rank; }
    public String getName() { return name; }

}

class GourdDolls {
    private void swap(GourdDoll[] gourdDolls, int i, int j){
        GourdDoll temp = gourdDolls[i];
        gourdDolls[i] = gourdDolls[j];
        gourdDolls[j] = temp;
    }

    public void disorder(GourdDoll[] gourdDolls){
        Random ra = new Random();
        for(int i = 0; i < 40; ++i)
            swap(gourdDolls, ra.nextInt(7), ra.nextInt(7));
    }

    public void printGourdDolls(GourdDoll[] gourdDolls){
        for(int i = 0; i < gourdDolls.length; ++i)
            gourdDolls[i].printInfo();
    }

    public void orderThem(GourdDoll[] gourdDolls){
        for(int i = 0; i < gourdDolls.length; ++i)
            for(int j = i+1; j < gourdDolls.length; ++j)
                if(gourdDolls[j].isBigger(gourdDolls[i]))
                    swap(gourdDolls, i, j);
    }
}

class GourdDoll extends Creature {
    public GourdDoll(GourdDollEnum gourdDoll){
        this.rank = gourdDoll.getRank();
        this.name = gourdDoll.getName();
    }
}

class Monster extends Creature {
    public Monster(MonsterEnum monster){
        this.rank = monster.getRank();
        this.name = monster.getName();
    }
}

class Grandpa extends Creature {
    public Grandpa(){
        this.rank = 0;
        this.name = "爷爷";
    }
}