package com.company.Formation;

import com.company.BattleField.Coordinate;
import com.company.Creature.Creature;

import java.util.Scanner;

public class YanYue implements Formation {
    public boolean IfEmpty(Coordinate[][] Field, int x, int y) {
        return Field[x][y].empty&&Field[x+1][y].empty&&Field[x-1][y].empty&&Field[x][y+1].empty&&Field[x+1][y+1].empty&&Field[x-1][y+1].empty &&Field[x][y+2].empty&&Field[x-1][y+2].empty&&Field[x+1][y+2].empty
                &&Field[x+2][y+2].empty&&Field[x-2][y+2].empty&&Field[x+2][y+3].empty&&Field[x-2][y+3].empty&&Field[x+3][y+3].empty&&Field[x-3][y+3].empty&&Field[x+3][y+4].empty&&Field[x-3][y+4].empty&&Field[x+4][y+4].empty&&Field[x-4][y+4].empty;
    }

    public void Setcreatures(Coordinate[][] Field, int x, int y, Creature[] creatures) {
        Scanner in=new Scanner(System.in);
        while(!(x>=4&&y<=10&&x<=10)){
            System.out.println("所需要坐标超出范围");
            System.out.println("请重新输入偃月领队的横坐标: ");
            x=in.nextInt();
            System.out.println("请重新输入偃月领队的纵坐标:  ");
            y=in.nextInt();
        }
        while(!IfEmpty(Field,x,y)){
            System.out.println("所需要坐标已被占用");
            System.out.println("请重新输入偃月领队的横坐标: ");
            x=in.nextInt();
            System.out.println("请重新输入偃月领队的纵坐标:  ");
            y=in.nextInt();
        }
        Field[x][y].creature=creatures[0];
        Field[x][y].empty=false;
        Field[x+1][y].creature=creatures[1];
        Field[x+1][y].empty=false;
        Field[x-1][y].creature=creatures[2];
        Field[x-1][y].empty=false;
        Field[x][y+1].creature=creatures[3];
        Field[x][y+1].empty=false;
        Field[x+1][y+1].creature=creatures[4];
        Field[x+1][y+1].empty=false;
        Field[x-1][y+1].creature=creatures[5];
        Field[x-1][y+1].empty=false;
        Field[x][y+2].creature=creatures[6];
        Field[x][y+2].empty=false;
        Field[x-1][y+2].creature=creatures[7];
        Field[x-1][y+2].empty=false;
        Field[x+1][y+2].creature=creatures[8];
        Field[x+1][y+2].empty=false;
        Field[x+2][y+2].creature=creatures[9];
        Field[x+2][y+2].empty=false;
        Field[x-2][y+2].creature=creatures[10];
        Field[x-2][y+2].empty=false;
        Field[x+2][y+3].creature=creatures[11];
        Field[x+2][y+3].empty=false;
        Field[x-2][y+3].creature=creatures[12];
        Field[x-2][y+3].empty=false;
        Field[x+3][y+3].creature=creatures[13];
        Field[x+3][y+3].empty=false;
        Field[x-3][y+3].creature=creatures[14];
        Field[x-3][y+3].empty=false;
        Field[x+3][y+4].creature=creatures[15];
        Field[x+3][y+4].empty=false;
        Field[x-3][y+4].creature=creatures[16];
        Field[x-3][y+4].empty=false;
        Field[x+4][y+4].creature=creatures[17];
        Field[x+4][y+4].empty=false;
        Field[x-4][y+4].creature=creatures[18];
        Field[x-4][y+4].empty=false;
    }
}
