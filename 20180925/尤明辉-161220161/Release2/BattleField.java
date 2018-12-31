
class BattleField<T extends Being> {
    private T[][] ground;
    private final int N;
    private IFactory<T> factory;

    BattleField(int n, IFactory<T> fact) {
        N = n;
        this.factory = fact;
        this.ground = factory.createMatrix(N);
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                ground[i][j] = factory.createOnes();
    }

    public void addBeing(T being, int x, int y) { ground[x][y] = being; }

    public void initBeing(int x, int y) {
        ground[x][y] = factory.createOnes();
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
