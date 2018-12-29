package com.cjinchi.creature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cjinchi.util.Color;

public class CalabashMan extends Creature {
    private static List<CalabashMan> brothers = new ArrayList<>();
    static {
        for (int i = 0; i < 7; i++) {
            brothers.add(null);
        }
    }

    private int seq;
    private Color color;

    private CalabashMan(String name, Color color, int seq) {
        super(name);
        this.color = color;
        this.seq = seq;
    }

    public static int getTotalNum() {
        return brothers.size();
    }

    public static CalabashMan getInstance(int index) {
        if (index < 1 || index > getTotalNum()) {
            throw new RuntimeException("Invalid CalabashMan index.");
        } else {
            if (brothers.get(index - 1) == null) {
                switch (index) {
                case 1:
                    brothers.set(index - 1, new CalabashMan("大娃", Color.RED, 1));
                    break;
                case 2:
                    brothers.set(index - 1, new CalabashMan("二娃", Color.ORANGE, 2));
                    break;
                case 3:
                    brothers.set(index - 1, new CalabashMan("三娃", Color.YELLOW, 3));
                    break;
                case 4:
                    brothers.set(index - 1, new CalabashMan("四娃", Color.GREEN, 4));
                    break;
                case 5:
                    brothers.set(index - 1, new CalabashMan("五娃", Color.CYAN, 5));
                    break;
                case 6:
                    brothers.set(index - 1, new CalabashMan("六娃", Color.BLUE, 6));
                    break;
                case 7:
                    brothers.set(index - 1, new CalabashMan("七娃", Color.VIOLET, 7));
                    break;
                }
            }
            return brothers.get(index - 1);
        }
    }

    public static List<CalabashMan> getRandomCalabashMans() {
        List<CalabashMan> calabashMans = new ArrayList<>();
        for (int i = 1; i <= getTotalNum(); i++) {
            calabashMans.add(getInstance(i));
        }
        Collections.shuffle(calabashMans);
        return calabashMans;
    }

    public static void sortBySequence(List<CalabashMan> mans) {
        for (int i = 0; i < mans.size() - 1; i++) {
            for (int j = 0; j < mans.size() - i - 1; j++) {
                if (mans.get(j).getSeq() > mans.get(j + 1).getSeq()) {
                    // exchange
                    Collections.swap(mans, j, j + 1);
                }
            }
        }
    }

    public int getSeq() {
        return seq;
    }

    public Color getColor() {
        return color;
    }
}
