
package main.java;
import java.util.ArrayList;

public class Formation{
    ArrayList <Coordinate>pattern;
    Formation(){
        pattern = new ArrayList<>();
    }
}
class SnakeFormation extends Formation{
    SnakeFormation(int num){
        for(int i=0;i<num;i++)
            pattern.add(new Coordinate(0,i));
    }
}

class WingFormation extends Formation{
    WingFormation(int num){
        int singleWing=(num-1)/2;
        pattern.add(new Coordinate(0,singleWing));
        for(int i=0;i<singleWing;i++)
            pattern.add(new Coordinate(i+1,singleWing-1-i));
        for(int i=0;i<(num-1-singleWing);i++)
            pattern.add(new Coordinate(i+1,singleWing+1+i));
    }
}

class GeeseFormation extends Formation{
    GeeseFormation(int num){
        for(int i=0;i<num;i++)
            pattern.add(new Coordinate(num-i-1,i));
    }
}
