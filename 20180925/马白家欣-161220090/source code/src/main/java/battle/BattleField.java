package battle;

import being.*;
import gui.Controller;
import position.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import gui.Controller.*;

/**
 * @Description 战场，包含了战场方格二维数组battleFieldLatticeArray，主要职责是操纵battleFieldLatticeArray
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class BattleField <T extends CartoonCharacter> {
//    public static final int FIELD_SIZE = 15;
    public static final int ICON_SIZE = 40;
    public static final int BORDER_THICKNESS = 1;

    private List<BattleFieldLattice> battleFieldLatticeArray = new ArrayList<>();

    public BattleField() {
        for (int i = 0; i < Controller.FIELD_WIDTH * Controller.FIELD_HEIGHT; i++) {
            battleFieldLatticeArray.add(new BattleFieldLattice());
        }
    }

    public void setBattleFieldLattice(Map<Position, T> map, Position startPosition) {
        for (int row = -Controller.FIELD_HEIGHT; row < Controller.FIELD_HEIGHT; row++) {
            for (int col = -Controller.FIELD_WIDTH; col < Controller.FIELD_WIDTH; col++) {
//                CartoonCharacter cartoonCharacter = map.get(new Position(i, j));
//                if (cartoonCharacter != null) {
//                    assert i + startPosition.getRow() < FIELD_SIZE && j + startPosition.getCol() < FIELD_SIZE;
//                    this.battleFieldLatticeArray.set((i + startPosition.getRow()) * FIELD_SIZE + (j + startPosition.getCol())
//                            , new BattleFieldLattice(cartoonCharacter));
//                }
                if(map.containsKey(new Position(row, col)))
                {
                    CartoonCharacter cartoonCharacter = map.get(new Position(row, col));
//                    System.out.print((row + startPosition.getRow()) + " ");
//                    System.out.print((col + startPosition.getCol()) + " ");
//                    System.out.println((row + startPosition.getRow()) * Controller.FIELD_WIDTH + (col + startPosition.getCol()));
                    assert col + startPosition.getCol() < Controller.FIELD_WIDTH
                            && row + startPosition.getRow() < Controller.FIELD_HEIGHT;
//                    System.out.print("SIZE: " + this.battleFieldLatticeArray.size() + " ");
//                    System.out.print((j + startPosition.getRow()) + " ");
//                    System.out.print((i + startPosition.getCol()) + " ");
//                    System.out.println((j + startPosition.getRow()) * Controller.FIELD_WIDTH + (i + startPosition.getCol()));

                    this.battleFieldLatticeArray.set((row + startPosition.getRow()) * Controller.FIELD_WIDTH + (col + startPosition.getCol())
                            , new BattleFieldLattice(cartoonCharacter));
                }
            }
        }
    }

    public BattleFieldLattice getBattleFieldLattice(int i, int j) {

        return this.battleFieldLatticeArray.get(i * Controller.FIELD_WIDTH + j);
    }

    public List<BattleFieldLattice> getBattleFieldLatticeArray() {

        return this.battleFieldLatticeArray;
    }


    public void clearBattleField() {

        for (int i = 0; i < Controller.FIELD_WIDTH * Controller.FIELD_HEIGHT; i++) {
            battleFieldLatticeArray.set(i, new BattleFieldLattice());
        }
    }
}
