package world.formations;

import world.creatures.Brothers;
import world.tools.*;

/* 长蛇阵：row*col = 7 * 1
 */

public class ChangShe extends Formation {
	
	public ChangShe() {		
		super(7, 1); // 以阵型图所占行列构建
		
		type = Types.CS;
		
		// 定义特殊位置
		formCenter = new Point(3, 0);
		formLeader = new Point(3, 0);
		
		// 实例化葫芦娃的位置
		creatureMap[0][0] = new Brothers(0);
		creatureMap[1][0] = new Brothers(1);
		creatureMap[2][0] = new Brothers(2);
		creatureMap[3][0] = new Brothers(3);
		creatureMap[4][0] = new Brothers(4);
		creatureMap[5][0] = new Brothers(5);
		creatureMap[6][0] = new Brothers(6);
	}}
