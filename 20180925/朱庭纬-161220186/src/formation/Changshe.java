package formation;

import creature.Creature;
import space.BattleField;

public class Changshe implements Formation {

	@Override
	public boolean conjure(BattleField bf, Creature[] creatures, int startRow, int startColumn) {
		// TODO Auto-generated method stub
		int row = bf.getRow(), column = bf.getColumn();
		if ((startRow < 0) || (startRow > row - 1) || (startColumn < 0) || (startColumn > column - 1) 
				|| (startRow + creatures.length > row) ) {
			System.err.println("长蛇阵布置失败");
			return false;
		} else {
			for (int i = 0; i < creatures.length; i++) {
				bf.setCreatrue(creatures[i], startRow + i, startColumn);
			}
		}
		return true;
	}
	
}
