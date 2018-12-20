package formation;

public class EchelonFormation extends Formation {
	public EchelonFormation(int s){
		this.setName();
		this.setScale(s);
		//this.setArray();
	}
	protected void setName() {
		this.name = "Echelon";
	}
	protected void setArray() {
		this.array = new Position[scale];
		for (int i=0; i<scale; i++) {
			this.array[i] = new Position(i, i);
		}
	}
}
