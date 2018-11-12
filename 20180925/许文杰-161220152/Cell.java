class Cell {
    private Unit unit;
    Cell()//构造方法将该方块置空
    {
        unit = null;
    }
    void setUnit(Unit unit) { this.unit = unit; }
    Unit getUnit(){ return unit; }
    boolean isEmpty(){ return unit==null; }
}
