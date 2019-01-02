import java.util.HashMap;
import java.util.Map;

public class Battlefield {
    static final int N = 15;
    Map<Integer, Individual> battleState;
    boolean[][] vacuumState;

    public Battlefield() {
        vacuumState = new boolean[N][N];
        battleState = new HashMap<Integer, Individual>();
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++)
                vacuumState[i][j] = true;
        }
    }

    public void clearBattlefield() {
        battleState = new HashMap<Integer, Individual>();
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++)
                vacuumState[i][j] = true;
        }
    }

    public void addIndividual(Individual newComer, Coordinate pos) {
        newComer.pos = pos;
        battleState.put(pos.hashLoc(), newComer);
        vacuumState[pos.coordinateX][pos.coordinateY] = false;
    }

    public void outPutBattlefield() {
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (vacuumState[i][j])
                    System.out.print('.');
                else {
                    Coordinate pos = new Coordinate(i, j);
                    System.out.print(battleState.get(pos.hashLoc()).symbol);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
