

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
            pattern.add(new Coordinate(i,0));
    }
}

class WingFormation extends Formation{
    WingFormation(int num){
        int singleWing=(num-1)/2;
        pattern.add(new Coordinate(singleWing,0));
        for(int i=0;i<singleWing;i++)
            pattern.add(new Coordinate(singleWing-1-i,i+1));
        for(int i=0;i<(num-1-singleWing);i++)
            pattern.add(new Coordinate(singleWing+1+i,i+1));
    }
}

class GeeseFormation extends Formation{
    GeeseFormation(int num){
        for(int i=0;i<num;i++)
            pattern.add(new Coordinate(num-i-1,i));
    }
}
