package creature;
enum COLOR {
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}

public class OneCalabash extends Creature{

	private int number;
	private String colorName;
	private COLOR color;
	
	OneCalabash(int no, String colorName, COLOR color, String name){
		this.number = no;
		this.colorName = colorName;
		this.color = color;
		this.name = name;
	}
	public int tellNo() {
    	return this.number;
    }
    String tellColorName() {
    	return this.colorName;
    }
    COLOR tellColor() {
    	return this.color;
    }	
}
