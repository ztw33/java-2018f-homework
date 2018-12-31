package bjy.battle.Creature;

import bjy.battle.BattleField;
import bjy.battle.Strategy.Strategy;

import java.lang.*;

enum MONSTERS {
    UGLY("小喽啰"), BOSS("大蛇精");
    private String name;

    private MONSTERS(String a) {
        this.name = a;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String a) {
        this.name = a;
    }
}

public class Evil extends Creature {
    private MONSTERS man;
    final int row = 15;
    final int col = 10;
    final int base_col = 10;

    public Evil() {
        man = MONSTERS.BOSS;
    }

    public Evil(MONSTERS p) {
        switch (p) {
            case UGLY:
                man = MONSTERS.UGLY;
                break;
            case BOSS:
                man = MONSTERS.BOSS;
                break;
        }
    }

    @Override
    public void Show() {
        System.out.print(man.getName());
    }

    public void UseStrategy(Strategy str, BattleField bat) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (str.Arrange(i, j)) {
                    bat.SetCreature(i, base_col + j, new Evil(MONSTERS.UGLY));
                } else
                    bat.SetCreature(i, base_col + j, new Creature());
            }
        }
        //给BOSS安排位置
        int x_pos = str.CoreX(false);
        int y_pos = str.CoreY(false);
        bat.SetCreature(x_pos,y_pos+base_col, new Evil(MONSTERS.BOSS));
    }
}
