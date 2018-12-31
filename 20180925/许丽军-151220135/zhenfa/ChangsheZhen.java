package zhenfa;

import creature.Creature;
import space.BatterGround;

public class ChangsheZhen implements ZhenFa{
	private int startX, startY;
	
	public ChangsheZhen(int startX, int startY) {
		super();
		this.startX = startX;
		this.startY = startY;
	}

	@Override
	public void apply(BatterGround ground, Creature[] creatures) {
		for(int i=0;i<creatures.length;i++){
			creatures[i].moveTo(ground, startX+i, startY);
		}
	}

	@Override
	public void clear(BatterGround ground, Creature[] creatures) {
		for(int i=0;i<creatures.length;i++){
			creatures[i].leaveFrom(ground, startX+i, startY);
		}
	}
}
