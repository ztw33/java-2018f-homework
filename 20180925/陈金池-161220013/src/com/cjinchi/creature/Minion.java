package com.cjinchi.creature;

import java.util.ArrayList;
import java.util.List;

public class Minion extends Creature {
    private static List<Minion> minions = new ArrayList<>();
    static {
        for (int i = 0; i < 11; i++) {
            minions.add(null);
        }
    }

    public static int getTotalNum() {
        return minions.size();
    }

    private Minion() {
        super("喽啰");
    }

    public static Minion getInstance(int index) {
        if (index < 1 || index > getTotalNum()) {
            throw new RuntimeException("Invalid minion index.");
        } else {
            if (minions.get(index - 1) == null) {
                minions.set(index - 1, new Minion());
            }
            return minions.get(index - 1);
        }
    }
}
