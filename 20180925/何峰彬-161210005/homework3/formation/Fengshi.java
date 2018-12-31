package homework3.formation;

import homework3.BattleField;
import homework3.creature.Monster;

public class Fengshi implements Formation<Monster> {
    public Fengshi(){
        leaderX = 10;
        leaderY = 9;
    }

    public void arrange(BattleField bf, Monster... monsters){
        bf.setCreatureAt(leaderY,leaderX, monsters[0]);
        int count = 1;
        for(int i = 1; i < 7; i ++){
            bf.setCreatureAt(leaderY,leaderX+i,monsters[count++]);
        }
        for(int i = 1; i < 4; i ++){
            bf.setCreatureAt(leaderY+i,leaderX+i,monsters[count++]);
            bf.setCreatureAt(leaderY-i,leaderX+i,monsters[count++]);
        }
    }

    private int leaderX, leaderY;
}
