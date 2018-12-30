package calabash;

public class Organism {
	private Attribute attr;
	Coordinate Co;
	Organism(){
		Co = new Coordinate();
	}
	
	public void setAttr(Attribute i){
		attr = i;
	}
	public Attribute getAttr(){
		return attr;
	}
	
	public Coordinate getCoordinate(){
		return Co;
	}
}

class Coordinate{
	private int x;
	private int y;
	Coordinate(){
		x = 0;
		y = 0;
	}
	public void setC(int a,int b){
		x = a;
		y = b;
	}
	public int getCx(){
		return x;
	}
	public int getCy(){
		return y;
	}
}

enum Attribute{ CALABASH, SCORPION, MONSTER,SERPENT,GRANDPA}; //蝎子精，小喽啰，蛇精，爷爷





