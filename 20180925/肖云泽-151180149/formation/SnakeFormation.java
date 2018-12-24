package formation;

public class SnakeFormation extends Formation {
	public SnakeFormation(int s){
		this.setName();
		this.setScale(s);
		//this.setArray();
	}
	protected void setName() {
		this.name = "Snake";
	}
	protected void setArray() {
		this.array = new Position[this.scale];
		for (int i=0; i<scale; i++) {
			this.array[i] = new Position((scale - 1) / 2, i);
		}
	}
}
