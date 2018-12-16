package creature;
import formation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grandpa extends Leader implements Creature{
    private Position position;
    private String name;

    public Grandpa(String name){
        this.name = name;
    }
    public void setPosition(Position t){
        position = t;
    }

    public Position getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public void support(){}
    public void check_C_formation(List<CalabashBrother> calabash,String formation){
        switch(formation){
            case "Line": {
                Formation f = new Line();
                f.form_C_formation(calabash);
                break;
            }
            case "Arrow":{
                Formation f = new Arrow();
                f.form_C_formation(calabash);
                break;
            }
        }
    }

    @Override
    public void check_S_Random_formation(List<Soldier> x, int num,Scorpion scorpion) throws IOException {}

    public void check_S_formation(List<Soldier> calabash, String formation) {}
    @Override
    public String toString (){
        return name;
    }
}
