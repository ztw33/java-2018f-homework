package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.util.*;

/**
 *	 雁行阵：row*col = 5 * 5.
 *	
 *	 		0	1	2	3	4
 *	 
 *	0		O	O	O	O	&
 *	1		O	O	O	&	O
 *	2		O	O	&	O	O
 *	3		O	&	O	O	O
 *	4		&	O	O	O	O
 *	
 *	@author Mirror
 */
public class YanXing extends Formation<Monsters> {
	
	public YanXing() {		
		super(FormationType.YX, 5, 5, 2, 2); // 以阵型图所占行列构建
		// 妖怪的位置
		formMap.put(new Point(0, 4), new Monsters());
		formMap.put(new Point(1, 3), new Monsters());
		formMap.put(new Point(2, 2), new Scorpion()); // 蝎子精
		formMap.put(new Point(3, 1), new Monsters());
		formMap.put(new Point(4, 0), new Monsters());
	}
}
