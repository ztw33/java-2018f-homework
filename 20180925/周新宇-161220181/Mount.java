enum MountType {LOTUS, FOOT, UNKNOWN}

public class Mount {
    String ownerName;
    MountType myType;
    int rowPosition;
    int columnPosition;
    boolean isUsed;
    Mount()
    {
        ownerName = new String("unknownName");
        myType = MountType.UNKNOWN;
        rowPosition = -1;
        columnPosition = -1;
        isUsed = false;
    }
    Mount(String name, MountType type)
    {
        ownerName = name;
        myType = type;
        rowPosition = -1;
        columnPosition = -1;
        isUsed = true;
    }
    public boolean PickUp(String name, MountType type)
    {
        if(!isUsed)
        {
            ownerName = name;
            myType = type;
            rowPosition = -1;
            columnPosition = -1;
            isUsed = true;
            return true;
        }
        else
        {
            System.out.println("This Mount has been picked up!");
            return false;
        }
    }
    public boolean AskForOwner()
    {
        return isUsed;
    }
    public void EnterBattleField(Land[][] land)
    {
        for(int i = 10;i < 20;i++)
            for(int j = 10;j < 20;j++)
                if(!land[i][j].isUsedUp())
                {
                    rowPosition = i;
                    columnPosition = j;
                    land[i][j].SitHere(ownerName);
                    return;
                }
    }
    public void MoveTo(int newRow, int newColumn,Land oldLand,Land newLand)
    {
        rowPosition = newRow;
        columnPosition = newColumn;

        //System.out.println("Start");

        //land.GetUserName();
        oldLand.GoAway();
        newLand.SitHere(ownerName);

        //System.out.println("End");
    }
    public int GetRowPosition()
    {
        return rowPosition;
    }
    public int GetColumnPosition()
    {
        return columnPosition;
    }
    //...
}
