package thirdHomework;

import javax.swing.ImageIcon;

/*
 * Ð¡à¶†ª
 */

public class Minion extends Creature {

	public Minion(int index) {
		this.name = "à¶†ª" + index;
		this.species = Species.MINION;
		this.icon = new ImageIcon("image/minion.jpg");
		this.standardIcon();
	}
}
