package info;

public class Mount{
    //self-attributes
    private String name = new String("Undefined");
    private int rowPosition = -1;
    private int columnPosition = -1;

    public Mount(){}
    public Mount(String name, PositionInfo positionInfo)
    {
        this.name = name;
        this.rowPosition = positionInfo.GetRowPosition();
        this.columnPosition = positionInfo.GetColumnPosition();
    }
    public void MoveToNewPosition(int row,int column)
    {
        this.columnPosition = column;
        this.rowPosition = row;
    }
    public int GetRowPosition()
    {
        return this.rowPosition;
    }
    public int GetColumnPosition()
    {
        return this.columnPosition;
    }
}
