package world.formations;

import world.creatures.Brothers;
import world.util.*;

/**
 *	长蛇阵：row*col = 7 * 1.
 *	
 *	@author Mirror
 *
 *	@see Formation
 */
public class ChangShe extends Formation<Brothers> {
	
	public ChangShe() {		
		super(FormationType.CS, 7, 1, 3, 0); // 以阵型图所占行列等构建
		// 葫芦娃的位置
		formMap.put(new Point(0, 0), new Brothers(0));
		formMap.put(new Point(1, 0), new Brothers(1));
		formMap.put(new Point(2, 0), new Brothers(2));
		formMap.put(new Point(3, 0), new Brothers(3));
		formMap.put(new Point(4, 0), new Brothers(4));
		formMap.put(new Point(5, 0), new Brothers(5));
		formMap.put(new Point(6, 0), new Brothers(6));
	}
}
