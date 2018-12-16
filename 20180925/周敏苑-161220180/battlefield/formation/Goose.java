package formation;

import IO.BufferedInputFile;
import creature.CalabashBrother;
import creature.Position;
import creature.Soldier;

import java.io.IOException;
import java.util.List;

public class Goose extends Formation{
    String name;

    public Goose() {
        name = "Goose";
    }
    public void form_C_formation(List<CalabashBrother> a){}
    public void form_S_formation(List<Soldier> a){
        int No;
        int num = a.size();
        Position p ;
        Soldier s;
        if (num > 15){
            for(No = 0 ; No <15;No++){
                p = new Position(17-No,5+No);
                s = new Soldier(p,a.get(No).getName());
                a.set(No,s);
            }
            for(No = 15; No < num;No++){
                p = new Position(17-No+15,6+No-15);
                s = new Soldier(p,a.get(No).getName());
                a.set(No,s);
            }
        }
        else{
            for(No = 0; No<num;No++){
                p = new Position(10+num/2-No,11-num/2+No);
                s = new Soldier(p,a.get(No).getName());
                a.set(No,s);
            }
        }
    }
}
