package formation;

import IO.BufferedInputFile;
import creature.CalabashBrother;
import creature.Position;
import creature.Soldier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arrow extends Formation {
    String name;

    public Arrow() {
        name = "Arrow";
    }

    @Override
    public void form_C_formation(List<CalabashBrother> a) {
    }
    public void form_S_formation(List<Soldier> a){
        int No = 0;
        int num = a.size();
        int c,b;         //保证b是偶数,排成锋矢形
        if(num % 2 != 0){
            if((num / 2) %2 !=0){
                c = num/2;
                b = num - c;
            }
            else{
                b = num/2;
                c = num -b;
            }
        }
        else{
            if((num/2)%2!=0){
                c = num/2 -1;
                b =num -c;
            }
            else{
                c = num/2 ;
                b = num/2;
            }
        }
        Position p ;
        Soldier s;
        for(No = 0; No < c;No++){
            p = new Position(10,9+No);
            s = new Soldier(p,a.get(No).getName());
            a.set(No,s);
        }
        for(No = c;No<c+b/2;No++){
            p = new Position(9-No+c,10+No-c);
            s = new Soldier(p,a.get(No).getName());
            a.set(No,s);
        }
        for(No = c + b/2;No<c + b;No++){
            p = new Position(11+No-c-b/2,10+No-c-b/2);
            s = new Soldier(p,a.get(No).getName());
            a.set(No,s);
        }
    }
}
