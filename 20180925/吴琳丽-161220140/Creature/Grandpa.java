package com.company.Creature;

import com.company.BattleField.Coordinate;

import java.util.Scanner;

public class Grandpa extends Creature implements Cheer {
    public void Cheers(){
        System.out.println("爷爷：我的葫芦娃们加油呀！");
    }
    public Grandpa(){
        super.setName("爷爷");
    }
    public void CreatureCheer(Coordinate[][] Field, int x, int y){
        Scanner in=new Scanner(System.in);
        while(!Field[x][y].empty){
            System.out.println("爷爷的坐标已被占用");
            System.out.println("请重新输入爷爷的横坐标: ");
            x=in.nextInt();
            System.out.println("请重新输入爷爷的纵坐标:  ");
            y=in.nextInt();
        }
        Field[x][y].creature = this;
        Field[x][y].empty=false;
        this.Cheers();
    }
}
