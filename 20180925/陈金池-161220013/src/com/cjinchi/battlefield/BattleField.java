package com.cjinchi.battlefield;

import com.cjinchi.creature.Creature;
import com.cjinchi.util.Cheerful;

public class BattleField {

    public static final int sideOneCreatureNum = 7;
    public static final int sideTwoCreatureNum = 12;

    private static final int sideLength = 17;
    private Creature[][] field = new Creature[sideLength][sideLength];

    public void show() {
        for (int i = 0; i < sideLength * 2 + 1; i++) {
            for (int j = 0; j < sideLength * 2 + 1; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    System.out.print("-");
                } else if (i % 2 == 0 && j % 2 == 1) {
                    System.out.print("----");
                } else if (i % 2 == 1 && j % 2 == 0) {
                    System.out.print("|");
                } else if (i % 2 == 1 && j % 2 == 1) {
//                    System.out.print(field[i / 2][j / 2] == null ? "    " : field[i / 2][j / 2].getName());
                    if (field[i / 2][j / 2] == null) {
                        System.out.print("    ");
                    } else if (field[i / 2][j / 2] instanceof Cheerful) {
                        Cheerful cheerer = (Cheerful) field[i / 2][j / 2];
                        cheerer.cheer();
                    } else {
                        System.out.print(field[i / 2][j / 2].getName());
                    }
                }
            }
            System.out.println();
        }
    }

    public void setSideOneChangsheFormat(Creature[] creatures) {
        if (creatures.length != sideOneCreatureNum) {
            throw new RuntimeException("Invalid length while setSideOneChangsheFormat");
        }
        for (int i = sideOneCreatureNum; i > 0; i--) {
            field[i][sideLength / 2] = creatures[sideOneCreatureNum - i];
        }
    }

    public void removeSideOneChangsheFormat() {
        setSideOneChangsheFormat(new Creature[sideOneCreatureNum]);
    }

    public void setSideTwoFangyuanFormat(Creature[] creatures) {
        if (creatures.length != sideTwoCreatureNum) {
            throw new RuntimeException("Invalid length while setSideTwoFangyuanFormat");
        }
        int centralPosition = sideLength / 2;
        field[sideLength - 8][centralPosition] = creatures[0];
        field[sideLength - 7][centralPosition - 1] = creatures[1];
        field[sideLength - 7][centralPosition + 1] = creatures[2];
        field[sideLength - 6][centralPosition - 2] = creatures[3];
        field[sideLength - 6][centralPosition + 2] = creatures[4];
        field[sideLength - 5][centralPosition - 3] = creatures[5];
        field[sideLength - 5][centralPosition + 3] = creatures[6];
        field[sideLength - 4][centralPosition - 2] = creatures[7];
        field[sideLength - 4][centralPosition + 2] = creatures[8];
        field[sideLength - 3][centralPosition - 1] = creatures[9];
        field[sideLength - 3][centralPosition + 1] = creatures[10];
        field[sideLength - 2][centralPosition] = creatures[11];
    }

    public void removeSideTwoFangyuanFormat() {
        setSideTwoFangyuanFormat(new Creature[sideTwoCreatureNum]);
    }

    public void setSideTwoFengshiFormat(Creature[] creatures) {
        if (creatures.length != sideTwoCreatureNum) {
            throw new RuntimeException("Invalid length while setSideTwoFengshiFormat");
        }
        int centralPosition = sideLength / 2;
        field[sideLength - 7][centralPosition] = creatures[0];
        field[sideLength - 6][centralPosition - 1] = creatures[1];
        field[sideLength - 6][centralPosition] = creatures[2];
        field[sideLength - 6][centralPosition + 1] = creatures[3];
        field[sideLength - 5][centralPosition - 2] = creatures[4];
        field[sideLength - 5][centralPosition] = creatures[5];
        field[sideLength - 5][centralPosition + 2] = creatures[6];
        field[sideLength - 4][centralPosition - 3] = creatures[7];
        field[sideLength - 4][centralPosition] = creatures[8];
        field[sideLength - 4][centralPosition + 3] = creatures[9];
        field[sideLength - 3][centralPosition] = creatures[10];
        field[sideLength - 2][centralPosition] = creatures[11];
    }

    public void removeSideTwoFengshiFormat() {
        setSideTwoFengshiFormat(new Creature[sideTwoCreatureNum]);
    }

    public void setSideOneAudience(Creature creature) {
        field[0][sideLength - 1] = creature;
    }

    public void removeSideOneAudience() {
        setSideOneAudience(null);
    }

    public void setSideTwoAudience(Creature creature) {
        field[sideLength - 1][sideLength - 1] = creature;
    }

    public void removeSideTwoAudience() {
        setSideTwoAudience(null);
    }
}
