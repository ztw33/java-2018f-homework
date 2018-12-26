package formation;

import creature.*;
import map.*;

//（0,15）
public class FishScale extends Formation{
	public FishScale() {
		super.name = "鱼鳞阵";
	}
	public String getName() {
		return super.name;
	}
	@Override
	public void form(Map map, Creature[] creatures, int x, int y) {
		creatures[0].move(map.getPos()[x][y]);
		creatures[1].move(map.getPos()[x+1][y+1]);
		creatures[2].move(map.getPos()[x+2][y-2]);
		creatures[3].move(map.getPos()[x+2][y]);
		creatures[4].move(map.getPos()[x+2][y+2]);
		creatures[5].move(map.getPos()[x+3][y-3]);
		creatures[6].move(map.getPos()[x+3][y-1]);
		creatures[7].move(map.getPos()[x+3][y+1]);
		creatures[8].move(map.getPos()[x+3][y+3]);
		creatures[9].move(map.getPos()[x+4][y]);
	}
	@Override
	public void loose(Map map, Creature[] creatures, int x, int y) {
		map.getPos()[x][y].removeCrearure();
		map.getPos()[x+1][y+1].removeCrearure();
		map.getPos()[x+2][y-2].removeCrearure();
		map.getPos()[x+2][y].removeCrearure();
		map.getPos()[x+2][y+2].removeCrearure();
		map.getPos()[x+3][y-3].removeCrearure();
		map.getPos()[x+3][y-1].removeCrearure();
		map.getPos()[x+3][y+1].removeCrearure();
		map.getPos()[x+3][y+3].removeCrearure();
		map.getPos()[x+4][y].removeCrearure();
	}
}

//
//...*
//....*
//.*.*.*
//*.*.*.*
//...*
