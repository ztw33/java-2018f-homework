package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.util.*;

/**
 *	 鹤翼阵：row*col = 7 * 4.
 *	
 *	 		0	1	2	3
 *	 
 *	0		O	O	O	&
 *	1		O	O	&	O
 *	2		O	&	O	O
 *	3		&	O	O	O
 *	4		O	&	O	O
 *	5		O	O	&	O
 *	6		O	O	O	&
 *	
 *	@author Mirror
 */
public final class HeYi extends Formation<Monsters> {
	
	public HeYi() {		
		super(FormationType.HY, 7, 4, 3, 2); // 以阵型图所占行列构建
		// 妖怪的位置
		formMap.put(new Point(0, 3), new Monsters());
		formMap.put(new Point(1, 2), new Monsters());
		formMap.put(new Point(2, 1), new Monsters());
		formMap.put(new Point(3, 0), new Scorpion()); // 蝎子精
		formMap.put(new Point(4, 1), new Monsters());
		formMap.put(new Point(5, 2), new Monsters());
		formMap.put(new Point(6, 3), new Monsters());
	}
}
