class procession{
    protected creatures[] soldiers;
    protected  creatures leader;
}
class brothers extends procession{
    brothers()
    {
        leader=new grandpa();
        soldiers=new brother[7];
        for(int i=0;i<7;i++)
            soldiers[i]=new brother(i);
    }
    private void initCalabashGround(battlefield field) {
        int X = field.scale();
        int Y = (X - 1) / 2;
        for (int i = 0; i < X; ++i)
            for (int j = 0; j < Y; ++j)
                field.init(i, j);
    }
    public void addLeader(battlefield field) {
        int X = field.scale();
        int Y = X / 2 - 1;
        if (field.isEmpty(X / 2, Y / 4))
            field.add(leader, X / 2, Y / 4);
        else
            field.add(leader, X / 2, Y / 4 - 1);
    }
    public void snakeArray(battlefield field) {
        int X = field.scale();
        int Y = X / 2 - 1;
        initCalabashGround(field);
        for (int i = 0; i < 7; ++i)
            field.add(soldiers[i], X / 2 - 3 + i, Y / 2);
    }
}
class monster extends procession{
    private int N;
    monster(int n)
    {
        N=n;
        leader=new snake();
        soldiers=new monsters[n];
        soldiers[0]=new monsters(1);
        for(int i=1;i<n;i++)
            soldiers[i]=new monsters(0);
    }
    private void initMonsterGround(battlefield field) {
        int X = field.scale();
        int Y = X / 2;
        for (int i = 0; i < X; ++i)
            for (int j = Y; j < X; ++j)
               field.init(i, j);
    }
    public void addLeader(battlefield field) {
        int X = field.scale();
        int Y = X / 2;
        int i = Y + 2;
        while (!field.isEmpty(Y, i) && (i < X)) {
            ++i;
        }
        if (i < X)
            field.add(leader, Y, i);
        else
            field.add(leader, Y - 1, i - 1);
    }
    public void birdArray(battlefield field) {
        int X = field.scale();
        int Y = X / 2 ;
        int m=3*X/4;
       // int n=3*Y/2;
        initMonsterGround(field);
        field.add(soldiers[0],X/2,X/2);
        for (int i = 0; i < N-1; ++i) {
            //if(i<=(N-1)/2)
                field.add(soldiers[i+1], X / 4 + i, 2*Y/3+i);
         //   else
            //    field.add(soldiers[i], X / 2 +1+i-3, Y -i+3);
        }
    }
    public void craneArray(battlefield field) {
        int X = field.scale();
        int Y = X / 2;
        initMonsterGround(field);
        field.add(soldiers[0], Y, Y);
        int tmp = 1;
        //System.out.println(N);
        while (tmp < N) {
            int delta = (tmp + 1) / 2;
            field.add(soldiers[tmp], Y - delta, Y + delta);
            if (tmp + 1 < N)
                field.add(soldiers[tmp + 1], Y + delta, Y + delta);
            tmp += 2;
        }
    }
    public void arrowArray(battlefield field) {
        int X = field.scale();
        int Y = X / 2;
        initMonsterGround(field);
        field.add(soldiers[0], Y, Y);
        int tmp = 1;
        //System.out.println(N);
        while (tmp < N) {
            int delta = (tmp + 2) / 3;
            field.add(soldiers[tmp], Y - delta, Y + delta);
            if (tmp + 1 < N)
                field.add(soldiers[tmp + 1], Y, Y + delta);
            if (tmp + 2 < N)
                field.add(soldiers[tmp + 2], Y + delta, Y + delta);
            tmp += 3;
        }
    }
}