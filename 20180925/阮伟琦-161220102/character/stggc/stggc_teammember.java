package gup.character.stggc;

import gup.battlefield;
import gup.character.human;
import gup.colour.*;


public class stggc_teammember extends human
{
    private colours colour;
    public stggc_teammember(java.lang.String name, char code, colours colour)
    {
        this.name = name;
        this.code = code;
        this.colour = colour;
    }
    public void snaketype(int x, int y, int num, battlefield field, human character[]) {
        //field.getfield()[x][y].setcharacter(this);
        for (int i = 0; i < num; i++) {
            field.getfield()[x + i][y].setcharacter(character[i]);
        }
    }
    /*private TEAM ;
    enum SGTTC{
        darjeeling("darjeeling", colours.red);// assam

        private java.lang.String name;
        private colours colour;

        TEAM(java.lang.String name, colours colour)
        {
            this.colour = colour;
            this.name = name;
        }
    }*/
    /*private TEAM team;
    enum TEAM{
        //FIRST("老大", colours.red), SECOND("老二", colours.orange), THIRD("老三", "黄色"),
       //FORTH("老四", "绿色"), FIFTH("老五","青色"), SIXTH("老六", "蓝色"), SEVENTH("老七", "紫色");
        darjeeling("darjeeling", colours.red), assam("assam", colours.yellow),
        orange_pekoe("orange pekoe", colours.orange), rose_hip("rose hip", colours.green),
        rukuriri("rukuriri", colours.cyan), hurb("hurb", colours.blue),
        cranberry("cranberry", colours.purple);

        private java.lang.String name;
        private colours colour;

        TEAM(java.lang.String name, colours colour)
        {
            this.colour = colour;
            this.name = name;
        }
    }*/
}
