package creature;

import map.Map;

public class ScorpionMonster extends Creature{
	public ScorpionMonster() {
		super.name = "蝎子精";
	}
	public String getName() {
		return super.name;
	}
	public void lead(Map map, int x, int y) {
		move(map.getPos()[x][y]);
	}
}
