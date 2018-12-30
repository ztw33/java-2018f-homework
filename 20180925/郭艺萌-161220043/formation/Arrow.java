package formation;

import creature.*;
import map.*;

//（2, 15）
public class Arrow extends Formation{
	public Arrow() {
		super.name = "箭矢阵";
	}
	public String getName() {
		return super.name;
	}
	@Override
	public void form(Map map, Creature[] creatures, int x, int y) {
		for (int i = 0; i < 6; i++) {
			if (map.canStand(x+i, y)) {
				creatures[i].move(map.getPos()[x+i][y]);
			}
		}
		for (int i = 1; i < 4; i++) {
			if (map.canStand(x+i, y-i)) {
				creatures[i+5].move(map.getPos()[x+i][y-i]);
			}
		}
		for (int i = 1; i < 4; i++) {
			if (map.canStand(x+i, y+i)) {
				creatures[i+8].move(map.getPos()[x+i][y+i]);
			}
		}
	}
	@Override
	public void loose(Map map, Creature[] creatures, int x, int y) {
		for (int i = 0; i < 6; i++) {
			if (map.canRemove(x+i, y)) {
				map.getPos()[x+i][y].removeCrearure();
			}
		}
		for (int i = 1; i < 4; i++) {
			if (map.canRemove(x+i, y-i)) {
				map.getPos()[x+i][y-i].removeCrearure();
			}
		}
		for (int i = 1; i < 4; i++) {
			if (map.canRemove(x+i, y+i)) {
				map.getPos()[x+i][y+i].removeCrearure();
			}
		}
	}
}
