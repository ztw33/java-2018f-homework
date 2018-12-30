package com.company.BattleField;

import com.company.Creature.Creature;

import java.io.Serializable;

public class Position implements Serializable {//position
    private int X;
    private int Y;
    public Creature creature;//isempty
    Position(){
        X=0;
        Y=0;
        creature = new Creature();
    }
    Position(int i,int j){
        X=i;
        Y=j;
       // empty=true;
        creature = new Creature();
    }
    public boolean empty(){
        return creature.getname().equals("NULL");
    }
    void printpositionName(){
        creature.creaturePrintName();
    }
}
