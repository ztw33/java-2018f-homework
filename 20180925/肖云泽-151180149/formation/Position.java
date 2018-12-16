package formation;

public class Position {
	private int x;
	private int y;
	public Position(){
		this.x = -1;
		this.y = -1;
	}
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public Position add(Position p1) {
		return new Position(this.x + p1.x, this.y + p1.y);
	}
}
