package info;

public class PositionInfo {
    private int row = -1;
    private int column = -1;

    public PositionInfo(){}
    public PositionInfo(int r,int c)
    {
        this.row = r;
        this.column = c;
    }
    public int GetRowPosition()
    {
        return this.row;
    }
    public int GetColumnPosition()
    {
        return this.column;
    }
    public void SetPosition(int r,int c)
    {
        this.row = r;
        this.column = c;
    }
}
