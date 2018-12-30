package com.company.Formation;

import com.company.BattleField.Position;
import com.company.Creature.Creature;

public interface Formation {
    boolean ifEmpty(Position[][] Field,int x,int y);
    void setCreatures(Position[][] Field,int x,int y, Creature[] creatures);
}