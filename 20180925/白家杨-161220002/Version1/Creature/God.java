package bjy.battle.Creature;

import bjy.battle.BattleField;
import bjy.battle.Strategy.Strategy;

import java.lang.*;

enum PERSON {
    HERO("葫芦娃"), GRANDPA(" 爷爷 ");
    private String name;

    private PERSON(String a) {
        this.name = a;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String a) {
        this.name = a;
    }
}

public class God extends Creature {
    private PERSON man;
    final int row = 15;
    final int col = 10;

    public God() {
        man = PERSON.GRANDPA;
    }

    public God(PERSON p) {
        switch (p) {
            case HERO:
                man = PERSON.HERO;
                break;
            case GRANDPA:
                man = PERSON.GRANDPA;
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
                    bat.SetCreature(i, j, new God(PERSON.HERO));
                } else
                    bat.SetCreature(i, j, new Creature());
            }
        }
        //给爷爷安排位置
        int x_pos = str.CoreX(true);
        int y_pos = str.CoreY(true);
        bat.SetCreature(x_pos,y_pos, new God(PERSON.GRANDPA));
    }
}
