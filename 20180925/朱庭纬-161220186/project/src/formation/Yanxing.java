package formation;

import java.util.ArrayList;

import creature.Creature;
import space.BattleField;

public class Yanxing<T extends Creature> implements Conjurable {

	@Override
	public boolean conjure(BattleField bf, ArrayList<? extends Creature> creatures, int startRow, int startColumn) {
		// TODO Auto-generated method stub
		int row = bf.getRow(), column = bf.getColumn();
		if ((startRow < 0) || (startRow > row - 1) || (startColumn < 0) || (startColumn > column - 1) 
				|| (startRow + creatures.size() > row)) {
			System.err.println("鹤翼阵布置失败");
			return false;
		} else {
			for (int i = 0; i < creatures.size(); i++) {
				bf.setCreatrue(creatures.get(i), startRow + i, startColumn + i);
			}
		}
		
		return true;
	}

}
