package formation;

import java.io.IOException;
import java.util.List;

import IO.BufferedInputFile;
import creature.*;

public class Line extends Formation {
    String name;

    public Line() {
        name = "Line";
    }

    @Override
    public void form_C_formation(List<CalabashBrother> a) {
        int i = 3;
        Position p = new Position(i,3);
        for (CalabashBrother b:a) {
            b.setPosition(p);
            i+=2;
            p = new Position(i,3);
        }
    }
    public void form_S_formation(List<Soldier> a){
        int i = 3;
        Position p = new Position(i,13);
        for (Soldier b:a) {
            b.setPosition(p);
            i+=2;
            p = new Position(i,13);
        }
    }
}
