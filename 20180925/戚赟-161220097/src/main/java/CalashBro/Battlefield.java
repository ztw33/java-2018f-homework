package CalashBro;


import javafx.scene.canvas.Canvas;

public class Battlefield {
    private int x;
    private int y;
    private thePosition[][] field;

    public Battlefield(int x,int y) {
        field = new thePosition[x][y];
        this.x = x;
        this.y = y;
        for(int i =0;i<x;i++)
        {
            for(int j = 0; j < y;j++)
            {
                field[i][j] = new thePosition(i,j);
            }
        }
    }

    public void putTheCre(Creature temp,int i,int j) {
        field[i][j].getCre(temp);
    }

    public void movTheCre(Creature temp,int i,int j) {
        int x = temp.getI();
        int y = temp.getJ();
        //未放置
        if(x == -1 && y == -1)
        {
            field[i][j].getCre(temp);
        }
        else if(x != i || y != j)
        {
            if(field[i][j].isEmpty() == false)
            {
            //交换
                field[i][j].swapCre(field[x][y]);
            }
            else
            {
                field[i][j].movCre(field[x][y]);
            }
        }
    }

    public void showThecreature(int i, int j,Canvas canvas) {
        field[i][j].showThecreature(canvas);
    }
}

class thePosition
{
    private Creature creature;
    private int i;
    private int j;
    private boolean empty;

    thePosition(int i,int j) {
        this.i = i;
        this.j = j;
        this.empty = true;
        creature = null;
    }

    //初始化
    public void getCre(Creature temp) {
        creature = temp;
        this.empty = false;
        temp.changeTheposition(i,j);
    }
    //战场移动
    public void movCre(thePosition temp) {
        //生物改变
        creature = temp.creature;
        creature.changeTheposition(i,j);
        empty = false;
        temp.creature = null;
        temp.empty = true;
    }
    //战场交换
    public void swapCre(thePosition temp) {
        Creature tempswap = temp.creature;
        temp.creature = creature;
        creature = tempswap;
        creature.changeTheposition(i,j);
        temp.creature.changeTheposition(temp.i,temp.j);
    }

    public boolean isEmpty() {
        return empty;
    }

    public void showThecreature(Canvas canvas) {
        if(empty != true) {
            creature.show_GUI(canvas);
        }
    }
}