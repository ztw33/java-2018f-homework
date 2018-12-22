package world.creatures;

import world.util.CreatureType;

/**
 *	啦啦队的蛇精
 *	
 *	@author Mirror
 */
public final class Snake extends Mascot {

	public Snake() {
		super();
		type = CreatureType.Snk;
		name = "蛇精";
		symbol = 'S';
	}
}
