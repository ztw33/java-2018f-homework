package Update2.Strategy;

import java.util.HashMap;
import java.util.Map;

public class Henggui extends Strategy {
    final int row = 15;
    final int col = 10;
    //private boolean method[][];
    private Map<Integer, Integer> mp1;
    //private Map<Integer, Integer> mp2;

    public Henggui() {
        mp1=new HashMap<Integer, Integer>();
        mp1.put(2, 5);
        mp1.put(3, 6);
        mp1.put(4, 5);
        mp1.put(5, 6);
        mp1.put(6, 5);
        mp1.put(7, 6);
        mp1.put(8, 5);
        mp1.put(9, 6);
        mp1.put(10, 5);
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
