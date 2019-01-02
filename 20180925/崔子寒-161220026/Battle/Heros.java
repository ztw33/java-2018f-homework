package Battle;

import Creatures.*;
import Attributes.*;
import Formations.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Heros {
    private ArrayList<Creature> heros;
    public Heros() {
        heros = new ArrayList<>();
        heros.addAll(Arrays.asList(new CalabashBrother(Color.RED),new CalabashBrother(Color.ORANGE),
                new CalabashBrother(Color.YELLOW), new CalabashBrother(Color.GREEN),new CalabashBrother(Color.BLUE),
                new CalabashBrother(Color.CYAN),new CalabashBrother(Color.PURPLE)));
        heros.add(new Grandfather());
    }

    public String changeFormation(FormationProvider fp, Battlefield battlefield) {
        String formationName = fp.getName();
        Position[] positions = fp.provideFormation();
        for(Creature hero:heros) {
            hero.setPosition(positions[heros.indexOf(hero)].getX(),15-positions[heros.indexOf(hero)].getY());
        }

        for(Creature hero:heros) {
            Position pos = hero.getPosition();
            battlefield.creatureEnter(hero,pos);
        }
        return formationName;
    }

}
