package formation;

public abstract class Formation {
	protected String name;
	protected int scale = 7; //default 7
	protected Position[] array;
	/*Formation(int s){
		this.setName();
		this.setScale(s);
		this.setArray();
	}*/
	public String getName() {
		return this.name;
	}
	public int getScale() {
		return this.scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
		this.setArray();
	}
	public int getLength() {
		return this.array.length;
	}
	public Position[] getPosition() {
		return this.array;
	}
	protected abstract void setName();
	protected abstract void setArray();  
}
