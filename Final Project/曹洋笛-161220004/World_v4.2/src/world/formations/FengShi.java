package world.formations;

import world.creatures.*;
import world.util.*;

/**
 *	 锋矢阵：row*col = 7 * 6 / 5 * 4. <br>
 *	
 *	 		0	1	2	3	4	5		0	1	2	3 <br>
 *	 
 *	0		O	O	&	O	O	O		O	#	O	O <br>
 *	1		O	&	O	O	O	O		O	O	#	O <br>
 *	2		&	O	O	O	O	O		#	#	#	# <br>
 *	3		&	&	&	&	&	&		O	O	#	O <br>
 *	4		&	O	O	O	O	O		O	#	O	O <br>
 *	5		O	&	O	O	O	O <br>
 *	6		O	O	&	O	O	O <br>
 *	
 *	@author Mirror
 */
public final class FengShi extends Formation {
	
	public FengShi(GroupType ct) {		
		super(FormationType.FS); // 构建
		if (ct == GroupType.Bro) {
			init(5, 4, 2, 2); // 阵型图所占行列
			// 葫芦娃的位置
			formMap.put(new Point(2, 0), new Elder()); // 老爷爷
			formMap.put(new Point(0, 1), new Brothers(0));
			formMap.put(new Point(2, 1), new Brothers(1));
			formMap.put(new Point(4, 1), new Brothers(2));
			formMap.put(new Point(1, 2), new Brothers(3));
			formMap.put(new Point(2, 2), new Brothers(4));
			formMap.put(new Point(3, 2), new Brothers(5));
			formMap.put(new Point(2, 3), new Brothers(6));
		}
		else {
			init(7, 6, 3, 2); // 阵型图所占行列
			// 妖怪的位置
			formMap.put(new Point(0, 2), new Monsters());
			formMap.put(new Point(1, 1), new Monsters());
			formMap.put(new Point(2, 0), new Monsters());
			formMap.put(new Point(3, 0), new Scorpion()); // 蝎子精
			formMap.put(new Point(3, 1), new Monsters());
			formMap.put(new Point(3, 2), new Snake()); // 蛇精
			formMap.put(new Point(3, 3), new Monsters());
			formMap.put(new Point(3, 4), new Monsters());
			formMap.put(new Point(3, 5), new Monsters());
			formMap.put(new Point(4, 0), new Monsters());
			formMap.put(new Point(5, 1), new Monsters());
			formMap.put(new Point(6, 2), new Monsters());
		}
	}
}
