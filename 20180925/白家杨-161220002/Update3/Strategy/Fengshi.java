package Update3.Strategy;

import Update3.Strategy.Strategy;

public class Fengshi extends Strategy {
    final int row = 15;
    final int col = 10;
    private boolean method[][];

    public Fengshi() {
        method = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //摆放阵型
                if (i == 8 && j > 0 && j < 7)
                    method[i][j] = true;
                else
                    method[i][j] = false;
            }
        }
        method[5][4]=true;
        method[6][3]=true;
        method[7][2]=true;
        method[9][2]=true;
        method[10][3]=true;
        method[11][4]=true;
    }

    public boolean Arrange(int i, int j) {
        return method[i][j];
    }

    public int CoreX(boolean left_side) {
        if (left_side == true)
            return 8;
        else
            return 8;
    }

    public int CoreY(boolean left_side) {
        if (left_side == true)
            return 3;
        else
            return 7;
    }
}
