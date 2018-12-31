package calabash;

public class Creature {  //注意，Creature本身表示虚无；
	protected String name;  //表示生物名称；
	int x;  //表示生物在field中x坐标；
	int y;  //表示生物在field中y坐标；
	int type;  //表示生物属于正义阵营还是邪恶阵营，0表示正义，1表示邪恶；
	
	Creature(){
		name = "一一";
	}
	
	Creature(int ix, int iy){
		name = "一一";
		x = ix;
		y = iy;
	}
	
	public final int getType() {
		return type;
	}
	
	public final int getX() {
		return x;
	}
	
	public final int getY() {
		return y;
	}
	
	public final String getName() {
		return name;
	}
	
	public final void updatePosition(int ix, int iy) {
		x = ix;
		y = iy;
	}
}
