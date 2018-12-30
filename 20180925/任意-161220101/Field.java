package renyi;

public class Field {
    Creature[][] field=new Creature[20][20];
    Field(Battle_Array d)
    {
        int number=1;
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                if(d.position[i][j]==1)
                {
                    field[i][j]=new Brothers(number,i,j);
                    number++;
                }
                else if(d.position[i][j]==2)
                    field[i][j]=new Grandpa(i,j);
                else if(d.position[i][j]==-1)
                    field[i][j]=new Orchin(i,j);
                else if(d.position[i][j]==-2)
                    field[i][j]=new Scorpion(i,j);
                else if(d.position[i][j]==-3)
                    field[i][j]=new Snake_essence(i,j);
                else
                    field[i][j]=new NullCreature(i,j);
            }
        }
    }
    public void show()
    {
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                System.out.print(this.field[i][j].name+" ");
            }
            System.out.print("\n");
        }
    }
}
