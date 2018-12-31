package formation;

import creature.Creature;
import space.BattleField;

public interface Formation {
	public boolean conjure(BattleField bf, Creature[] creatures, int startRow, int startColumn);
}
