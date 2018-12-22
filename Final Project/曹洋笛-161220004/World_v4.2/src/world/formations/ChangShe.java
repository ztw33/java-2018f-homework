package world.formations;

import world.creatures.*;
import world.util.*;

/**
 *	长蛇阵：row*col = 7 * 1.
 *	
 *	@author Mirror
 *
 *	@see Formation
 */
public final class ChangShe extends Formation {
	
	public ChangShe(GroupType ct) {	
		super(FormationType.CS, 8, 1, 3, 0); // 以阵型图所占行列等构建	
		if (ct == GroupType.Bro) {
			// 葫芦娃的位置
			formMap.put(new Point(0, 0), new Brothers(0));
			formMap.put(new Point(1, 0), new Brothers(1));
			formMap.put(new Point(2, 0), new Brothers(2));
			formMap.put(new Point(3, 0), new Brothers(3));
			formMap.put(new Point(4, 0), new Brothers(4));
			formMap.put(new Point(5, 0), new Brothers(5));
			formMap.put(new Point(6, 0), new Brothers(6));
			formMap.put(new Point(7, 0), new Elder()); // 老爷爷
		}
		else {
			// 妖怪的位置
			formMap.put(new Point(0, 0), new Monsters());
			formMap.put(new Point(1, 0), new Monsters());
			formMap.put(new Point(2, 0), new Monsters());
			formMap.put(new Point(3, 0), new Scorpion()); // 蝎子精
			formMap.put(new Point(7, 0), new Snake()); // 蛇精
			formMap.put(new Point(4, 0), new Monsters());
			formMap.put(new Point(5, 0), new Monsters());
			formMap.put(new Point(6, 0), new Monsters());
		}
	}
}
