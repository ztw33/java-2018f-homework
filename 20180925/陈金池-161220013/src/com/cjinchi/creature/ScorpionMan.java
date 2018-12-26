package com.cjinchi.creature;

public class ScorpionMan extends Creature {
    private static ScorpionMan scorpionMan;

    private ScorpionMan() {
        super("蝎精");
    }

    public static ScorpionMan getInstance() {
        if (scorpionMan == null) {
            scorpionMan = new ScorpionMan();
        }
        return scorpionMan;
    }
}
