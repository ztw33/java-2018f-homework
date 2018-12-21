package world.creatures;

import world.util.CreatureType;

/**
 *	从啦啦队转入战队的蛇精
 *	
 *	@author Mirror
 */
public final class Snake extends Creature {

	public Snake() {
		super();
		type = CreatureType.Snk;
		name = "蛇精";
		symbol = 'S';
	}
}
