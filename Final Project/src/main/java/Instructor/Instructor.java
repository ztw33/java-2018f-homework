package Instructor;

import Creature.CalaBrosAdapter;
import Creature.CalaBrothers;
import Creature.MonsterAdapter;
import Formation.Formation;
import Formation.FormationAdapter;
import MyMap.MyMap;
import jdk.nashorn.internal.runtime.ECMAException;

import java.util.Collections;
import java.util.Comparator;

import static Creature.CommanderCalabro.Grandpa;
import static Creature.CommanderMonster.Serpent;

public class Instructor {
    public Instructor(){
    }
    public static void myinit(){
        CalaBrosAdapter.initArrayBros();
        MonsterAdapter.initMice();
        FormationAdapter.initFormations();
        MyMap.initMap();
        Serpent.setFormationMonster(FormationAdapter.getFormationId("Crane"),15,10);
        Grandpa.setFormationCalaBros(FormationAdapter.getFormationId("Crane"),5,10);
    }
    public static void getRandomArray() {
        Collections.shuffle(CalaBrosAdapter.CalaBros);
    }

    public static void mySortCalaBros(){
        Collections.sort(CalaBrosAdapter.CalaBros, new Comparator<CalaBrothers>(){
            @Override
                public int compare(CalaBrothers ca1,CalaBrothers ca2){
                    return ca1.getRank() - ca2.getRank();
            }
        });
    }
}
