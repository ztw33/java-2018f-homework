package zhen;
import creature.*;
import battlefield.*;

public abstract class Zhen {
	int x,y;
	Zhen(int x,int y){
		this.x=x;
		this.y=y;
	}
	public abstract void start(BattleField field, Creature[] creatures);
	public abstract void runaway(BattleField field, Creature[] creatures);
}
