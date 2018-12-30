package Huluwa;

enum PROPERTY{
    COLOR,NAME,LEVEL
}

enum COLOR{
    RED,ORANGE,YELLOW,GREEN,QING,BLUE,PURPLE
}

public abstract class Creature {


    protected String name;
    protected Position position;

    public void setPosition(Position pos){this.position = pos;}
    public Position getPosition(){return this.position;}
    public void leavePosition(){position = null;}

    public abstract void report();

}
