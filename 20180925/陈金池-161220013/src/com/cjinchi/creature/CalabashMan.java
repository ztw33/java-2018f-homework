package com.cjinchi.creature;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.cjinchi.util.Color;

public class CalabashMan extends Creature {
    public static final int TOTAL_NUM = 7;
    private static CalabashMan[] brothers = new CalabashMan[TOTAL_NUM];

    private int seq;
    private Color color;

    private CalabashMan(String name, Color color, int seq) {
        super(name);
        this.color = color;
        this.seq = seq;
    }

    public static CalabashMan getInstance(int index) {
        if (index < 1 || index > TOTAL_NUM) {
            throw new RuntimeException("Invalid CalabashMan index.");
        } else {
            if (brothers[index - 1] == null) {
                switch (index) {
                case 1:
                    brothers[index - 1] = new CalabashMan("大娃", Color.RED, 1);
                    break;
                case 2:
                    brothers[index - 1] = new CalabashMan("二娃", Color.ORANGE, 2);
                    break;
                case 3:
                    brothers[index - 1] = new CalabashMan("三娃", Color.YELLOW, 3);
                    break;
                case 4:
                    brothers[index - 1] = new CalabashMan("四娃", Color.GREEN, 4);
                    break;
                case 5:
                    brothers[index - 1] = new CalabashMan("五娃", Color.CYAN, 5);
                    break;
                case 6:
                    brothers[index - 1] = new CalabashMan("六娃", Color.BLUE, 6);
                    break;
                case 7:
                    brothers[index - 1] = new CalabashMan("七娃", Color.VIOLET, 7);
                    break;
                }
            }
            return brothers[index - 1];
        }
    }

    public static CalabashMan[] getRandomCalabashMans() {
        CalabashMan[] calabashMans = new CalabashMan[TOTAL_NUM];
        for (int i = 0; i < TOTAL_NUM; i++) {
            calabashMans[i] = getInstance(i + 1);
        }

        List<CalabashMan> calabashManList = Arrays.asList(calabashMans);
        Collections.shuffle(calabashManList);
        return calabashManList.toArray(new CalabashMan[0]);
    }

    public static void sortBySequence(CalabashMan[] brothers) {
        for (int i = 0; i < brothers.length - 1; i++) {
            for (int j = 0; j < brothers.length - i - 1; j++) {
                if (brothers[j].getSeq() > brothers[j + 1].getSeq()) {
                    // exchange
                    CalabashMan temp = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = temp;
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
