package com.cjinchi.creature;

public class Minion extends Creature {
    public static final int TOTAL_MINION_NUM = 11;
    private static Minion[] minions = new Minion[TOTAL_MINION_NUM];

    private Minion() {
        super("喽啰");
    }

    public static Minion getInstance(int index) {
        if (index < 1 || index > TOTAL_MINION_NUM) {
            throw new RuntimeException("Invalid minion index.");
        } else {
            if (minions[index - 1] == null) {
                minions[index - 1] = new Minion();
            }
            return minions[index - 1];
        }
    }
}
