package creature;

import javax.swing.ImageIcon;

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
		
		switch(no){
			case 0:
				figure = new ImageIcon("pics/c1.png");break;
			case 1:
				figure = new ImageIcon("pics/c2.png");break;
			case 2:
				figure = new ImageIcon("pics/c3.png");break;
			case 3:
				figure = new ImageIcon("pics/c4.png");break;
			case 4:
				figure = new ImageIcon("pics/c5.png");break;
			case 5:
				figure = new ImageIcon("pics/c6.png");break;
			case 6:
				figure = new ImageIcon("pics/c7.png");break;
		}
		figure.setImage(figure.getImage().getScaledInstance(50, 50, 0));
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
