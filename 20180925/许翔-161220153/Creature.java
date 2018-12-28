public class Creature {
    protected CreatureName name;
    int x;
    int y;
    int blood;
    Creature(){
        this.name = CreatureName.Undefined;
        x=-1;
        y=-1;
        blood=100;
    }
    Creature(CreatureName cn){
        this();
        this.name = cn;
    }
    public CreatureName getName(){
        return this.name;
    }
    public void setPosition(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}

class CalabashBros extends Creature{
    private int number;
    private CalabashColor color;

    CalabashBros(int number){
        this.number = number;
        switch (number){
            case 0:name = CreatureName.Calabash1; color = CalabashColor.RED; break;
            case 1:name = CreatureName.Calabash2; color = CalabashColor.ORANGE; break;
            case 2:name = CreatureName.Calabash3; color = CalabashColor.YELLOW; break;
            case 3:name = CreatureName.Calabash4; color = CalabashColor.GREEN; break;
            case 4:name = CreatureName.Calabash5; color = CalabashColor.CYAN; break;
            case 5:name = CreatureName.Calabash6; color = CalabashColor.BLUE; break;
            case 6:name = CreatureName.Calabash7; color = CalabashColor.PURPLE; break;
        }
    }
}

class GrandFather extends Creature{
    GrandFather(){
        this.name = CreatureName.GrandFather;
    }
}

class Snake extends Creature{
    Snake(){
        this.name = CreatureName.Snake;
    }
}

class Scorpion extends Creature{
    Scorpion(){
        this.name = CreatureName.Scorpion;
    }
}

class Underling extends Creature{
    private int number;

    Underling(int number){
        this.number = number;
        switch (number) {
            case 0:name = CreatureName.Underling1;break;
            case 1:name = CreatureName.Underling2;break;
            case 2:name = CreatureName.Underling3;break;
            case 3:name = CreatureName.Underling4;break;
            case 4:name = CreatureName.Underling5;break;
            case 5:name = CreatureName.Underling6;break;
            case 6:name = CreatureName.Underling7;break;
            case 7:name = CreatureName.Underling8;break;
        }
    }
}
