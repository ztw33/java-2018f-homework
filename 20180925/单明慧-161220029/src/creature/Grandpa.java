package creature;

import javax.swing.ImageIcon;

public class Grandpa extends Creature{

	public Grandpa(){
		this.name = "老爷爷";
		figure = new ImageIcon("pics/g.png");
		figure.setImage(figure.getImage().getScaledInstance(50, 50, 0));
	}
}
