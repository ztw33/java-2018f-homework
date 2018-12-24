package formation;

public class ArrowFormation extends Formation {
	public ArrowFormation(int s){
		this.setName();
		this.setScale(s);
		//this.setArray();
	}
	protected  void setName() {
		this.name = "Arrow";
	}
	protected void setArray() {
		this.array = new Position[this.scale + (this.scale - 1) / 2 + (this.scale - 1) / 2];
		for (int i=0; i<this.scale; i++) {
			this.array[i] = new Position(i, (this.scale - 1) / 2);
		}
		for (int i=1; i<=(this.scale-1)/2; i++) {
			this.array[this.scale + i - 1] = new Position(i, (this.scale - 1) / 2 - i);
		}
		for (int i=1; i<=(this.scale-1)/2; i++) {
			this.array[this.scale + (this.scale - 1) / 2 - 1 + i] = new Position(i, (this.scale - 1) / 2 + i);
		}
	}
}
