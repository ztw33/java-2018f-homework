package zhen;

import battlefield.BattleField;
import creature.Creature;

public class ChangShe extends Zhen{
	public ChangShe(int x,int y){
		super(x,y);
	}
	@Override
	public void start(BattleField field, Creature[] creatures){
		for(int i=0;i<creatures.length;i++){
			creatures[i].move(field, x+i, y);
		}
	}
	@Override
	public void runaway(BattleField field, Creature[] creatures){
		for(int i=0;i<creatures.length;i++){
			creatures[i].leave(field, x+i, y);
		}
	}
}
