package calabash;

public class Creature {
    private Location locate;
    private String printindex;
    Creature(){
    }
    /*Creature(int x, int y){
        locate = new Location(x, y);
    }*/
    public void setlocation(Location l){
        locate = new Location(l);
    }
    public void setprintindex(String str){
        printindex = str;
    }
    public String getprintindex(){
        return printindex;
    }
    public Location getlocate(){
        return locate;
    }
}

class Calabash extends Creature{
    private int rank;
    private int order;
    Calabash(String str, int rank1, int x, int y, int order1){
        setprintindex(str);
        setlocation(new Location(x, y));
        rank = rank1;
        order = order1;
    }
    public void changeorder(int neworder){
        order = neworder;
    }
    public int getrank(){
        return rank;
    }
}

class Grandfather extends Creature{
    Grandfather(String str, int x, int y){
        setprintindex(str);
        setlocation(new Location(x, y));
    }
}

class Snake extends Creature{
    Snake(String str, int x, int y){
        setprintindex(str);
        setlocation(new Location(x, y));
    }
}

class Scorpion extends Creature{
    Scorpion(String str, Location l){
        setprintindex(str);
        setlocation(l);
    }
}

class Underling extends Creature{
    int id;
    Underling(String str, int id1,Location l){
        setprintindex(str);
        id = id1;
        setlocation(l);
    }
}
class None extends Creature{

}