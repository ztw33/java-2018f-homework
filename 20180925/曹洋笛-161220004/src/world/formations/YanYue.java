package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.tools.*;

/* 偃月阵：row*col = 9 * 6
 * 
 *  		0	1	2	3	4	5
 *  
 * 0		O	O	O	O	O	&
 * 1		O	O	O	&	&	O
 * 2		O	O	&	&	O	O
 * 3		&	&	&	O	O	O
 * 4		&	&	&	O	O	O
 * 5		&	&	&	O	O	O
 * 6		O	O	&	&	O	O
 * 7		O	O	O	&	&	O
 * 8		O	O	O	O	O	&
 * 
 */

public class YanYue extends Formation {
	
	public YanYue() {		
		super(9, 6); // 以阵型图所占行列构建
		
		type = Types.YY;
		
		// 定义特殊位置
		formCenter = new Point(4, 2);
		formLeader = new Point(4, 1);
		
		// 实例化有妖怪的位置
		creatureMap[0][5] = new Monsters();
		creatureMap[1][3] = new Monsters();
		creatureMap[1][4] = new Monsters();
		creatureMap[2][2] = new Monsters();
		creatureMap[2][3] = new Monsters();
		creatureMap[3][0] = new Monsters();
		creatureMap[3][1] = new Monsters();
		creatureMap[3][2] = new Monsters();
		creatureMap[4][0] = new Monsters();
		creatureMap[4][1] = new Scorpion(); // 蝎子精
		creatureMap[4][2] = new Monsters();
		creatureMap[5][0] = new Monsters();
		creatureMap[5][1] = new Monsters();
		creatureMap[5][2] = new Monsters();
		creatureMap[6][2] = new Monsters();
		creatureMap[6][3] = new Monsters();
		creatureMap[7][3] = new Monsters();
		creatureMap[7][4] = new Monsters();
		creatureMap[8][5] = new Monsters();
	}
}
