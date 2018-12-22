package com.cjinchi.creature;

import com.cjinchi.util.Cheerful;

public class GrandFather extends Creature implements Cheerful {
    private static GrandFather grandFather;

    private GrandFather() {
        super("爷爷");
    }

    public static GrandFather getInstance() {
        if (grandFather == null) {
            grandFather = new GrandFather();
        }
        return grandFather;
    }

    public String cheer() {
        return "加油";
    }
}
