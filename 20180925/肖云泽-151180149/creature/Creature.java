package creature;

import battlefield.Position;

public class Creature {
	protected String name;
	protected Position position;
	// use for sorting
	public int index;
	public Creature() {
		this.name = "Empty";
		this.position = new Position(-1, -1);
		this.index = -1;
	}
	public Creature(String name) {
		this.name = name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	protected void setPosition(int x, int y) {
		this.position = new Position(x, y);
	}
	public Position getPosition() {
		return this.position;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
