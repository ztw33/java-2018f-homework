package formation;

import IO.BufferedInputFile;
import creature.CalabashBrother;
import creature.Position;
import creature.Soldier;

import java.io.IOException;
import java.util.List;

public class Crane extends Formation{
    String name;

    public Crane() {
        name = "Goose";
    }
    public void form_C_formation(List<CalabashBrother> a){}
    public void form_S_formation(List<Soldier> a){}
}
