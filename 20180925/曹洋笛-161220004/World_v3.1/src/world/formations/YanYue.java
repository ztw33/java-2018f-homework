package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.util.*;

/**
 *	 偃月阵：row*col = 9 * 6.
 *	
 *	 		0	1	2	3	4	5
 *	 
 *	0		O	O	O	O	O	&
 *	1		O	O	O	&	&	O
 *	2		O	O	&	&	O	O
 *	3		&	&	&	O	O	O
 *	4		&	&	&	O	O	O
 *	5		&	&	&	O	O	O
 *	6		O	O	&	&	O	O
 *	7		O	O	O	&	&	O
 *	8		O	O	O	O	O	&
 *	
 *	@author Mirror
 */
public class YanYue extends Formation<Monsters> {
	
	public YanYue() {		
		super(FormationType.YY, 9, 6, 4, 2); // 以阵型图所占行列构建
		// 妖怪的位置
		formMap.put(new Point(0, 5), new Monsters());
		formMap.put(new Point(1, 3), new Monsters());
		formMap.put(new Point(1, 4), new Monsters());
		formMap.put(new Point(2, 2), new Monsters());
		formMap.put(new Point(2, 3), new Monsters());
		formMap.put(new Point(3, 0), new Monsters());
		formMap.put(new Point(3, 1), new Monsters());
		formMap.put(new Point(3, 2), new Monsters());		
		formMap.put(new Point(4, 0), new Monsters());
		formMap.put(new Point(4, 1), new Scorpion()); // 蝎子精
		formMap.put(new Point(4, 2), new Monsters());
		formMap.put(new Point(5, 0), new Monsters());
		formMap.put(new Point(5, 1), new Monsters());
		formMap.put(new Point(5, 2), new Monsters());
		formMap.put(new Point(6, 2), new Monsters());
		formMap.put(new Point(6, 3), new Monsters());
		formMap.put(new Point(7, 3), new Monsters());
		formMap.put(new Point(7, 4), new Monsters());
		formMap.put(new Point(8, 5), new Monsters());
	}
}
