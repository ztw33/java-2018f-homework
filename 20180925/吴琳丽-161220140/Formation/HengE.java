package com.company.Formation;

import com.company.BattleField.Coordinate;
import com.company.Creature.Creature;

import java.util.Scanner;

public class HengE implements Formation {
    public boolean IfEmpty(Coordinate[][] Field, int x, int y) {
        return Field[x][y].empty&&Field[x+1][y+1].empty&&Field[x+2][y].empty&&Field[x+3][y+1].empty&&Field[x+4][y].empty&&Field[x+5][y+1].empty&&Field[x+6][y].empty&&Field[x+7][y+1].empty;
    }

    public void Setcreatures(Coordinate[][] Field, int x, int y, Creature[] creatures) {
        Scanner in=new Scanner(System.in);
        while(!(x<=7&&y<=13)){
            System.out.println("所需要坐标超出范围");
            System.out.println("请重新输入衡轭领队的横坐标: ");
            x=in.nextInt();
            System.out.println("请重新输入衡轭领队的纵坐标:  ");
            y=in.nextInt();
        }
        while(!IfEmpty(Field,x,y)){
            System.out.println("所需要坐标已被占用");
            System.out.println("请重新输入衡轭领队的横坐标: ");
            x=in.nextInt();
            System.out.println("请重新输入衡轭领队的纵坐标:  ");
            y=in.nextInt();
        }
        Field[x][y].creature=creatures[0];
        Field[x][y].empty=false;
        Field[x+1][y+1].creature=creatures[1];
        Field[x+1][y+1].empty=false;
        Field[x+2][y].creature=creatures[2];
        Field[x+2][y].empty=false;
        Field[x+3][y+1].creature=creatures[3];
        Field[x+3][y+1].empty=false;
        Field[x+4][y].creature=creatures[4];
        Field[x+4][y].empty=false;
        Field[x+5][y+1].creature=creatures[5];
        Field[x+5][y+1].empty=false;
        Field[x+6][y].creature=creatures[6];
        Field[x+6][y].empty=false;
        Field[x+7][y+1].creature=creatures[7];
        Field[x+7][y+1].empty=false;
    }
}
