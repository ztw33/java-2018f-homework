package formation;

import java.util.ArrayList;

import creature.Creature;
import space.BattleField;

public class Henge<T extends Creature> implements Conjurable {

	@Override
	public boolean conjure(BattleField bf, ArrayList<? extends Creature> creatures, int startRow, int startColumn) {
		// TODO Auto-generated method stub
		if ((startRow < 0) || (startRow + creatures.size() > bf.getRow()) || (startColumn < 1)) {
			System.err.println("衡轭阵布置失败");
			return false;
		} else {
			int indexRow = startRow, indexColumn = startColumn;
			int i = 0;
			while (i < creatures.size()) {
				if (!bf.setCreatrue(creatures.get(i), indexRow, indexColumn)) {
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
