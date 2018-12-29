package com.cjinchi.util;

import com.cjinchi.creature.Creature;

public class Position {
    private Creature element = null;

    public void set(Creature element) {
        this.element = element;
    }

    public Creature get() {
        return element;
    }

    public String toString() {
        if (element == null) {
            return "    ";
        } else if (element instanceof Cheerful) {
            Cheerful cheerer = (Cheerful) element;
            return cheerer.cheer();
        } else {
            return element.getName();
        }
    }
}
