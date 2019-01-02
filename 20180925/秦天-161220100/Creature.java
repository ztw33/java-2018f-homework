//package qt;

public abstract class Creature {
	private String name;
	private Position position=new Position();
	public void setName(String name) {
		this.name=name;
	}
	public int getX() {
		return position.getX();
	}
	public int getY() {
		return position.getY();
	}
	public void setPosition(int x,int y) {
		position.set(x, y);
	}
	public void setPosition(Position position) {
		this.position.set(position.getX(), position.getY());
	}
	public String toString() {
		return name;
	}
}
