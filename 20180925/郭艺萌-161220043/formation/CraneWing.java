package formation;

import creature.*;
import map.*;

//（1,10）
public class CraneWing extends Formation{
	public CraneWing() {
		super.name = "鹤翼阵";
	}
	public String getName() {
		return super.name;
	}
	@Override
	public void form(Map map, Creature[] creatures, int x, int y) {
		for (int i = 0; i < 4; i++) {
			if (map.canStand(x+i, y+i)) {
				creatures[i].move(map.getPos()[x+i][y+i]);
			}
		}
		for (int i = 0; i < 3; i++) {
			if (map.canStand(x+2-i, y+4+i)) {
				creatures[i+4].move(map.getPos()[x+2-i][y+4+i]);
			}
		}
	}
	@Override
	public void loose(Map map, Creature[] creatures, int x, int y) {
		for (int i = 0; i < 4; i++) {
			if (map.canRemove(x+i, y+i)) {
				map.getPos()[x+i][y+i].removeCrearure();
			}
		}
		for (int i = 0; i < 3; i++) {
			if (map.canRemove(x+2-i, y+4+i)) {
				map.getPos()[x+2-i][y+4+i].removeCrearure();
			}
		}
	}
}

