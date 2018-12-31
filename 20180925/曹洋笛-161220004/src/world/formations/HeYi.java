package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.tools.*;

/* 鹤翼阵：row*col = 7 * 4
 * 
 *  		0	1	2	3
 *  
 * 0		O	O	O	&
 * 1		O	O	&	O
 * 2		O	&	O	O
 * 3		&	O	O	O
 * 4		O	&	O	O
 * 5		O	O	&	O
 * 6		O	O	O	&
 * 
 */

public final class HeYi extends Formation {
	
	public HeYi() {		
		super(7, 4); // 以阵型图所占行列构建
		
		type = Types.HY;
		
		// 定义特殊位置
		formCenter = new Point(3, 2);
		formLeader = new Point(3, 0);
		
		// 实例化有妖怪的位置
		creatureMap[0][3] = new Monsters();
		creatureMap[1][2] = new Monsters();
		creatureMap[2][1] = new Monsters();
		creatureMap[3][0] = new Scorpion(); // 蝎子精
		creatureMap[4][1] = new Monsters();
		creatureMap[5][2] = new Monsters();
		creatureMap[6][3] = new Monsters();
	}
}
