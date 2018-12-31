package com.company.BattleField;

import com.company.Creature.Creature;

public class Coordinate {
    public int X;
    public int Y;
    public boolean empty;
    public Creature creature;
    Coordinate(){
        X=0;
        Y=0;
        empty=true;
        creature = new Creature();
    }
    Coordinate(int i,int j){
        X=i;
        Y=j;
        empty=true;
        creature = new Creature();
    }
    void PrintcreatureName(){
        creature.CreaturePrintName();
    }
}
