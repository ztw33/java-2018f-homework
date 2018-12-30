package com.company.Creature;

import com.company.BattleField.Position;


public class Grandpa extends Creature implements Cheer {
    public void cheers(){
        System.out.println("爷爷：我的葫芦娃们加油呀！");
    }
    public Grandpa(){
        super("爷爷");
    }
    public void creatureCheer(Position[][] Field, int x, int y){

        while(!Field[x][y].empty()){
            return;
        }
        Field[x][y].creature = this;
        setXY(x,y);
        this.cheers();
    }
}
