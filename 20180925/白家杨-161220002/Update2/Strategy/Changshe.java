package Update2.Strategy;

public class Changshe extends Strategy {
    final int row = 15;
    final int col = 10;
    private boolean method[][];

    public Changshe() {
        method = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //摆放阵型
                if (j == 5 && i > 2 && i < 10)
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
