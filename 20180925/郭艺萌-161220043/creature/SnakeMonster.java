package creature;

import map.Map;

public class SnakeMonster extends Creature implements Cheer{
	public SnakeMonster() {
		super.name = "蛇精";
	}
	public String getName() {
		return super.name;
	}
	@Override 
	public void cheer(Map map, int x, int y) {
		move(map.getPos()[x][y]);
	}
}
