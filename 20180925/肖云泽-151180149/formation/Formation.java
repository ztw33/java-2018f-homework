package formation;

public abstract class Formation {
	String name;
	Position[] array;
	public String getName() {
		return name;
	}
	public Position[] getArray() {
		return array;
	}
	public int getLength() {
		return array.length;
	}
}
