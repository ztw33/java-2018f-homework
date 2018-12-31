package Battle;

import Creatures.*;
import Attributes.*;
import Formations.*;
import java.util.ArrayList;

public class BadGuys {
    ArrayList<Creature>badGuys = new ArrayList<>();
    public BadGuys() {
        badGuys.add(new Snake());
        badGuys.add(new Scorpion());
        for(int i = 0;i < 6;i++) {
            badGuys.add(new Monster());
        }
    }

    public String changeFormation(FormationProvider fp, Battlefield battlefield) {
        String formationName = fp.getName();
        Position[] positions = fp.provideFormation();
        for(Creature badGuy:badGuys) {
            badGuy.setPosition(positions[badGuys.indexOf(badGuy)].getX(),positions[badGuys.indexOf(badGuy)].getY());
        }

        for(Creature badGuy:badGuys) {
            Position pos = badGuy.getPosition();
            battlefield.creatureEnter(badGuy,pos);
        }
        return formationName;
    }
}
