package formation;

import creature.Creature;
import creature.PROPERTY;
import space.BattleField;

public class Heyi implements Formation {

	@Override
	public boolean conjure(BattleField bf, Creature[] creatures, int startRow, int startColumn) {
		// TODO Auto-generated method stub
		PROPERTY property = creatures[0].getProperty();
		int row = bf.getRow(), column = bf.getColumn();
		int size = creatures.length;
		if ((startRow < 0) || (startRow > row - 1) || (startColumn < 0) || (startColumn > column - 1) 
				|| (startRow + size > row)) {
			System.err.println("鹤翼阵布置失败");
			return false;
		}
		switch (property) {
		case GOOD:
			if (startColumn - Math.ceil(size/2.0) < 0) {
				System.err.println("鹤翼阵布置失败");
				return false;
			} else {
				int indexRow = startRow, indexColumn = startColumn;
				int i;
				for (i = 0; i < Math.ceil(size/2.0); i++) {
					bf.setCreatrue(creatures[i], indexRow, indexColumn);
					indexRow++;
					indexColumn--;
				}
				if (size % 2 == 1) {
					indexColumn += 2;
				} else {
					indexColumn++;
				}
				for (; i < size; i++) {
					bf.setCreatrue(creatures[i], indexRow, indexColumn);
					indexRow++;
					indexColumn++;
				}
			}
			
			break;
		case BAD:
			if (startColumn + Math.ceil(size/2.0) > column) {
				System.err.println("鹤翼阵布置失败");
				return false;
			} else {
				int indexRow = startRow, indexColumn = startColumn;
				int i;
				for (i = 0; i < Math.ceil(size/2.0); i++) {
					bf.setCreatrue(creatures[i], indexRow, indexColumn);
					indexRow++;
					indexColumn++;
				}
				if (size % 2 == 1) {
					indexColumn -= 2;
				} else {
					indexColumn--;
				}			
				for (; i < size; i++) {
					bf.setCreatrue(creatures[i], indexRow, indexColumn);
					indexRow++;
					indexColumn--;
				}
			}
			break;
		default:
			break;
		}
		return true;
	}
	
}
