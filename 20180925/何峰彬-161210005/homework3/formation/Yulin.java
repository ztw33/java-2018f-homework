package homework3.formation;

import homework3.BattleField;
import homework3.creature.Monster;

public class Yulin implements Formation<Monster>{
    public Yulin(){
        leaderX = 10;
        leaderY = 9;
    }

    public void arrange(BattleField bf, Monster... monsters){
        bf.setCreatureAt(leaderY, leaderX, monsters[0]);
        int count = 1;
        bf.setCreatureAt(leaderY,leaderX+1,monsters[count ++]);
        bf.setCreatureAt(leaderY-1,leaderX+1,monsters[count ++]);
        for(int i = 0; i < 5; i ++){
            bf.setCreatureAt(leaderY+2-i,leaderX+2,monsters[count ++]);
        }
        for(int i = 0; i < 7; i ++){
            bf.setCreatureAt(leaderY+3-i,leaderX+3,monsters[count++]);
        }
        bf.setCreatureAt(leaderY,leaderX+4,monsters[count++]);
    }
    
    private int leaderX, leaderY;
}
