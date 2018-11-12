package creature;

public class Creature {
	protected String name;
	public int x;
	public int y;
	Creature(){
		x = -1;
		y = -1;
	}
	public String tellName() {
		return this.name;
	}
	public void setPos(int x ,int y) {
		this.x = x;
		this.y = y;
	}
}
