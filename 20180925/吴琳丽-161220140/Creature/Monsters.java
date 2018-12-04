package com.company.Creature;

import com.company.Creature.LouLuo;
import com.company.Creature.Creature;
import com.company.Creature.XieZi;

public class Monsters {

    final int LouLuoN = 20;
    public Creature[] monsters = new Creature[LouLuoN];
    public Monsters() {
        monsters[0] = new XieZi();
        for(int i =1; i<LouLuoN; i++){
            monsters[i]=new LouLuo();
        }
    }
}
