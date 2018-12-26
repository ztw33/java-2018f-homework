package gup.character.stggc;

import gup.battlefield;
import gup.character.cheer;
import gup.character.human;
//import gup.cheer;

public class stggc_student extends human implements cheer
{
    public stggc_student(java.lang.String name, char code)
    {
        this.name = name;
        this.code = code;
    }
    //@Override
    public void cheer(battlefield field, int x, int y, human character)
    {
        field.getfield()[x][y].setcharacter(character);
    }
    //public stggc_student(){};
    //public stggc_teammember(){};
}