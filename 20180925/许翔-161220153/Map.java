import java.util.ArrayList;

public class Map {
    private Creature[][] map;
    private int size;
    private ArrayList<String> stringArray = new ArrayList<>();
    Map(int size){
        this.size=size;
        map = new Creature[size][size];
    }
    public void setCreature(Creature creature, int x, int y){
        map[y][x] = creature;
        creature.setPosition(x,y);
    }
    public void moveCreature(Creature creature, int x, int y){
        if(creature.getX()==x && creature.getY()==y)
            return;
        map[creature.getY()][creature.getX()] = null;
        map[y][x]=creature;
        storeMovement(creature,x,y);
        creature.setPosition(x,y);
    }
    public void removeCreature(int x, int y){
        Creature creature = map[y][x];
        creature.setPosition(-1,-1);
        map[y][x] = null;
    }
    public int getSize(){
        return size;
    }
    private void storeMovement(Creature creature, int x, int y){
        String tag="";
        switch (creature.getName()){
            case Calabash1:     tag="G0";break;
            case Calabash2:     tag="G1";break;
            case Calabash3:     tag="G2";break;
            case Calabash4:     tag="G3";break;
            case Calabash5:     tag="G4";break;
            case Calabash6:     tag="G5";break;
            case Calabash7:     tag="G6";break;
            case GrandFather:   tag="G7";break;
            case Scorpion:      tag="B0";break;
            case Underling1:    tag="B1";break;
            case Underling2:    tag="B2";break;
            case Underling3:    tag="B3";break;
            case Underling4:    tag="B4";break;
            case Underling5:    tag="B5";break;
            case Underling6:    tag="B6";break;
            case Snake:          tag="B7";break;
            //case Underling7:    tag="B1";break;
            //case Underling8:    tag="B1";break;
            case Undefined:     tag="UN";break;
        }
        String stringX = String.valueOf(x);
        if(x<10)
            stringX = '0'+stringX;
        String stringY = String.valueOf(y);
        if(y<10)
            stringY = '0'+stringY;
        stringArray.add('M'+tag+stringX+stringY);
    }
    public ArrayList<String> getHistory(){
        return stringArray;
    }
}
