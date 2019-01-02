public class Ground {
    private Unit[][] space;
    private int bound;
    public Ground(int N) {
        bound = N;
        space = new Unit[N][N];
        for(int i = 0; i < bound; i++) {
            for(int j = 0; j < bound; j++) {
                space[i][j] = new Unit();
            }
        }
    }
    public boolean isEmpty(int X, int Y) {
        if(X >= 0 && Y >=0 && X < bound && Y < bound) {
            return space[X][Y].isEmpty();
        }
        else return false;
    }
    public boolean testBound(int X, int Y) {
        if(X >= 0 && Y >=0 && X < bound && Y < bound)
            return true;
        else return false;
    }
    public void gotoUnit(int X, int Y, Creature creature) {
        space[X][Y].Come(creature);
    }
    public void leaveUnit(int X, int Y) {
        if(testBound(X,Y))
            space[X][Y].Leave();
    }
    public int showBound() {
        return bound;
    }
    public void showCreature(int X, int Y) {
        if(!isEmpty(X,Y))
            space[X][Y].showCreature();
    }
}
