package world.formations;

import world.creatures.Monsters;
import world.creatures.Scorpion;
import world.tools.*;

/* 冲轭阵：row*col = 6 * 2
 * 
 *  		0	1
 *  
 * 0		O	&
 * 1		&	O
 * 2		O	&
 * 3		&	O
 * 4		O	&
 * 5		&	O
 * 
 */

public class ChongE extends Formation {
	
	public ChongE() {		
		super(6, 2); // 以阵型图所占行列构建
		
		type = Types.CE;
		
		// 定义特殊位置
		formCenter = new Point(3, 0);
		formLeader = new Point(3, 0);
		
		// 实例化有妖怪的位置
		creatureMap[1][0] = new Monsters();
		creatureMap[3][0] = new Scorpion(); // 蝎子精
		creatureMap[5][0] = new Monsters();
		creatureMap[0][1] = new Monsters();
		creatureMap[2][1] = new Monsters();
		creatureMap[4][1] = new Monsters();
	}
}
