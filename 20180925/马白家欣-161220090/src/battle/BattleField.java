package com.homework3.battle;

import com.homework3.being.CartoonCharacter;
import com.homework3.coordinate.Position;

/**
 * @Description 战场，包含了战场方格二维数组battleFieldLatticeArray，主要职责是操纵battleFieldLatticeArray
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class BattleField {
    public static final int FIELD_SIZE = 15;
    public static final int ICON_SIZE = 40;
    public static final int BORDER_THICKNESS = 1;

    private BattleFieldLattice battleFieldLatticeArray[][] = new BattleFieldLattice[FIELD_SIZE][];

    public BattleField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            battleFieldLatticeArray[i] = new BattleFieldLattice[FIELD_SIZE];
        }

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; FIELD_SIZE > j; j++) {
                battleFieldLatticeArray[i][j] = new BattleFieldLattice();
            }
        }
    }

    public void setBattleFieldLattice(Position position, CartoonCharacter cartoonCharacter) {
        int row = position.getRow();
        int col = position.getCol();
        if (row >= 0 && row <= FIELD_SIZE - 1 && col >= 0 && col <= FIELD_SIZE - 1) {
            this.battleFieldLatticeArray[row][col] = new BattleFieldLattice(cartoonCharacter);
        }
    }

    public BattleFieldLattice getBattleFieldLattice(int i, int j) {
        return battleFieldLatticeArray[i][j];
    }

    public void clearBattleField(){
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++){
                battleFieldLatticeArray[i][j] = new BattleFieldLattice();
            }
        }
    }
}
