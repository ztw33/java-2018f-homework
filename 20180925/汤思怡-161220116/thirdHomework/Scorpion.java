package thirdHomework;

import javax.swing.ImageIcon;

/*
 * 蝎子精
 */

public class Scorpion extends Creature {

	public Scorpion() {
		this.name = "蝎子精";
		this.species = Species.SCORPION;
		this.icon = new ImageIcon("image/scorpion.jpg");
		this.standardIcon();
	}
}
