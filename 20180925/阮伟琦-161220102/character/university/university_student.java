package gup.character.university;

import gup.battlefield;
import gup.character.human;

public class university_student extends human
{
    public university_student()
    {
        this.code = 'U';
    }

    private void clear(battlefield field)
    {
        for(int i = 0; i < 17; i++)
            for(int j = 0; j < 17; j++)
                if(field.getfield()[i][j].get_is_occupied())
                    if(university_student.class.isInstance(field.getfield()[i][j].gethuman()))
                        field.getfield()[i][j].setfree();
    }

    public void snaketype(int x, int y, int num, battlefield field, human character[]) {
        clear(field);
        field.getfield()[x][y].setcharacter(this);
        for (int i = 1; i < num; i++) {
            field.getfield()[x + i][y].setcharacter(character[i - 1]);
        }
    }

    public void cranewingtype(int x, int y, int num, battlefield field, human leader, human character[])//x = 10,y = 13
    {
        /*for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }*/
        clear(field);
        for(int i = 0; i < num/2; i++)//x = 7
        {
            field.getfield()[x - 3 + i][y - 3 + i].setcharacter(character[i]);// = university_members[i - 7];
            //field[i][i + 3].is_occupied = true;
        }
        for(int i = 0; i < num/2; i++)
        {
            field.getfield()[x - i - 1][y + i + 1].setcharacter(character[num/2 + i]);// = university_members[i - 11];
            //field[23 - i][i].is_occupied = true;
        }
        field.getfield()[x][y].setcharacter(leader);// = alice;
        //field[10][13].is_occupied = true;

    }

    public void gooseflyingtype(int x, int y, int num, battlefield field, human leader, human character[])//(11,10)
    {
        /*for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }*/
        clear(field);
        field.getfield()[x][y].setcharacter(leader);//is_occupied = true;
        //field[11][10].people = alice;
        for(int i = 0; i < num - 1; i++)
        {
            field.getfield()[x + 1 + i][y - 1 - i].setcharacter(character[i]);//is_occupied = true;
            //field[21 - i][i].people = university_members[i - 11];
        }
    }

    public void horizontalwheeltype(int x, int y, int num, battlefield field, human leader, human character[])//(5,15)
    {
        /*for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }*/
        clear(field);
        field.getfield()[x][y].setcharacter(leader);//is_occupied = true;
        //field[5][15].people = alice;
        for(int i = 0; i < num - 1; i+=2)
        {
            field.getfield()[x + 2 + i][y].setcharacter(character[i]);//is_occupied = true;
            //field[i][15].people = university_members[i - 7];
        }
        for(int i = 1; i < num - 1; i+=2)
        {
            field.getfield()[x + i][y + 1].setcharacter(character[i]);//is_occupied = true;
            //field[i][16].people = university_members[i - 5];
        }
    }

    public void arrowtype(int x, int y, int num, battlefield field, human leader, human character[])//(9,15)
    {
        /*for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }*/
        clear(field);
        field.getfield()[x][y].setcharacter(leader);//is_occupied = true;
        //field[6][14].people = alice;
        field.getfield()[x + 1][y - 1].setcharacter(character[0]);//is_occupied = true;
        //field[7][13].people = university_members[0];
        field.getfield()[x + 1][y + 1].setcharacter(character[1]);//is_occupied = true;
        //field[7][15].people = university_members[1];
        field.getfield()[x + 2][y - 2].setcharacter(character[2]);//is_occupied = true;
        //field[8][12].people = university_members[2];
        field.getfield()[x + 2][y + 2].setcharacter(character[3]);//is_occupied = true;
        //field[8][14].people = university_members[3];
        field.getfield()[x + 2][y].setcharacter(character[4]);//is_occupied = true;
        //field[8][16].people = university_members[4];
        field.getfield()[x + 4][y].setcharacter(character[5]);//is_occupied = true;
        //field[9][14].people = university_members[5];*/
        /*for(int i = 1; i <= num; i++)
        {
            for(int j = 1; j < i; j++)
            field.getfield()[x]
        }*/

    }

}
