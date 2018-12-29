package homework3.formation;

import homework3.BattleField;
import homework3.creature.Monster;

public class Chonge implements Formation<Monster> {
    public Chonge(){
        leaderX = 10;
        leaderY = 9;
    }

    public void arrange(BattleField bf, Monster... monsters){
        bf.setCreatureAt(leaderY, leaderX, monsters[0]);
        int count = 1;
        for(int i = 1; i < 4; i ++){
            bf.setCreatureAt(leaderY-i,leaderX + i%2,monsters[count ++]);
        }
        for(int i  = 1; i < 3; i ++){
            bf.setCreatureAt(leaderY+i,leaderX + i%2,monsters[count ++]);
        }
    }

    private int leaderX, leaderY;
}
