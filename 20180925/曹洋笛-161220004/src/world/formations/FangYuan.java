package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.tools.*;

/* 方円阵：row*col = 5 * 5
 * 
 *  		0	1	2	3	4
 *  
 * 0		O	O	&	O	O
 * 1		O	&	O	&	O
 * 2		&	O	O	O	&
 * 3		O	&	O	&	O
 * 4		O	O	&	O	O
 * 
 */

public class FangYuan extends Formation {
	
	public FangYuan() {		
		super(5, 5); // 以阵型图所占行列构建
		
		type = Types.FY;
		
		// 定义特殊位置
		formCenter = new Point(2, 2);
		formLeader = new Point(2, 0);
		
		// 实例化有妖怪的位置
		creatureMap[0][2] = new Monsters();
		creatureMap[1][1] = new Monsters();
		creatureMap[1][3] = new Monsters();
		creatureMap[2][0] = new Scorpion(); // 蝎子精
		creatureMap[2][4] = new Monsters();
		creatureMap[3][1] = new Monsters();
		creatureMap[3][3] = new Monsters();
		creatureMap[4][2] = new Monsters();
	}
}
