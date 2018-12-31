package thirdHomework;

import javax.swing.ImageIcon;

/*
 * Éß¾«
 */

public class Snake extends Creature {

	public Snake() {
		this.name = "Éß¾«";
		this.species = Species.SNAKE;
		this.icon = new ImageIcon("image/snake.jpg");
		this.standardIcon();
	}

}