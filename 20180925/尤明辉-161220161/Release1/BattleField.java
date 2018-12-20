class BattleField {
    private Being[][] ground;
    private final int N;

    BattleField(int n) {
        N = n;
        ground = new Being[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                ground[i][j] = new Being();
    }

    public void addBeing(Being being, int x, int y) {
        ground[x][y] = being;
    }

    public void initBeing(int x, int y) {
        ground[x][y] = new Being();
    }

    public void showBattle() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j)
                System.out.print(ground[i][j].name + " ");
            System.out.println();
        }
        System.out.println();
    }

    public boolean isEmpty(int x, int y) {
        return ground[x][y].name == '*';
    }

    public int scale() {
        return N;
    }
}