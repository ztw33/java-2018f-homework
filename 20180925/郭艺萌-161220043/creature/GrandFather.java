package creature;

import map.Map;

public class GrandFather extends Creature implements Cheer{
	public GrandFather() {
		super.name = "爷爷";
	}
	public String getName() {
		return super.name;
	}
	@Override
	public void cheer(Map map, int x, int y) {
		move(map.getPos()[x][y]);
	}
}
