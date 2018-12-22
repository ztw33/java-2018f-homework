package com.cjinchi.battlefield;

import java.util.Collections;
import java.util.List;

import com.cjinchi.creature.Creature;
import com.cjinchi.util.Position;

public class BattleField {
    public static final int sideOneCreatureNum = 7;
    public static final int sideTwoCreatureNum = 12;

    private static final int sideLength = 17;
    private Position[][] field = new Position[sideLength][sideLength];

    public BattleField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Position();
            }
        }
    }

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
                    System.out.print(field[i / 2][j / 2]);
                }
            }
            System.out.println();
        }
    }

    public void setSideOneChangsheFormat(List<Creature> creatures) {
        if (creatures.size() != sideOneCreatureNum) {
            throw new RuntimeException("Invalid length while setSideOneChangsheFormat");
        }
        for (int i = sideOneCreatureNum; i > 0; i--) {
            field[i][sideLength / 2].set(creatures.get(sideOneCreatureNum - i));
        }
    }

    public void removeSideOneChangsheFormat() {
        setSideOneChangsheFormat(Collections.nCopies(sideOneCreatureNum, null));
    }

    public void setSideTwoFangyuanFormat(List<Creature> creatures) {
        if (creatures.size() != sideTwoCreatureNum) {
            throw new RuntimeException("Invalid length while setSideTwoFangyuanFormat");
        }
        int centralPosition = sideLength / 2;
        field[sideLength - 8][centralPosition].set(creatures.get(0));
        field[sideLength - 7][centralPosition - 1].set(creatures.get(1));
        field[sideLength - 7][centralPosition + 1].set(creatures.get(2));
        field[sideLength - 6][centralPosition - 2].set(creatures.get(3));
        field[sideLength - 6][centralPosition + 2].set(creatures.get(4));
        field[sideLength - 5][centralPosition - 3].set(creatures.get(5));
        field[sideLength - 5][centralPosition + 3].set(creatures.get(6));
        field[sideLength - 4][centralPosition - 2].set(creatures.get(7));
        field[sideLength - 4][centralPosition + 2].set(creatures.get(8));
        field[sideLength - 3][centralPosition - 1].set(creatures.get(9));
        field[sideLength - 3][centralPosition + 1].set(creatures.get(10));
        field[sideLength - 2][centralPosition].set(creatures.get(11));
    }

    public void removeSideTwoFangyuanFormat() {
        setSideTwoFangyuanFormat(Collections.nCopies(sideTwoCreatureNum, null));
    }

    public void setSideTwoFengshiFormat(List<Creature> creatures) {
        if (creatures.size() != sideTwoCreatureNum) {
            throw new RuntimeException("Invalid length while setSideTwoFengshiFormat");
        }
        int centralPosition = sideLength / 2;
        field[sideLength - 7][centralPosition].set(creatures.get(0));
        field[sideLength - 6][centralPosition - 1].set(creatures.get(1));
        field[sideLength - 6][centralPosition].set(creatures.get(2));
        field[sideLength - 6][centralPosition + 1].set(creatures.get(3));
        field[sideLength - 5][centralPosition - 2].set(creatures.get(4));
        field[sideLength - 5][centralPosition].set(creatures.get(5));
        field[sideLength - 5][centralPosition + 2].set(creatures.get(6));
        field[sideLength - 4][centralPosition - 3].set(creatures.get(7));
        field[sideLength - 4][centralPosition].set(creatures.get(8));
        field[sideLength - 4][centralPosition + 3].set(creatures.get(9));
        field[sideLength - 3][centralPosition].set(creatures.get(10));
        field[sideLength - 2][centralPosition].set(creatures.get(11));
    }

    public void removeSideTwoFengshiFormat() {
        setSideTwoFengshiFormat(Collections.nCopies(sideTwoCreatureNum, null));
    }

    public void setSideOneAudience(Creature creature) {
        field[0][sideLength - 1].set(creature);
    }

    public void removeSideOneAudience() {
        setSideOneAudience(null);
    }

    public void setSideTwoAudience(Creature creature) {
        field[sideLength - 1][sideLength - 1].set(creature);
    }

    public void removeSideTwoAudience() {
        setSideTwoAudience(null);
    }
}
