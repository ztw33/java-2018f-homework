package formation;

import creature.*;
import map.*;

//（1,19）
public class Yoke extends Formation{
	public Yoke() {
		super.name = "衡轭阵";
	}
	public String getName() {
		return super.name;
	}
	@Override
	public void form(Map map, Creature[] creatures, int x, int y) {
		for (int i = 0; i < 6; i = i+2) {
			if (map.canStand(x+i, y)) {
				creatures[i].move(map.getPos()[x+i][y]);	
			}
		}
		for (int i = 1; i < 6; i = i+2) {
			if (map.canStand(x+i, y-1)) {
				creatures[i].move(map.getPos()[x+i][y-1]);				
			}
		}
	}
	@Override
	public void loose(Map map, Creature[] creatures, int x, int y) {
		for (int i = 0; i < 6; i = i+2) {
			if (map.canRemove(x+i, y)) {
				map.getPos()[x+i][y].removeCrearure();
			}
		}
		for (int i = 1; i < 6; i = i+2) {
			if (map.canRemove(x+i, y-1)) {
				map.getPos()[x+i][y-1].removeCrearure();			
			}
		}
	}
}

