package gup;

import gup.character.human;

public class unit
{
    boolean is_occupied;
    human people;
    public unit()
    {
        is_occupied = false;
        //people = new human();
    }
    public void setcharacter(human character)
    {
        this.is_occupied = true;
        this.people = character;
    }
    public void setfree()
    {
        this.is_occupied = false;
        this.people = null;
    }
    public boolean get_is_occupied()
    {
        return is_occupied;
    }
    public human gethuman()
    {
        return people;
    }
}
