package Update3.Strategy;

import Update3.Strategy.Strategy;

public class Yanxing extends Strategy {
    final int row = 15;
    final int col = 10;
    private boolean method[][];

    public Yanxing() {
        method = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //摆放阵型
                if (j >= 2 && i == j + 2 && j <= 9)
                    method[i][j] = true;
                else
                    method[i][j] = false;
            }
        }
    }

    public boolean Arrange(int i, int j) {
        return method[i][j];
    }

    public int CoreX(boolean left_side) {
        if (left_side == true)
            return 7;
        else
            return 7;
    }

    public int CoreY(boolean left_side) {
        if (left_side == true)
            return 0;
        else
            return 9;
    }
}
