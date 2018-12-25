package Update2.Strategy;

public class Yuling extends Strategy {
    final int row = 15;
    final int col = 10;
    private boolean method[][];
    final int[] x_pos = {4, 5, 6, 6, 7, 7, 8, 8, 9, 10};
    final int[] y_pos = {5, 4, 3, 5, 2, 4, 3, 5, 4, 5};

    public Yuling() {
        method = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                method[i][j] = false;
            }
        }
        for (int i = 0; i < 10; i++) {
            method[x_pos[i]][y_pos[i]] = true;
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
