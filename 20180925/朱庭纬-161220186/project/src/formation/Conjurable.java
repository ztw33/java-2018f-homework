package formation;

import java.util.ArrayList;

import creature.Creature;
import space.BattleField;

public interface Conjurable {
	public boolean conjure(BattleField bf, ArrayList<? extends Creature> creatures, int startRow, int startColumn);
}
