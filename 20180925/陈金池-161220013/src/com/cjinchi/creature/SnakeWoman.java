package com.cjinchi.creature;

import com.cjinchi.util.Cheerful;

public class SnakeWoman extends Creature implements Cheerful {
    private static SnakeWoman snakeWoman;

    private SnakeWoman() {
        super("蛇精");
    }

    public static SnakeWoman getInstance() {
        if (snakeWoman == null) {
            snakeWoman = new SnakeWoman();
        }
        return snakeWoman;
    }

    public String cheer() {
        return "加油";
    }
}
