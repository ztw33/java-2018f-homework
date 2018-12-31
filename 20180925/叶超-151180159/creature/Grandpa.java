package creature;

import battlefield.*;

public enum Grandpa implements Creature,Cheer {
	grandpa();
	
	@Override
	public char getSymbol(){
		return 'Y';
	}
	@Override
	public void cheer(BattleField field,int x,int y){
		field.setCreature(x, y, this);
	}
	@Override
	public void move(BattleField field,int x,int y){
		field.setCreature(x, y, this);
	}
	@Override
	public void leave(BattleField field,int x,int y){
		field.clearCreature(x, y);
	}
}
