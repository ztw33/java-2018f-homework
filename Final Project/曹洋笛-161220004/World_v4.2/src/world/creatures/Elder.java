package world.creatures;

import world.util.CreatureType;

/**
 *	从啦啦队转入战队的老爷爷
 *	
 *	@author Mirror
 */
public final class Elder extends Creature {

	public Elder() {
		super();
		type = CreatureType.Eld;
		name = "老爷爷";
		symbol = 'Y';
	}
}
