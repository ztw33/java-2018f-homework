package com.company.Formation;

import com.company.BattleField.Coordinate;
import com.company.Creature.Creature;

public interface Formation {
    boolean IfEmpty(Coordinate[][] Field,int x,int y);
    void Setcreatures(Coordinate[][] Field,int x,int y, Creature[] creatures);
}