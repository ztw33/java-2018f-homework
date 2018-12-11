package battlefield;

import infos.Infos;
import creature.*;

public enum Formation {
	SNAKE_FORMATION("SNAKE", new Array("SNAKE", Infos.ARRAY_SCALE, new Position(0, 0))),
	ARROW_FORMATION("ARROW", new Array("ARROW", Infos.ARRAY_SCALE, new Position(0, 0))),
	ECHELON_FORMATION("ECHELON", new Array("ECHELON", Infos.ARRAY_SCALE, new Position(0, 0)));
	public String name;
	public Array arr;
	Formation(String name, Array arr) {
		this.name = name;
		this.arr = arr;
	}
}
