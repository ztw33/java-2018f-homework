package creature;
import battlefield.*;

public interface Creature {
	public char getSymbol();
	public void move(BattleField field,int x,int y);
	public void leave(BattleField field,int x,int y);
}
