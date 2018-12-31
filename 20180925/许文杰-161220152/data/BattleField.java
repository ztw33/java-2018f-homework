package data;
import sample.*;

public class BattleField {
    private Cell[][] cells;
    private int row;
    private int col;
    public BattleField(int row, int col)
    {
        this.row = row;
        this.col = col;
        cells = new Cell[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
            {
                Cell temp = new Cell();
                cells[i][j] = temp;
            }
    }

    public int getRow()
    {
        return row;
    }
    public int getCol(){return col;}

    public Cell[][] getCells() {
        return cells;
    }

    public void setUnit(Unit unit, int x, int y)
    {
        //如果原位置单位与将要移动的单位相同，则将该位置置为空
        if(unit.getX() != -1 && cells[unit.getX()][unit.getY()].getUnit() == unit)
            cells[unit.getX()][unit.getY()].setUnit(null);
        cells[x][y].setUnit(unit);
        unit.set(x,y);
    }

    public void print(Controller controller)
    {
        for(int i = 0;i < row;i++)
        {
            for(int j = 0;j < col;j++)
            {
                if(cells[i][j].isEmpty())
                {
                    System.out.print("____  ");
                    controller.imageViews[i][j].setImage(null);
                }
                else
                {
                    System.out.print(cells[i][j].getUnit().getName()+"  ");
                    controller.imageViews[i][j].setImage(controller.images.get(cells[i][j].getUnit().getName()));
                }
            }
            System.out.println();
        }
    }
}
