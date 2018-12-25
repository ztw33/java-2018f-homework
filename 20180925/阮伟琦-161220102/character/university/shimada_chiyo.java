package gup.character.university;

import gup.battlefield;
import gup.character.human;

public class shimada_chiyo extends human
{
    public shimada_chiyo()
    {
        this.name = "chiyo";
        this.code = 'Y';
    }
    public void cheer(battlefield field, int x, int y, human character)
    {
        field.getfield()[x][y].setcharacter(character);
    }
}
