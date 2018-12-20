package world.formations;

import world.creatures.*;
import world.util.*;

/**
 *	 方円阵：row*col = 5 * 5. <br>
 *	
 *	 		0	1	2	3	4		0	1	2	3	4 <br>
 *	 
 *	0		O	O	&	O	O		O	O	#	O	O <br>
 *	1		O	&	O	&	O		O	#	O	#	O <br>
 *	2		&	O	O	O	&		#	O	O	O	# <br>
 *	3		O	&	O	&	O		O	#	O	#	O <br>
 *	4		O	O	&	O	O		O	O	#	O	O <br>
 *	
 *	@author Mirror
 */
public final class FangYuan extends Formation {
	
	public FangYuan(GroupType ct) {		
		super(FormationType.FY, 5, 5, 2, 2); // 以阵型图所占行列构建
		if (ct == GroupType.Bro) {
			// 葫芦娃的位置
			formMap.put(new Point(0, 2), new Brothers(0));
			formMap.put(new Point(1, 1), new Brothers(1));
			formMap.put(new Point(1, 3), new Brothers(2));
			formMap.put(new Point(2, 0), new Elder()); // 老爷爷
			formMap.put(new Point(2, 4), new Brothers(3));
			formMap.put(new Point(3, 1), new Brothers(4));
			formMap.put(new Point(3, 3), new Brothers(5));
			formMap.put(new Point(4, 2), new Brothers(6));
		}
		else {
			// 妖怪的位置
			formMap.put(new Point(0, 2), new Monsters());
			formMap.put(new Point(1, 1), new Monsters());
			formMap.put(new Point(1, 3), new Monsters());
			formMap.put(new Point(2, 0), new Scorpion()); // 蝎子精
			formMap.put(new Point(2, 4), new Snake()); // 蛇精
			formMap.put(new Point(3, 1), new Monsters());
			formMap.put(new Point(3, 3), new Monsters());
			formMap.put(new Point(4, 2), new Monsters());
		}
	}
}
