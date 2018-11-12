public class BattleField {
    private Cell[][] cells;
    private int size;
    BattleField(int size)
    {
        this.size = size;
        cells = new Cell[size][size];
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
            {
                Cell temp = new Cell();
                cells[i][j] = temp;
            }
    }

    public int getSize()
    {
        return size;
    }
    public void setUnit(Unit unit, int x, int y)
    {
        //如果原位置单位与将要移动的单位相同，则将该位置置为空
        if(unit.getX() != -1 && cells[unit.getX()][unit.getY()].getUnit() == unit)
            cells[unit.getX()][unit.getY()].setUnit(null);
        cells[x][y].setUnit(unit);
        unit.set(x,y);
    }

    public void print()
    {
        for(int i = 0;i < size;i++)
        {
            for(int j = 0;j < size;j++)
            {
                if(cells[i][j].isEmpty())
                    System.out.print("____  ");
                else
                    System.out.print(cells[i][j].getUnit().getName()+"  ");
            }
            System.out.println();
        }
    }
}
