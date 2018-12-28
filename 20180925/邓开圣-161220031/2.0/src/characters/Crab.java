package characters;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import ui.Administrator;
import shapes.Location;
public class Crab extends Creature{
	private static Image img = new ImageIcon("resources/characters/crab/crab1.PNG").getImage();
	
	
	public Crab(Location l,Administrator ad) {
		this.loc = l;
		this.admin = ad;
		this.sizex = 100;
		this.sizey = 100;
	}

	public void draw(Graphics g) {
		g.drawImage(img, loc.locx, loc.locy, loc.locx+sizex, loc.locy+sizey, 0, 0, img.getWidth(null), img.getHeight(null), null);
	}
}
