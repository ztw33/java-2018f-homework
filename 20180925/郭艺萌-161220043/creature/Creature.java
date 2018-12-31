package creature;

import map.*;

public class Creature {

	protected String name;
	//生物走到指定位置
	public void move(Position pos) {
		pos.setCreature(this);
	}
}
