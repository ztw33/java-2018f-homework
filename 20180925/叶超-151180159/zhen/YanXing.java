package zhen;

import battlefield.BattleField;
import creature.Creature;

public class YanXing extends Zhen {
	public YanXing(int x,int y){
		super(x,y);
	}
	@Override
	public void start(BattleField field, Creature[] creatures){
		for(int i=0;i<creatures.length;i++){
			creatures[i].move(field, x+i, y+i);
		}
	}
	@Override
	public void runaway(BattleField field, Creature[] creatures){
		for(int i=0;i<creatures.length;i++){
			creatures[i].leave(field, x+i, y+i);
		}
	}
}
