package zhen;

import battlefield.BattleField;
import creature.Creature;

public class HeYi extends Zhen {
	public HeYi(int x,int y){
		super(x,y);
	}
	@Override
	public void start(BattleField field, Creature[] creatures){
		int i=0;
		for(;i<(creatures.length)/2+1;i++){
			creatures[i].move(field, x+i, y+i);
		}
		for(int j=0;j+i<creatures.length;j++){
			creatures[j+i].move(field, x-1-j, y+1+j);
		}
	}
	@Override
	public void runaway(BattleField field, Creature[] creatures){
		for(int i=0;i<creatures.length;i++){
			creatures[i].leave(field, x+i, y+i);
		}
	}
}
