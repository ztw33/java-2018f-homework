package battlefield;

public class Array {
	// Suppose an "Array" is a M*M array.M is equal to "scale",and "startpoint" starts from leftdown with (0,0)
	public int scale;
	public Position startpoint;
	public Position[] array;
	
	public Array() {
		this.scale = 0;
		this.startpoint = new Position(0, 0);
		this.array = new Position[0];
	}
	public Array (String name, int scale, Position startpoint) {
		if (scale <= 0) {
			System.out.println("You must be kidding me,Please enter the correct scale");
			return;
		}
		switch (name) {
		case "SNAKE":
			this.array = new Position[scale];
			for (int i=0; i<scale; i++) {
				// must new to build each object
				this.array[i] = new Position((scale - 1) / 2, i);
			}
			break;
		case "ARROW":
			this.array = new Position[scale + (scale - 1) / 2 + (scale - 1) / 2];
			for (int i=0; i<scale; i++) {
				this.array[i] = new Position(i, (scale - 1) / 2);
			}
			for (int i=1; i<=(scale-1)/2; i++) {
				this.array[scale + i - 1] = new Position(i, (scale - 1) / 2 - i);
			}
			for (int i=1; i<=(scale-1)/2; i++) {
				this.array[scale + (scale - 1) / 2 - 1 + i] = new Position(i, (scale - 1) / 2 + i);
			}
			break;
		case "ECHELON":
			this.array = new Position[scale];
			for (int i=0; i<scale; i++) {
				this.array[i] = new Position(i, i);
			}
			break;
		default:
			System.out.println("You must be kidding me,Please enter the correct name of Array");
			return;
		}
		this.scale = scale;
		this.startpoint = startpoint;
		return;
	}
	public void setArray(String name, int scale, Position startpoint) {
		Array a = new Array(name, scale, startpoint);
		this.array = a.array;
		this.scale = a.scale;
		this.startpoint = a.startpoint;
	}
	public void setStartpoint(Position startpoint) {
		this.startpoint = startpoint;
	}
	public void printArray() {
		for (int i=0; i<this.array.length; i++) {
			this.array[i].printPosition();
		}
	}
	// anticlockwise 90 degree
	public void normalize() {
		for (int i=0; i<array.length; i++) {
			array[i] = array[i].add(startpoint);
		}
		this.startpoint = new Position(0, 0);
	}
}
