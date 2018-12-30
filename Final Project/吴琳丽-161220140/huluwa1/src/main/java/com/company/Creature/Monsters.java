package com.company.Creature;

public class Monsters {
    final int LouLuoN = 7;
    private Creature[] monsters = new Creature[LouLuoN];
    public Monsters() {
        monsters[0] = new XieZi();
        for(int i =1; i<LouLuoN; i++){
            monsters[i]=new LouLuo();
        }
    }

    public Creature[] getmonsters() {
        return monsters;
    }
}
