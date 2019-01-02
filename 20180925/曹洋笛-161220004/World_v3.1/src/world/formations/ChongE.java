package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.util.*;

/**
 *	 冲轭阵：row*col = 6 * 2.
 *	
 *	 		0	1
 *	 
 *	0		O	&
 *	1		&	O
 *	2		O	&
 *	3		&	O
 *	4		O	&
 *	5		&	O
 *	
 *	@author Mirror
 */
public class ChongE extends Formation<Monsters> {
	
	public ChongE() {		
		super(FormationType.CE, 6, 2, 3, 0); // 以阵型图所占行列构建		
		// 妖怪的位置
		formMap.put(new Point(1, 0), new Monsters());
		formMap.put(new Point(3, 0), new Scorpion()); // 蝎子精
		formMap.put(new Point(5, 0), new Monsters());
		formMap.put(new Point(0, 1), new Monsters());
		formMap.put(new Point(2, 1), new Monsters());
		formMap.put(new Point(4, 1), new Monsters());
	}
}
