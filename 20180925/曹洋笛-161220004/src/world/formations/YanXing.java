package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.tools.*;

/* 雁行阵：row*col = 5 * 5
 * 
 *  		0	1	2	3	4
 *  
 * 0		O	O	O	O	&
 * 1		O	O	O	&	O
 * 2		O	O	&	O	O
 * 3		O	&	O	O	O
 * 4		&	O	O	O	O
 * 
 */

public class YanXing extends Formation {
	
	public YanXing() {		
		super(5, 5); // 以阵型图所占行列构建
		
		type = Types.YX;
		
		// 定义特殊位置
		formCenter = new Point(2, 2);
		formLeader = new Point(2, 2);
		
		// 实例化有妖怪的位置
		creatureMap[0][4] = new Monsters();
		creatureMap[1][3] = new Monsters();
		creatureMap[2][2] = new Scorpion(); // 蝎子精
		creatureMap[3][1] = new Monsters();
		creatureMap[4][0] = new Monsters();
	}
}
