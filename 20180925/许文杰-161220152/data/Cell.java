package data;

public class Cell {
    private Unit unit;
    Cell()//构造方法将该方块置空
    {
        unit = null;
    }
    public void setUnit(Unit unit) { this.unit = unit; }
    public Unit getUnit(){ return unit; }
    public boolean isEmpty(){ return unit==null; }
}
