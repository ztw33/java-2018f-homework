package gup.character;

import gup.battlefield;

public class human {
    protected java.lang.String name;
    protected char code;
    //int no;
    //colours colour;
    //int row;
    //int col;
    /*void stggc_snaketype()
    {
        /*for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }
        for(int i = 5; i < 12; i++)
        {
            field[i][0].is_occupied = true;
            field[i][0].people = stggc_members[i - 5];
        }

        //field[0][1].people = stggc_members[0];
    }*/

    public void snaketype(int x, int y, int num, battlefield field, human character[])
    {
        /*for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }
        field[5][16].is_occupied = true;
        field[5][16].people = alice;
        for(int i = 6; i < 12; i++)
        {
            field[i][16].is_occupied = true;
            field[i][16].people = university_members[i - 6];
        }
        field.getfield()[x][y].setcharacter(leader);
        for(int i = 0; i < num; i++) {
            field.getfield()[x + i][y].setcharacter(character[i]);
            field.getfield()[x][y + 1].setcharacter(character[i+1]);
            field.getfield()[x][y + 2].setcharacter(character[i2]);
            field.getfield()[x][y + 3].setcharacter(character[3]);
            field.getfield()[x][y + 4].setcharacter(character[4]);
            field.getfield()[x][y + 5].setcharacter(character[5]);
            field.getfield()[x][y + 6].setcharacter(character[6]);
        }*/
    }


    public char getcode()
    {
        return this.code;
    }
}