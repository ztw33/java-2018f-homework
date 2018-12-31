package Update3.Strategy;

import Update3.Strategy.Strategy;

public class Yanyue extends Strategy {
    final int row = 15;
    final int col = 10;
    private boolean method[][];

    public Yanyue() {
        method = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //摆放阵型
                if (i >= 6 && i <= 8 && j <= 4 && j >=2)
                    method[i][j] = true;
                else
                    method[i][j] = false;
            }
        }
        method[3][6]=true;
        method[4][4]=true;
        method[4][5]=true;
        method[5][3]=true;
        method[5][4]=true;
        method[11][6]=true;
        method[10][4]=true;
        method[10][5]=true;
        method[9][3]=true;
        method[9][4]=true;
    }

    public boolean Arrange(int i, int j) {
        return method[i][j];
    }

    public int CoreX(boolean left_side) {
        if (left_side == true)
            return 6;
        else
            return 6;
    }

    public int CoreY(boolean left_side) {
        if (left_side == true)
            return 3;
        else
            return 7;
    }
}
