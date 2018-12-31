package formation;

import creature.Creature;
import space.BattleField;

public class Henge implements Formation {

	@Override
	public boolean conjure(BattleField bf, Creature[] creatures, int startRow, int startColumn) {
		// TODO Auto-generated method stub
		if ((startRow < 0) || (startRow + creatures.length > bf.getRow()) || (startColumn < 1)) {
			System.err.println("衡轭阵布置失败");
			return false;
		} else {
			int indexRow = startRow, indexColumn = startColumn;
			int i = 0;
			while (i < creatures.length) {
				if (!bf.setCreatrue(creatures[i], indexRow, indexColumn)) {
					System.err.println("衡轭阵布置失败");
					return false;
				}
				indexRow++;
				if (i % 2 == 0) {
					indexColumn--;
				} else {
					indexColumn++;
				}
				i++;
			}
		}
		return true;
	}

}
