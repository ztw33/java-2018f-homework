package confrontation;


public class Organisms {
	protected String name;
	protected int type;
	public int attack;
	public int morale;
	public Organisms() {
		
	}
	public Organisms(String n) {
		this.name=n;
	}
	public String getName() {
		return name;
	}
	public void setPosition(Position[][] position,int x,int y) {
		position[x][y].setXY(this, x, y);
	} 
	public int getType() {
		return this.type;
	}
}

