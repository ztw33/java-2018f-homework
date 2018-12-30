package com.company.Formation;

import com.company.BattleField.Position;
import com.company.Creature.Creature;

import java.util.Scanner;

public class YanYue implements Formation {
    public boolean ifEmpty(Position[][] Field, int x, int y) {
        return Field[x][y].empty()&&Field[x+1][y].empty()&&Field[x-1][y].empty()&&Field[x][y+1].empty()&&Field[x+1][y+1].empty()&&Field[x-1][y+1].empty() &&Field[x][y+2].empty()&&Field[x-1][y+2].empty()&&Field[x+1][y+2].empty()
                &&Field[x+2][y+2].empty()&&Field[x-2][y+2].empty()&&Field[x+2][y+3].empty()&&Field[x-2][y+3].empty()&&Field[x+3][y+3].empty()&&Field[x-3][y+3].empty()&&Field[x+3][y+4].empty()&&Field[x-3][y+4].empty()&&Field[x+4][y+4].empty()&&Field[x-4][y+4].empty();
    }

    public void setCreatures(Position[][] Field, int x, int y, Creature[] creatures) {
        while(!(x>=4&&y<=15&&x<=15)){
            return;
        }
        while(!ifEmpty(Field,x,y)){
            return;
        }
        Field[x][y].creature=creatures[0];
        creatures[0].setXY(x,y);
        Field[x+1][y].creature=creatures[1];
        creatures[1].setXY(x+1,y);
        Field[x-1][y].creature=creatures[2];
        creatures[2].setXY(x-1,y);
        Field[x][y+1].creature=creatures[3];
        creatures[3].setXY(x,y+1);
        Field[x+1][y+1].creature=creatures[4];
        creatures[4].setXY(x+1,y+1);
        Field[x-1][y+1].creature=creatures[5];
        creatures[5].setXY(x-1,y+1);
        Field[x][y+2].creature=creatures[6];
        creatures[6].setXY(x,y+2);
    }
}
