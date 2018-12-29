package com.company.Creature;

import com.company.BattleField.Coordinate;

import java.util.Scanner;

public class SheJing extends Creature implements Cheer {
    public void Cheers(){
        System.out.println("蛇精：蝎子精和小喽啰们加油呀！");
    }
    public SheJing(){
        super.setName("蛇精");
    }
    public void CreatureCheer( Coordinate[][] Field, int x, int y){
        Scanner in=new Scanner(System.in);
        while(!Field[x][y].empty){
            System.out.println("蛇精的坐标已被占用");
            System.out.println("请重新输入蛇精的横坐标: ");
            x=in.nextInt();
            System.out.println("请重新输入蛇精的纵坐标:  ");
            y=in.nextInt();
        }
        Field[x][y].creature = this;
        Field[x][y].empty=false;
        this.Cheers();
    }
}
