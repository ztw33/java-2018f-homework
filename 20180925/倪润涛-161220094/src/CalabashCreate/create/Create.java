package CalabashCreate.create;

import CalabashCreate.beings.*;

public class Create<T extends Factory>{
    public T [][]field;
    private InterFactory<T> fact;
    /*Create(InterFactory<T> f)
    {
        this.fact= f;
        this.field = fact.createMatrix(15);
        for (int i = 0; i < 15; ++i)
            for (int j = 0; j < 15; ++j)
                field[i][j] = fact.createO();
    }*/

    public Calabash []calabashCreate()
    {
        int []Rank = {0,3,2,5,1,6,4};
        Calabash []brothers = new Calabash[7];
        for(int i=0;i<7;i++) {
            brothers[i] = new Calabash(Rank[i]);
        }
        Sort(brothers);
        return brothers;
    }

    private void Swap(Calabash[]brothers, int src, int dest)
    {
        Calabash temp = brothers[src];
        brothers[src] = brothers[dest];
        brothers[dest] = temp;
    }
    private void Sort(Calabash []brothers)
    {
        for(int i=0;i<brothers.length;i++)
        {
            for(int j=brothers.length-1;j>=1;j--)
            {
                if(brothers[j].rank < brothers[j-1].rank) {
                    Swap(brothers,j,j-1);
                }
            }
        }
    }

    public Grandpa grandpaCreate()
    {
        Grandpa grandpa = new Grandpa();
        return grandpa;
    }

    public Snake snakeCreate()
    {
        Snake snake = new Snake();
        return snake;
    }

    public Goblin goblinScorpoinCreate()
    {
        Goblin goblin = new Goblin(0);
        return goblin;
    }
    public Goblin goblinCreate()
    {
        Goblin goblin = new Goblin(1);
        return goblin;
    }
}
