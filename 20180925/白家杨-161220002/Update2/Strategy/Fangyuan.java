package Update2.Strategy;

import java.util.HashMap;
import java.util.Map;

public class Fangyuan extends Strategy {
    final int row = 15;
    final int col = 10;
    //private boolean method[][];
    private Map<Integer, Integer> mp1;
    private Map<Integer, Integer> mp2;

    public Fangyuan() {
        mp1=new HashMap<Integer, Integer>();
        mp2=new HashMap<Integer, Integer>();
        mp1.put(3, 4);
        mp1.put(4, 3);
        mp2.put(4, 5);
        mp1.put(5, 2);
        mp2.put(5, 6);
        mp1.put(6, 1);
        mp2.put(6, 7);
        mp1.put(7, 1);
        mp2.put(7, 7);
        mp1.put(8, 2);
        mp2.put(8, 6);
        mp1.put(9, 3);
        mp2.put(9, 5);
        mp1.put(10, 4);
    }

    public boolean Arrange(int i, int j) {
        if (mp1.containsKey(i) == true && mp1.get(i) == j)
            return true;
        else if(mp2.containsKey(i) == true && mp2.get(i) == j)
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
            return 9;
    }
}
