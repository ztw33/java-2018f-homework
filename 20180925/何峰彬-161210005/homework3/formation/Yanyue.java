package homework3.formation;

import homework3.BattleField;
import homework3.creature.Monster;

public class Yanyue implements Formation<Monster> {
    public Yanyue(){
        leaderX = 10;
        leaderY = 9;
    }

    public void arrange(BattleField bf, Monster... monsters){
        bf.setCreatureAt(leaderY, leaderX, monsters[0]);
        int count = 1;
        for(int i = 1; i < 5; i ++){
            bf.setCreatureAt(leaderY+i,leaderX+i,monsters[count++]);
            bf.setCreatureAt(leaderY+i,leaderX+i+1,monsters[count++]);
            bf.setCreatureAt(leaderY-i,leaderX+i,monsters[count++]);
            bf.setCreatureAt(leaderY-i,leaderX+i+1,monsters[count++]);
        }
        bf.setCreatureAt(leaderY+1,leaderX,monsters[count++]);
        bf.setCreatureAt(leaderY-1,leaderX,monsters[count++]);
        bf.setCreatureAt(leaderY,leaderX+1,monsters[count++]);
        bf.setCreatureAt(leaderY,leaderX+2,monsters[count++]);
    }

    private int leaderX, leaderY;
}
