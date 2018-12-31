package creature;

import battlefield.BattleField;

public class Monster implements Creature{
	@Override
	public char getSymbol(){
		return '*';
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
