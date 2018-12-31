package lives;

import environment.Land;
import info.Camp;
import info.CampInfo;
import info.Mount;
import info.PositionInfo;

public abstract class Creature {
    //battle attributes
    //...

    //non-battle attributes
    private String name = new String("Undefined");
    private CampInfo campInfo;
    private PositionInfo waitingAreaInfo;
    private Mount mount;

    public Creature()
    {
        campInfo = new CampInfo();
        waitingAreaInfo = new PositionInfo();
        mount = new Mount();
    }
    public Creature(String name,Camp c,int fr,int row,int column,Land<Creature> land)
    {
        this.name = name;
        campInfo = new CampInfo(c,fr);
        waitingAreaInfo = new PositionInfo(row,column);
        mount = new Mount(this.name + "'s mount",waitingAreaInfo);
        land.SitOnLand(this);
    }

    public void MoveTo(int row, int column, Land<Creature> oldLand, Land<Creature> newLand)
    {
        oldLand.LeaveLand(this);
        mount.MoveToNewPosition(row,column);
        newLand.SitOnLand(this);
    }
    public CampInfo GetMyCampInfo()
    {
        return this.campInfo;
    }
    public PositionInfo GetMyWaitingAreaInfo()
    {
        return this.waitingAreaInfo;
    }
    public void ShowMyName()
    {
        //...
    }
    public void MoveToWaitingArea(Land<Creature> oldLand,Land<Creature> newLand)
    {
        MoveTo(GetMyWaitingAreaInfo().GetRowPosition(),GetMyWaitingAreaInfo().GetColumnPosition(),oldLand,newLand);
    }
    public int GetMyRowPosition()
    {
        return mount.GetRowPosition();
    }
    public int GetMyColumnPosition()
    {
        return mount.GetColumnPosition();
    }
}

