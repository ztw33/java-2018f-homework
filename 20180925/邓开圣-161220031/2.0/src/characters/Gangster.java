package characters;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import ui.Administrator;
import shapes.Location;
public class Gangster extends Creature{
	private static Image img = new ImageIcon("resources/characters/gangster/gangster4.PNG").getImage();
	
	
	public Gangster(Location l,Administrator ad) {
		this.loc = l;
		this.admin = ad;

	}

	public void draw(Graphics g) {
		g.drawImage(img, loc.locx, loc.locy, loc.locx+sizex, loc.locy+sizey, 0, 0, img.getWidth(null), img.getHeight(null), null);
	}
	
	
}
