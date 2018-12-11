public class Creature {
    protected CreatureName name;

    Creature(){
        this.name = CreatureName.Undefined;
    }
    Creature(CreatureName cn){
        this.name = cn;
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
    //public void cheer(Map map){
    //    map.setCreature(this,map.getSize()/2-1, 0);
    //}
}

class Snake extends Creature{
    Snake(){
        this.name = CreatureName.Snake;
    }
    //public void cheer(Map map){
    //    map.setCreature(this,map.getSize()/2+1, map.getSize()-1);
    //}
}

class Scorpion extends Creature{
    Scorpion(){
        this.name = CreatureName.Scorpion;
    }
}

class Underling extends Creature{
    private int number;

    Underling(int number){
        this.name = CreatureName.Underling;
        this.number = number;
    }
}