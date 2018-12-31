package environment;

import creature.*;

public class Battlefield {
    Creature[][] matrix;
    final int size;

    public Battlefield(int sz)
    {
        size = sz;
        matrix = new Creature[size][];
        for (int i = 0; i < size; ++i) {
            matrix[i] = new Creature[size];
        }
    }

    public void setCreature(Creature object) {
        int x = object.getX();
        int y = object.getY();

        matrix[x][y] = object;
    }
    public Creature getCreature(int x, int y) {
        return matrix[x][y];
    }
    public void clear(int x, int y) {
        matrix[x][y] = null;
    }

    public void print() {
        for (int i = size - 1; i >= 0; --i) {
            for (int j = 0; j < size; ++j) {
                if (matrix[j][i] != null) {
                    matrix[j][i].display();
                    System.out.print("  ");
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.print('\n');
        }
    }
}
