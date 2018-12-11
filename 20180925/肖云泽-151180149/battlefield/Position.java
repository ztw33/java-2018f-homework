package battlefield;

public class Position {
	protected int x,y;
	public Position() {
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
	public void printPosition() {
		System.out.println("x: " + this.x + "  y:" + this.y);
	}
	public Position add(Position p) {
		this.x = this.x + p.x;
		this.y = this.y + p.y;
		return this;
	}
}
