package com.company.Creature;

import com.company.BattleField.Position;

import java.util.Scanner;

public class SheJing extends Creature implements Cheer {
    public void cheers(){
        System.out.println("蛇精：蝎子精和小喽啰们加油呀！");
    }
    public SheJing(){
        super("蛇精");
        goodcreature=false;
    }
    public void creatureCheer( Position[][] Field, int x, int y){
        Scanner in=new Scanner(System.in);
        while(!Field[x][y].empty()){
            return;
        }
        Field[x][y].creature = this;
        setXY(x,y);
        this.cheers();
    }
}
