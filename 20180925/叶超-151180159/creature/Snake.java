package creature;
import battlefield.BattleField;

public class Snake extends Monster implements Cheer{
	
	public Snake(){
		
	}
	
	@Override
	public char getSymbol(){
		return 'S';
	}
	@Override
	public void cheer(BattleField field,int x,int y){
		field.setCreature(x, y, this);
	}
}
