class Cell
{
    private boolean isEmpty;
    private Unit unit;
    Cell()
    {
        isEmpty = true;
    }
    public void setUnit(Unit unit)
    {
        this.unit = unit;
    }
    public void setEmpty(boolean x){ isEmpty = x; }
    public Unit getUnit(){ return unit; }
    public boolean getStatus(){ return isEmpty; }
}


public class BattleField {
    private Cell[][] cells = new Cell[15][15];
    BattleField()
    {
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++)
            {
                Cell temp = new Cell();
                cells[i][j] = temp;
            }
    }
    public void print()
    {
        for(int i = 0;i<15;i++)
        {
            for(int j = 0;j < 15;j++)
            {
                if(cells[i][j].getStatus())
                    System.out.print("____  ");
                else
                    System.out.print(cells[i][j].getUnit().getName()+"  ");
            }
            System.out.println("");
        }
    }
    public Cell[][] getCells(){return cells;}
}
