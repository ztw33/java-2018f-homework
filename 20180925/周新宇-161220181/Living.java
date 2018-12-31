enum CAMP {CB, MO, NE}
//CB stands for CalabashBrothers, MO stands for monsters, NE stands for neutrals

public class Living {
    String myName;
    boolean isAlive;
    boolean hasMount;
    CAMP myCamp;
    int myFamilyRank;
    Mount myMount;
    Living()
    {
        myName = new String("unknownName");
        isAlive = true;
        myCamp = CAMP.NE;
        myFamilyRank = -1;
        hasMount = false;
        myMount = new Mount();
    }
    public void TellMyName()
    {
        System.out.println(myName);
    }
    public CAMP TellMyCamp()
    {
        return myCamp;
    }
    public int TellMyRowPosition()
    {
        return myMount.GetRowPosition();
    }
    public int TellMyColumnPosition()
    {
        return myMount.GetColumnPosition();
    }
    public void SitInBattleField(Land[][] land)
    {
        myMount.EnterBattleField(land);
    }
    public void GoTo(int rowPosition,int columnPosition,Land oldLand,Land newLand)
    {
        if(hasMount)
            myMount.MoveTo(rowPosition, columnPosition, oldLand, newLand);
        else
            System.out.println("I don't have a mount!");
    }
}
