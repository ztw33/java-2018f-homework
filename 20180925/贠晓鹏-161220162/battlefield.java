class battlefield{
    private creatures[][] field;
    private  int N;

    battlefield(int n)
    {
        N=n;
        field=new creatures[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                field[i][j]=new creatures();
    }
    public void init(int x,int y){
        field[x][y]=new creatures();
    }
    public void add(creatures sb,int x,int y)
    {
        field[x][y]=sb;
    }
    public void showBattle() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j)
                System.out.print(field[i][j].name + " ");
            System.out.println();
        }
        System.out.println();
    }
    public boolean isEmpty(int x, int y) {
        return field[x][y].name.equals("*");
    }
    public int scale() {
        return N;
    }
}