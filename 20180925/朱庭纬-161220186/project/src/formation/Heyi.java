package formation;

import java.util.ArrayList;

import creature.Bad;
import creature.Creature;
import creature.Good;
import space.BattleField;

public class Heyi<T extends Creature> implements Conjurable {

	@Override
	public boolean conjure(BattleField bf, ArrayList<? extends Creature> creatures, int startRow, int startColumn) {
		// TODO Auto-generated method stub
		int row = bf.getRow(), column = bf.getColumn();
		int size = creatures.size();
		if ((startRow < 0) || (startRow > row - 1) || (startColumn < 0) || (startColumn > column - 1) 
				|| (startRow + size > row)) {
			System.err.println("鹤翼阵布置失败");
			return false;
		}
		if(!creatures.isEmpty() && creatures.get(0) instanceof Good) {
			if (startColumn - Math.ceil(size/2.0) < 0) {
				System.err.println("鹤翼阵布置失败");
				return false;
			} else {
				int indexRow = startRow, indexColumn = startColumn;
				int i;
				for (i = 0; i < Math.ceil(size/2.0); i++) {
					bf.setCreatrue(creatures.get(i), indexRow, indexColumn);
					indexRow++;
					indexColumn--;
				}
				if (size % 2 == 1) {
					indexColumn += 2;
				} else {
					indexColumn++;
				}
				for (; i < size; i++) {
					bf.setCreatrue(creatures.get(i), indexRow, indexColumn);
					indexRow++;
					indexColumn++;
				}
			}
		} else if(!creatures.isEmpty() && creatures.get(0) instanceof Bad) {
			if (startColumn + Math.ceil(size/2.0) > column) {
				System.err.println("鹤翼阵布置失败");
				return false;
			} else {
				int indexRow = startRow, indexColumn = startColumn;
				int i;
				for (i = 0; i < Math.ceil(size/2.0); i++) {
					bf.setCreatrue(creatures.get(i), indexRow, indexColumn);
					indexRow++;
					indexColumn++;
				}
				if (size % 2 == 1) {
					indexColumn -= 2;
				} else {
					indexColumn--;
				}			
				for (; i < size; i++) {
					bf.setCreatrue(creatures.get(i), indexRow, indexColumn);
					indexRow++;
					indexColumn--;
				}
			}
		}
		return true;
	}
	
}
