package environment;

import lives.Creature;

public class Land <T extends Creature>{
    //self attributes
    private int row = -1;
    private int column = -1;

    //creature attributes
    private boolean isUsed = false;
    private T creature;

    public Land() {}
    public Land(int r,int c)
    {
        this.row = r;
        this.column = c;
    }
    public boolean SitOnLand(T c)
    {
        if(!isUsed)
        {
            this.creature = c;
            isUsed = true;
            return true;
        }
        else
        {
            System.out.println("This land has been used!");
            return false;
        }
    }
    public boolean LeaveLand(T c)
    {
        if(isUsed && c == this.creature)
        {
            isUsed = false;
            return true;
        }
        else
            return false;
    }
    public boolean IsLandUsed()
    {
        return this.isUsed;
    }
    public void ShowUserName()
    {
        creature.ShowMyName();
    }
}
