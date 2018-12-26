package Update2.Strategy;

import java.util.HashMap;
import java.util.Map;

public class Heyi extends Strategy {
    final int row = 15;
    final int col = 10;
    private boolean method[][];
    private Map<Integer, Integer> mp1;
    public Heyi() {
        mp1=new HashMap<Integer, Integer>();
        mp1.put(7, 1);
        mp1.put(6, 2);
        mp1.put(8, 2);
        mp1.put(5, 3);
        mp1.put(9, 3);
        mp1.put(4, 4);
        mp1.put(10, 4);
        mp1.put(3, 5);
        mp1.put(11, 5);
        mp1.put(2, 6);
        mp1.put(12, 6);
    }

    public boolean Arrange(int i, int j) {
        if (mp1.containsKey(i) == true && mp1.get(i) == j)
            return true;
        else
            return false;
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
